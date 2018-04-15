package cn.cctech.kccommand.utils

import android.app.PendingIntent
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.support.v4.content.ContextCompat
import cn.cctech.kancolle.oyodo.Oyodo
import cn.cctech.kancolle.oyodo.entities.Expedition
import cn.cctech.kancolle.oyodo.managers.Dock
import cn.cctech.kancolle.oyodo.managers.Fleet
import cn.cctech.kccommand.MainActivity
import cn.cctech.kccommand.R
import com.doist.jobschedulercompat.JobInfo
import com.doist.jobschedulercompat.JobParameters
import com.doist.jobschedulercompat.JobScheduler
import com.doist.jobschedulercompat.JobService
import com.orhanobut.logger.Logger
import java.text.SimpleDateFormat
import java.util.*

@Suppress("unused")
object NotifyManager {

    private const val sExpeditionMask = 100000
    private const val sRepairMask = 500000
    private const val sBuildMask = 900000

    private var callback: Callback? = null

    fun setup(cb: Callback) {
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
    }

    private fun addJob(mask: Int, id: Int, countDown: Int) {
        val jobId = mask + id
        val notifyTimeMillis = Math.max((countDown - 60) * 1000L, 0)
        val scheduler = JobScheduler.get(callback?.getContext())
        val builder = JobInfo.Builder(jobId, ComponentName(callback?.getContext()?.packageName, MyJobService::class.java.name))
                .setMinimumLatency(notifyTimeMillis)
                .setOverrideDeadline(notifyTimeMillis + 10 * 1000)
                .setBackoffCriteria(10 * 1000, JobInfo.BACKOFF_POLICY_LINEAR)
        scheduler.schedule(builder.build())

        val timeStr = SimpleDateFormat.getDateTimeInstance().format(Date(System.currentTimeMillis() + notifyTimeMillis))
        Logger.d("Schedule $jobId at $timeStr")
    }

    private fun clearPendingJobs(mask: Int) {
        val scheduler = JobScheduler.get(callback?.getContext())
        val jobs: List<JobInfo> = scheduler.allPendingJobs.filter {
            it.id.div(mask) == 1
        }
        for (job in jobs) {
            scheduler.cancel(job.id)
        }
    }

    private fun clearNotifications(ids: List<Int>) {
        val notifyBuilder = JNotify.build(callback?.getContext()!!)
        ids.forEach { notifyBuilder.cancel(it) }
    }

    private fun getMaskIdList(mask: Int, count: Int): List<Int> {
        return (1..count + 1).map { mask + it }
    }

    class MyJobService : JobService() {

        override fun onStopJob(p0: JobParameters?): Boolean {
            return false
        }

        override fun onStartJob(p0: JobParameters?): Boolean {
            notify(p0?.jobId ?: -1)
            return false
        }

        private fun notify(jobId: Int) {
            Logger.d("Will notify $jobId")
            if (jobId <= 0) return
            var title = ""
            var content = ""
            var largeIconRes = -1
            try {
                when (jobId.div(100000)) {
                    1 -> {
                        title = callback!!.getContext().getString(R.string.notify_expedition_title)
                        val id = jobId - sExpeditionMask - 1
                        val expedition = Dock.expeditionList[id].value
                        content = getExpeditionDescription(callback!!.getContext(), expedition)
                        largeIconRes = R.drawable.expedition
                    }
                    5 -> {
                        title = callback!!.getContext().getString(R.string.notify_repair_title)
                        val id = jobId - sRepairMask - 1
                        val repair = Dock.repairList[id]
                        val ship = Fleet.shipMap[repair.value.shipId]
                        content = callback!!.getContext().getString(R.string.notify_repair_content, ship?.name)
                        largeIconRes = R.drawable.repair
                    }
                    9 -> {
                        title = callback!!.getContext().getString(R.string.notify_build_title)
                        val id = jobId - sBuildMask - 1
                        val build = Dock.buildList[id]
                        val ship = Fleet.shipMap[build.value.shipId]
                        content = callback!!.getContext().getString(R.string.notify_build_content, ship?.name)
                        largeIconRes = R.drawable.build
                    }
                }
                if (title.isNotEmpty() && content.isNotEmpty() && largeIconRes > 0) {
                    val largeIcon = (ContextCompat.getDrawable(this, largeIconRes) as BitmapDrawable).bitmap
                    val pendingIntent = PendingIntent.getActivity(this, jobId,
                            Intent(this, MainActivity::class.java), PendingIntent.FLAG_UPDATE_CURRENT)
                    JNotify.build(callback?.getContext()!!).setContentTitle(title).setContentText(content)
                            .setSmallIcon(R.drawable.ic_notify_small)
                            .setLargeIcon(largeIcon)
                            .setDefaultVibrate()
                            .setDefaultSound()
                            .setContentIntent(pendingIntent)
                            .notify(jobId)
                }
            } catch (e: Exception) {

            }
        }

    }

    fun getExpeditionDescription(context: Context, expedition: Expedition?): String {
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
