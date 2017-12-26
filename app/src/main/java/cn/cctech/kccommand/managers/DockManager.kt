package cn.cctech.kccommand.managers

import cn.cctech.kccommand.entities.BuildDock
import cn.cctech.kccommand.entities.Expedition
import cn.cctech.kccommand.entities.RepairDock
import cn.cctech.kccommand.events.api.*
import cn.cctech.kccommand.events.ui.DockRefresh
import cn.cctech.kccommand.events.ui.FleetRefresh
import com.orhanobut.logger.Logger
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.*

@Suppress("unused")
object DockManager : IManager() {

    val expeditionList = ArrayList<Expedition>()
    val buildDockList = ArrayList<BuildDock>()
    val repairDockList = ArrayList<RepairDock>()

    fun isFleetOnExpedition(fleet: Int): Boolean {
        val expedition = expeditionList.find { it.fleetIndex == fleet + 1 }
        return try {
            expedition?.missionId?.toInt()!! > 0
        } catch (e: Exception) {
            false
        }
    }

    fun isShipRepairing(shipId: Int): Boolean = repairDockList.any { shipId == it.shipId }

    private fun notifyDockRefresh() {
        val event = DockRefresh()
        event.dispatch()
    }

    private fun notifyFleetRefresh() {
        val event = FleetRefresh()
        event.dispatch()
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onPort(event: Port) {
        if (event.api_result == 1) {
            try {
                expeditionList.clear()
                event.api_data.api_deck_port.mapTo(expeditionList) { Expedition(it) }
                repairDockList.clear()
                event.api_data.api_ndock.mapTo(repairDockList) { RepairDock(it) }
            } catch (e: Exception) {
                Logger.e(e, e.message)
            }
            notifyDockRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onDeck(event: Deck) {
        if (event.api_result == 1) {
            expeditionList.clear()
            event.api_data.mapTo(expeditionList) { Expedition(it) }
            notifyDockRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onKdock(event: Kdock) {
        if (event.api_result == 1) {
            buildDockList.clear()
            event.api_data.mapTo(buildDockList) { BuildDock(it) }
            notifyDockRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onNdock(event: Ndock) {
        if (event.api_result == 1) {
            repairDockList.clear()
            event.api_data.mapTo(repairDockList) { RepairDock(it) }
            notifyDockRefresh()
            notifyFleetRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onGetShip(event: GetShip) {
        if (event.api_result == 1) {
            buildDockList.clear()
            event.api_data.api_kdock.mapTo(buildDockList) { BuildDock(it) }
            notifyDockRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onSpeedChange(event: SpeedChange) {
        if (event.api_result == 1 && event.inflate()) {
            val index = event.api_ndock_id - 1
            val repairDock = repairDockList[index]
            val shipId = repairDock.shipId
            repairDock.clear()
            ShipManager.setShipRepaired(shipId)
            notifyDockRefresh()
        }
    }

}
