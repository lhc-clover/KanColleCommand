package cn.cctech.kccommand.utils

import android.content.Context
import cn.cctech.kancolle.oyodo.entities.Build
import cn.cctech.kancolle.oyodo.entities.Expedition
import cn.cctech.kancolle.oyodo.entities.Repair
import cn.cctech.kancolle.oyodo.managers.Fleet
import cn.cctech.kancolle.oyodo.managers.Raw
import cn.cctech.kancolle.oyodo.managers.User
import cn.cctech.kccommand.R

fun getExpeditionTitle(context: Context, expedition: Expedition?): String {
    val missionId = try {
        expedition!!.missionId.toInt()
    } catch (e: Exception) {
        -1
    }
    val count = User.deckCount.value ?: 0
    return if (expedition?.fleetIndex in 2..count) {
        val description = kExpeditionMap.getOrElse(missionId, defaultValue = { "" })
        if (expedition?.missionId == "0") context.getString(R.string.dock_expedition_idle)
        else context.getString(R.string.dock_expedition_description, missionId, description)
    } else {
        context.getString(R.string.dock_expedition_lock)
    }
}

fun getExpeditionTime(context: Context, expedition: Expedition?): String {
    return getFormatCountDown(context, expedition?.returnTime ?: -1)
}

fun getRepairTitle(context: Context, repair: Repair?): String {
    val count = User.nDockCount.value ?: 0
    return if (repair?.id in 1..count) {
        Fleet.shipMap[repair?.shipId]?.name
                ?: context.getString(R.string.dock_repair_idle)
    } else context.getString(R.string.dock_repair_lock)
}

fun getRepairTime(context: Context, repair: Repair?): String {
    return getFormatCountDown(context, repair?.completeTime ?: -1)
}

fun getBuildTitle(context: Context, build: Build?): String {
    val count = User.kDockCount.value ?: 0
    return if (build?.id in 1..count) {
        Raw.rawShipMap[build?.shipId]?.api_name
                ?: context.getString(R.string.dock_build_idle)
    } else context.getString(R.string.dock_build_lock)
}

fun getBuildTime(context: Context, build: Build?): String {
    return getFormatCountDown(context, build?.completeTime ?: -1)
}

fun getFormatCountDown(context: Context, time: Long): String {
    return if (time >= 0) {
        val countdown = getCountDown(time)
        val hour = countdown / 3600
        val minute = countdown / 60 - hour * 60
        val second = countdown % 60
        context.getString(R.string.time_count_down, hour, minute, second)
    } else {
        ""
    }
}

fun getCountDown(time: Long): Int {
    return try {
        val now = System.currentTimeMillis()
        val diff = ((time - now) / 1000).toInt()
        Math.max(diff, 0)
    } catch (e: Exception) {
        0
    }
}
