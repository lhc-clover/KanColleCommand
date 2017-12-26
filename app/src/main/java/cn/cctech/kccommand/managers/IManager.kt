package cn.cctech.kccommand.managers

import org.greenrobot.eventbus.EventBus

abstract class IManager {

    fun setup() {
        EventBus.getDefault().register(this)
    }

    fun destroy() {
        EventBus.getDefault().unregister(this)
    }
}
