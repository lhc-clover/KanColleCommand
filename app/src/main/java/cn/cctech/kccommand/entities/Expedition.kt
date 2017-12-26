package cn.cctech.kccommand.entities

import android.content.Context
import cn.cctech.kccommand.R
import cn.cctech.kccommand.events.api.Deck
import cn.cctech.kccommand.events.api.Port
import cn.cctech.kccommand.managers.BasicManager
import cn.cctech.kccommand.utils.kExpeditionMap
import com.orhanobut.logger.Logger

class Expedition {

    var missionId: String = "0"
    var fleetIndex: Int = -1
    var returnTime: Long = -1

    val countDown: Int
        get() {
            var countdown = 0
            if (returnTime >= 0) {
                val now = System.currentTimeMillis()
                countdown = ((returnTime - now) / 1000).toInt()
            }
            return Math.max(countdown, 0)
        }

    constructor()

    constructor(entity: Deck.ApiDataBean) {
        try {
            fleetIndex = entity.api_id
            missionId = entity.api_mission[1]
            val time = java.lang.Long.parseLong(entity.api_mission[2])
            returnTime = if (time == 0L && missionId == "0" && fleetIndex == 0) -1 else time
        } catch (e: Exception) {
            returnTime = -1
            Logger.e(e, e.message)
        }
    }

    constructor(entity: Port.ApiDataEntity.ApiDeckPortEntity) {
        try {
            fleetIndex = entity.api_id
            missionId = entity.api_mission[1]
            val time = java.lang.Long.parseLong(entity.api_mission[2])
            returnTime = if (time == 0L) -1 else time
        } catch (e: Exception) {
            returnTime = -1
            Logger.e(e, e.message)
        }
    }

    fun getTitle(context: Context): String {
        val count = BasicManager.basic.deckCount
        return if (fleetIndex in 2..count) {
            if (missionId == "0") context.getString(R.string.dock_expedition_idle)
            else context.getString(R.string.dock_expedition_description, mission(), description())
        } else context.getString(R.string.dock_expedition_lock)
    }

    fun getFormatCountDown(context: Context): String {
        return if (missionId != "0" && returnTime >= 0) {
            val countdown = countDown
            val hour = countdown / 3600
            val minute = countdown / 60 - hour * 60
            val second = countdown % 60
            context.getString(R.string.expedition_count_down, hour, minute, second)
        } else {
            ""
        }
    }

    fun valid(): Boolean {
        return missionId != "0" && fleetIndex >= 0
    }

    fun mission(): Int = try {
        missionId.toInt()
    } catch (e: Exception) {
        -1
    }

    fun description(): String = kExpeditionMap.getOrElse(mission(), defaultValue = { "" })

}
