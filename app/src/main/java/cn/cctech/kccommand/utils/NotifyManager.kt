package cn.cctech.kccommand.utils

import android.app.PendingIntent
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.support.v4.content.ContextCompat
import cn.cctech.kancolle.oyodo.Oyodo
import cn.cctech.kancolle.oyodo.entities.Expedition
import cn.cctech.kancolle.oyodo.managers.*
import cn.cctech.kccommand.MainActivity
import cn.cctech.kccommand.R
import com.doist.jobschedulercompat.*
import com.orhanobut.logger.Logger
import java.text.SimpleDateFormat
import java.util.*

object NotifyManager {

    private const val sExpeditionMask = 100000
    private const val sRepairMask = 300000
    private const val sBuildMask = 500000
    private const val sCondMask = 700000

    private const val EXTRA_TITLE = "title"
    private const val EXTRA_CONTENT = "content"
    private const val EXTRA_ICON = "icon"

    private var callback: Callback? = null

    fun setup(cb: Callback) {
        Logger.d("Notify setup")
        callback = cb
        Dock.repairList.forEach {
            Oyodo.attention().watch(it, { repair ->
                if (repair.valid()) addJob(sRepairMask, repair.id, getCountDown(repair.completeTime))
            })
        }
        Dock.buildList.forEach {
            Oyodo.attention().watch(it, { build ->
                if (build.valid()) addJob(sBuildMask, build.id, getCountDown(build.completeTime))
            })
        }
        Dock.expeditionList.forEach {
            Oyodo.attention().watch(it, { expedition ->
                if (expedition.valid())
                    addJob(sExpeditionMask, expedition.fleetIndex, getCountDown(expedition.returnTime))
            })
        }
        Oyodo.attention().watch(Fleet.shipWatcher, {
            if (it is Transform.All) {
                (0 until User.deckCount.value).forEach {
                    val time = getCondRecoveryTime(it)
                    if (time > 0)
                        addJob(sCondMask, it + 1, getCountDown(time))
                }
            }
        })
    }

    private fun addJob(mask: Int, id: Int, countDown: Int) {
        val jobId = mask + id
        clearPendingJob(jobId)
        val notifyTimeMillis = Math.max((countDown - 60) * 1000L, 0)
        val scheduler = JobScheduler.get(callback?.getContext())
        val builder = JobInfo.Builder(jobId, ComponentName(callback?.getContext()?.packageName, MyJobService::class.java.name))
                .setMinimumLatency(notifyTimeMillis)
                .setOverrideDeadline(notifyTimeMillis + 10 * 1000)
                .setBackoffCriteria(10 * 1000, JobInfo.BACKOFF_POLICY_LINEAR)
                .setExtras(buildExtra(mask, id))
        scheduler.schedule(builder.build())

        val timeStr = SimpleDateFormat.getDateTimeInstance().format(Date(System.currentTimeMillis() + notifyTimeMillis))
        Logger.d("Schedule $jobId at $timeStr")
    }

    private fun buildExtra(mask: Int, id: Int): PersistableBundle {
        val index = id - 1
        val extra = PersistableBundle()
        var title = ""
        var content = ""
        var largeIconRes = -1
        val context = callback!!.getContext()
        try {
            when (mask) {
                sExpeditionMask -> {
                    title = context.getString(R.string.notify_expedition_title)
                    val expedition = Dock.expeditionList[index].value
                    content = getExpeditionDescription(context, expedition)
                    largeIconRes = R.drawable.expedition
                }
                sRepairMask -> {
                    title = context.getString(R.string.notify_repair_title)
                    val repair = Dock.repairList[index]
                    val ship = Fleet.shipMap[repair.value.shipId]
                    content = context.getString(R.string.notify_repair_content, ship?.name)
                    largeIconRes = R.drawable.repair
                }
                sBuildMask -> {
                    title = context.getString(R.string.notify_build_title)
                    val build = Dock.buildList[index]
                    val ship = Fleet.shipMap[build.value.shipId]
                    content = context.getString(R.string.notify_build_content, ship?.name)
                    largeIconRes = R.drawable.build
                }
                sCondMask -> {
                    title = context.getString(R.string.notify_cond_title)
                    val name = Fleet.deckNames[index].value
                    content = context.getString(R.string.notify_cond_content, id, name)
                }
            }
            Logger.d("Extras\ntitle:$title\ncontent:$content")
            extra.putString(EXTRA_TITLE, title)
            extra.putString(EXTRA_CONTENT, content)
            extra.putInt(EXTRA_ICON, largeIconRes)
        } catch (e: Exception) {
            Logger.e(e, "Error build extra $mask-$id")
        }
        return extra
    }

    private fun clearPendingJob(jobId: Int) {
        val scheduler = JobScheduler.get(callback?.getContext())
        val jobs: List<JobInfo> = scheduler.allPendingJobs.filter { it.id == jobId }
        for (job in jobs) {
            scheduler.cancel(job.id)
        }
    }

    class MyJobService : JobService() {

        override fun onStopJob(p0: JobParameters?): Boolean {
            return false
        }

        override fun onStartJob(p0: JobParameters?): Boolean {
            notify(p0?.jobId ?: -1, p0?.extras)
            return false
        }

        private fun notify(jobId: Int, extras: PersistableBundle?) {
            Logger.d("Will notify $jobId")
            if (jobId <= 0) return
            try {
                val title = extras?.getString(EXTRA_TITLE) ?: ""
                val content = extras?.getString(EXTRA_CONTENT) ?: ""
                val largeIconRes = extras?.getInt(EXTRA_ICON) ?: -1
                val pendingIntent = PendingIntent.getActivity(this, jobId,
                        Intent(this, MainActivity::class.java), PendingIntent.FLAG_UPDATE_CURRENT)
                val builder = JNotify.build(callback?.getContext()!!)
                builder.setContentTitle(title)
                        .setContentText(content)
                        .setSmallIcon(R.drawable.ic_notify_small)
                        .setDefaultVibrate()
                        .setDefaultSound()
                        .setContentIntent(pendingIntent)
                if (largeIconRes > 0) {
                    val largeIcon = (ContextCompat.getDrawable(this, largeIconRes) as BitmapDrawable).bitmap
                    builder.setLargeIcon(largeIcon)
                }
                builder.notify(jobId)
            } catch (e: Exception) {
                Logger.e(e, "Error notify $jobId")
            }
        }
    }

    private fun getExpeditionDescription(context: Context, expedition: Expedition?): String {
        return expedition?.let {
            val name = Fleet.deckNames[expedition.fleetIndex - 1].value
            val num = try {
                expedition.missionId.toInt()
            } catch (e: Exception) {
                0
            }
            val description = kExpeditionMap.getOrElse(num, defaultValue = { "" })
            context.getString(R.string.notify_expedition_content,
                    expedition.fleetIndex, name, num, description)
        } ?: ""
    }

    interface Callback {
        fun getContext(): Context
    }
}
