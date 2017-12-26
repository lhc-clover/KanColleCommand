package cn.cctech.kccommand.managers

import android.util.SparseArray
import cn.cctech.kccommand.cache.ApiCacheHelper
import cn.cctech.kccommand.entities.Equip
import cn.cctech.kccommand.events.api.RequireInfo
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@Suppress("unused")
object EquipManager : IManager() {

    private val mEquipMap = SparseArray<Equip>()

    val equipCount: Int
        get() = mEquipMap.size()

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onRequireInfoEvent(event: RequireInfo) {
        if (event.api_result == 1) {
            for (item in event.api_data.api_slot_item) {
                val rawEquip = ApiCacheHelper.getSlotItem(item.api_slotitem_id)
                val equip = Equip(rawEquip, item)
                mEquipMap.put(item.api_id, equip)
            }
        }
    }

    fun getEquipById(id: Int): Equip? {
        return mEquipMap.get(id)
    }

}
