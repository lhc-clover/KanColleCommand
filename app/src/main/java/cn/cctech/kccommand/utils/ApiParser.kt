package cn.cctech.kccommand.utils

import cn.cctech.kccommand.R
import java.util.*

object ApiParser {

    fun getSlotItemIcon(slotItemNum: Int): Int {
//        return getImageResourceId("slotitem_1" + String.format("%02d", slotItemNum))
        return getImageResourceId("slot_" + slotItemNum)
    }

    private fun getImageResourceId(name: String): Int {
        val drawables = R.drawable()
        var resId = R.drawable.slot_0
        try {
            val field = R.drawable::class.java.getField(name)
            resId = field.get(drawables) as Int
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return resId
    }

    fun convertFormToMap(form: String): HashMap<String, String> {
        val map = HashMap<String, String>()
        form.split("&")
                .map { it.replace("%5F", "_").replace("%2D", "-").split("=") }
                .forEach {
                    map.put(it[0], it[1])
                }
        return map
    }
}
