package cn.cctech.kccommand.managers

import android.app.PendingIntent
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.support.v4.content.ContextCompat
import cn.cctech.kccommand.MainActivity
import cn.cctech.kccommand.R
import cn.cctech.kccommand.entities.BuildDock
import cn.cctech.kccommand.entities.Expedition
import cn.cctech.kccommand.entities.RepairDock
import cn.cctech.kccommand.events.api.Deck
import cn.cctech.kccommand.events.api.Kdock
import cn.cctech.kccommand.events.api.Ndock
import cn.cctech.kccommand.utils.JNotify
import com.doist.jobschedulercompat.JobInfo
import com.doist.jobschedulercompat.JobParameters
import com.doist.jobschedulercompat.JobScheduler
import com.doist.jobschedulercompat.JobService
import com.orhanobut.logger.Logger
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.text.SimpleDateFormat
import java.util.*

@Suppress("unused")
object NotifyManager : IManager() {

    private const val sExpeditionMask = 100000
    private const val sRepairMask = 500000
    private const val sBuildMask = 900000

    var callback: Callback? = null

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onNdock(event: Ndock) {
        if (event.api_result == 1) {
            clearPendingJobs(sRepairMask)
            event.api_data.forEach {
                val repair = RepairDock(it)
                if (repair.valid())
                    addJob(sRepairMask, repair.id, repair.countDown)
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onDeck(event: Deck) {
        if (event.api_result == 1) {
            clearPendingJobs(sExpeditionMask)
            event.api_data.forEach {
                val expedition = Expedition(it)
                if (expedition.valid())
                    addJob(sExpeditionMask, expedition.fleetIndex, expedition.countDown)
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onKdock(event: Kdock) {
        if (event.api_result == 1) {
            clearPendingJobs(sBuildMask)
            event.api_data.forEach {
                val build = BuildDock(it)
                if (build.valid())
                    addJob(sBuildMask, build.id, build.countDown)
            }
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
                        val expedition = DockManager.expeditionList[id]
                        content = callback!!.getContext().getString(R.string.notify_expedition_content,
                                expedition.fleetIndex, ShipManager.getFleetName(expedition.fleetIndex - 1),
                                expedition.mission(), expedition.description())
                        largeIconRes = R.drawable.expedition
                    }
                    5 -> {
                        title = callback!!.getContext().getString(R.string.notify_repair_title)
                        val id = jobId - sRepairMask - 1
                        val repair = DockManager.repairDockList[id]
                        val ship = ShipManager.getShipById(repair.shipId)
                        content = callback!!.getContext().getString(R.string.notify_repair_content, ship?.name)
                        largeIconRes = R.drawable.repair
                    }
                    9 -> {
                        title = callback!!.getContext().getString(R.string.notify_build_title)
                        val id = jobId - sBuildMask - 1
                        val build = DockManager.buildDockList[id]
                        val ship = ShipManager.getShipById(build.shipId)
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

    interface Callback {
        fun getContext(): Context
    }
}
