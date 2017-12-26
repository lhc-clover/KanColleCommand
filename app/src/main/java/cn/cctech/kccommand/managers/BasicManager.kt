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

    private fun notifyBasicRefresh() {
        val event = BasicRefresh()
        event.dispatch()
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
            val fuel = event.api_data?.api_material?.get(0)
            fuel?.let { basic.fuel = fuel }
            val ammo = event.api_data?.api_material?.get(1)
            ammo?.let { basic.ammo = ammo }
            val metal = event.api_data?.api_material?.get(2)
            metal?.let { basic.metal = metal }
            val bauxite = event.api_data?.api_material?.get(3)
            bauxite?.let { basic.bauxite = bauxite }
            notifyBasicRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onMaterial(event: Material) {
        if (event.api_result == 1) {
            val fuel = event.api_data?.get(0)?.api_value
            fuel?.let { basic.fuel = fuel }
            val ammo = event.api_data?.get(1)?.api_value
            ammo?.let { basic.ammo = ammo }
            val metal = event.api_data?.get(2)?.api_value
            metal?.let { basic.metal = metal }
            val bauxite = event.api_data?.get(3)?.api_value
            bauxite?.let { basic.bauxite = bauxite }
            val burner = event.api_data?.get(4)?.api_value
            burner?.let { basic.burner = burner }
            val bucket = event.api_data?.get(5)?.api_value
            bucket?.let { basic.bucket = bucket }
            val research = event.api_data?.get(6)?.api_value
            research?.let { basic.research = research }
            val improve = event.api_data?.get(7)?.api_value
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
        }
        notifyBasicRefresh()
    }
}
