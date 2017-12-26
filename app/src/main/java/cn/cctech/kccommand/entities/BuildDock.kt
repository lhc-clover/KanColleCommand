package cn.cctech.kccommand.entities

import android.content.Context
import cn.cctech.kccommand.R
import cn.cctech.kccommand.events.api.GetShip
import cn.cctech.kccommand.events.api.Kdock
import cn.cctech.kccommand.managers.BasicManager
import cn.cctech.kccommand.managers.ShipManager
import com.orhanobut.logger.Logger

class BuildDock {

    var id: Int = -1
    var state: Int = 1
    var shipId: Int = -1
    var completeTime: Long = -1L

    val countDown: Int
        get() {
            var countdown = 0
            if (completeTime > 0) {
                val now = System.currentTimeMillis()
                countdown = ((completeTime - now) / 1000).toInt()
            }
            return Math.max(countdown, 0)
        }

    constructor(index: Int) {
        id = index
    }

    constructor(entity: Kdock.ApiDataBean?) {
        try {
            id = entity?.api_id ?: -1
            state = entity?.api_state ?: 1
            shipId = entity?.api_created_ship_id ?: -1
            val time = entity?.api_complete_time ?: -1L
            completeTime = if (state <= 0L || shipId <= 0) -1 else time
        } catch (e: Exception) {
            Logger.e(e, e.message)
        }
    }

    constructor(entity: GetShip.ApiDataBean.ApiKdockBean?) {
        try {
            id = entity?.api_id ?: -1
            state = entity?.api_state ?: 1
            shipId = entity?.api_created_ship_id ?: -1
            val time = entity?.api_complete_time ?: -1L
            completeTime = if (state <= 0L || shipId <= 0) -1 else time
        } catch (e: Exception) {
            Logger.e(e, e.message)
        }
    }

    fun getTitle(context: Context): String {
        val count = BasicManager.basic.kDockCount
//        return try {
//            val none = if (id <= count) "未使用" else "未解锁"
//            ShipManager.getShipById(shipId)?.name ?: none
//        } catch (e: Exception) {
//            "未知"
//        }
        return if (id in 1..count) {
            ShipManager.getShipById(shipId)?.name ?: "未使用"
        } else "未解锁"
    }

    fun getFormatCountDown(context: Context): String {
        return if (completeTime >= 0) {
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
        return state > 0 && shipId > 0
    }
}