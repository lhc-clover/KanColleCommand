package cn.cctech.kccommand.managers

import android.util.SparseArray
import cn.cctech.kccommand.cache.ApiCacheHelper
import cn.cctech.kccommand.entities.Equip
import cn.cctech.kccommand.events.api.RequireInfo
import cn.cctech.kccommand.events.api.SlotItem
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@Suppress("unused")
object EquipManager : IManager() {

    private val mEquipMap = SparseArray<Equip>()

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onRequireInfoEvent(event: RequireInfo) {
        if (event.api_result == 1) {
            clearEquipMap()
            event.api_data?.api_slot_item?.forEach {
                addNewEquip(it.api_id, it.api_slotitem_id)
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onSlotItem(event: SlotItem) {
        if (event.api_result == 1) {
            clearEquipMap()
            event.api_data?.forEach {
                addNewEquip(it.api_id, it.api_slotitem_id)
            }
            BasicManager.recountSlotItem()
        }
    }

    fun getEquipById(id: Int): Equip? {
        return mEquipMap.get(id)
    }

    fun addNewEquip(id: Int, slotId: Int) {
        val rawEquip = ApiCacheHelper.getSlotItem(slotId)
        val equip = Equip(rawEquip)
        mEquipMap.put(id, equip)
    }

    fun removeEquip(id: Int) {
        if (id > 0) mEquipMap.remove(id)
    }

    fun getEquipCount(): Int {
        return mEquipMap.size()
    }

    private fun clearEquipMap() {
        mEquipMap.clear()
    }

}
