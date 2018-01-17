package cn.cctech.kccommand.managers

import cn.cctech.kccommand.entities.Basic
import cn.cctech.kccommand.events.api.*
import cn.cctech.kccommand.events.ui.BasicRefresh
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@Suppress("unused")
object BasicManager : IManager() {

    var basic = Basic()
        private set

    fun notifyBasicRefresh() {
        val event = BasicRefresh()
        event.dispatch()
    }

    fun recountSlotItem() {
        basic.slotCount = EquipManager.getEquipCount()
        notifyBasicRefresh()
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onPort(event: Port) {
        if (event.api_result == 1) {
            basic = Basic(event)
            notifyBasicRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onCharge(event: Charge) {
        if (event.api_result == 1) {
            val fuel = event.api_data?.api_material?.getOrNull(0)
            fuel?.let { basic.fuel = fuel }
            val ammo = event.api_data?.api_material?.getOrNull(1)
            ammo?.let { basic.ammo = ammo }
            val metal = event.api_data?.api_material?.getOrNull(2)
            metal?.let { basic.metal = metal }
            val bauxite = event.api_data?.api_material?.getOrNull(3)
            bauxite?.let { basic.bauxite = bauxite }
            notifyBasicRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onMaterial(event: Material) {
        if (event.api_result == 1) {
            val fuel = event.api_data?.getOrNull(0)?.api_value
            fuel?.let { basic.fuel = fuel }
            val ammo = event.api_data?.getOrNull(1)?.api_value
            ammo?.let { basic.ammo = ammo }
            val metal = event.api_data?.getOrNull(2)?.api_value
            metal?.let { basic.metal = metal }
            val bauxite = event.api_data?.getOrNull(3)?.api_value
            bauxite?.let { basic.bauxite = bauxite }
            val burner = event.api_data?.getOrNull(4)?.api_value
            burner?.let { basic.burner = burner }
            val bucket = event.api_data?.getOrNull(5)?.api_value
            bucket?.let { basic.bucket = bucket }
            val research = event.api_data?.getOrNull(6)?.api_value
            research?.let { basic.research = research }
            val improve = event.api_data?.getOrNull(7)?.api_value
            improve?.let { basic.improve = improve }
            notifyBasicRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onNdock(event: Ndock) {
        if (event.api_result == 1) {
            event.api_data?.forEach {
                basic.fuel -= it.api_item1
                basic.ammo -= it.api_item2
                basic.metal -= it.api_item3
                basic.bauxite -= it.api_item4
            }
            notifyBasicRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onKdock(event: Kdock) {
        if (event.api_result == 1) {
            event.api_data?.forEach {
                basic.fuel -= it.api_item1
                basic.ammo -= it.api_item2
                basic.metal -= it.api_item3
                basic.bauxite -= it.api_item4
            }
            notifyBasicRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onSpeedChange(event: SpeedChange) {
        if (event.api_result == 1 && event.inflate()) {
            basic.bucket -= 1
            notifyBasicRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onDestroyShip(event: DestroyShip) {
        if (event.api_result == 1) {
            event.paramMap?.get("api_ship_id")?.split("%2C")?.forEach {
                val shipId = try {
                    it.toInt()
                } catch (e: Exception) {
                    -1
                }
                val withSlot = event.paramMap?.get("api_slot_dest_flag") == "1"
                if (withSlot) {
                    val ship = ShipManager.getShipById(shipId)
                    ship?.items?.forEach { EquipManager.removeEquip(it) }
                    basic.slotCount = EquipManager.getEquipCount()
                }
                ShipManager.removeShip(shipId)
                basic.shipCount = ShipManager.getShipCount()
                ShipManager.notifyFleetRefresh()
            }

            val fuel = event.api_data.api_material.getOrNull(0)
            fuel?.let { basic.fuel = fuel }
            val ammo = event.api_data.api_material.getOrNull(1)
            ammo?.let { basic.ammo = ammo }
            val metal = event.api_data.api_material.getOrNull(2)
            metal?.let { basic.metal = metal }
            val bauxite = event.api_data.api_material.getOrNull(3)
            bauxite?.let { basic.bauxite = bauxite }
            notifyBasicRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onCreateItem(event: CreateItem) {
        if (event.api_result == 1) {
            val fuel = event.api_data?.api_material?.getOrNull(0)
            fuel?.let { basic.fuel = fuel }
            val ammo = event.api_data.api_material.getOrNull(1)
            ammo?.let { basic.ammo = ammo }
            val metal = event.api_data.api_material.getOrNull(2)
            metal?.let { basic.metal = metal }
            val bauxite = event.api_data.api_material.getOrNull(3)
            bauxite?.let { basic.bauxite = bauxite }
            val burner = event.api_data.api_material.getOrNull(4)
            burner?.let { basic.burner = burner }
            val bucket = event.api_data.api_material.getOrNull(5)
            bucket?.let { basic.bucket = bucket }
            val research = event.api_data.api_material.getOrNull(6)
            research?.let { basic.research = research }
            val improve = event.api_data.api_material.getOrNull(7)
            improve?.let { basic.improve = improve }

            if (event.api_data?.api_create_flag == 1) {
                val item = event.api_data.api_slot_item
                EquipManager.addNewEquip(item.api_id, item.api_slotitem_id)
                basic.slotCount = EquipManager.getEquipCount()
            }

            notifyBasicRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onDestroyItem(event: DestroyItem) {
        if (event.api_result == 1) {
            basic.fuel += event.api_data?.api_get_material?.getOrNull(0) ?: 0
            basic.ammo += event.api_data?.api_get_material?.getOrNull(1) ?: 0
            basic.metal += event.api_data?.api_get_material?.getOrNull(2) ?: 0
            basic.bauxite += event.api_data?.api_get_material?.getOrNull(3) ?: 0
            event.paramMap?.get("api_slotitem_ids")?.split("%2C")?.forEach {
                val equipId = try {
                    it.toInt()
                } catch (e: Exception) {
                    -1
                }
                if (equipId > 0) {
                    EquipManager.removeEquip(equipId)
                }
            }
            basic.slotCount = EquipManager.getEquipCount()
            notifyBasicRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onGetShip(event: GetShip) {
        if (event.api_result == 1) {
            val shipData = event.api_data?.api_ship
            if (shipData != null) {
                ShipManager.addNewShip(shipData)
                basic.shipCount = ShipManager.getShipCount()
                event.api_data?.api_slotitem?.forEach {
                    EquipManager.addNewEquip(it.api_id, it.api_slotitem_id)
                }
                basic.slotCount = EquipManager.getEquipCount()
            }
            notifyBasicRefresh()
        }
    }

}
