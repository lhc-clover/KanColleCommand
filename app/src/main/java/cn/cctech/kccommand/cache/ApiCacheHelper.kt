package cn.cctech.kccommand.cache

import android.util.SparseArray
import cn.cctech.kccommand.events.api.Start
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.orhanobut.logger.Logger
import java.io.File
import java.io.FileInputStream

object ApiCacheHelper {

    private val mApiStartFilePath = "/data/data/cn.cctech.kccommand/com.dmm.dmmlabo.kancolle/Local Store/apis/api_start2"
    private val mShips = SparseArray<Start.ApiDataEntity.ApiMstShipEntity>()
    private val mSlotItems = SparseArray<Start.ApiDataEntity.ApiMstSlotitemEntity>()

    init {
        try {
            buildShipMap(readApiStartFile())
        } catch (e: Exception) {
            Logger.e(e, e.message)
        }

    }

    private fun buildShipMap(data: Start?) {
        for (ship in data!!.api_data.api_mst_ship) {
            val shipId = ship.api_id
            mShips.put(shipId, ship)
        }
        for (slotItem in data.api_data.api_mst_slotitem) {
            val slotItemId = slotItem.api_id
            mSlotItems.put(slotItemId, slotItem)
        }
    }

    private fun readApiStartFile(): Start? {
        val f = File(mApiStartFilePath)
        var res = ""
        try {
            val fin = FileInputStream(f)
            val length = fin.available()
            val buffer = ByteArray(length)
            fin.read(buffer)
            res = String(buffer)
            fin.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return Gson().fromJson<Start>(res.replace("svdata=", ""), object : TypeToken<Start>() {}.type)
    }

    fun getShip(shipId: Int): Start.ApiDataEntity.ApiMstShipEntity? {
        var ship: Start.ApiDataEntity.ApiMstShipEntity? = null
        try {
            ship = mShips.get(shipId)
        } catch (e: Exception) {
            Logger.e(e.message, e)
        }

        return ship
    }

    fun getSlotItem(slotItemId: Int): Start.ApiDataEntity.ApiMstSlotitemEntity? {
        var slotItem: Start.ApiDataEntity.ApiMstSlotitemEntity? = null
        try {
            slotItem = mSlotItems.get(slotItemId)
        } catch (e: Exception) {
            Logger.e(e.message, e)
        }
        return slotItem
    }

}
