package cn.cctech.kccommand.utils

import android.databinding.BindingAdapter
import android.support.v4.content.res.ResourcesCompat
import android.widget.ImageView
import android.widget.TextView
import cn.cctech.kccommand.entities.Ship
import com.orhanobut.logger.Logger

@BindingAdapter("slot_index", "ship_entity")
fun setSlotImage(view: TextView, index: Int, ship: Ship?) {
    if (index >= 0) {
        try {
            val slotImageId = ship?.getSlotImage(index) ?: -1
            val drawable = if (slotImageId != -1)
                ResourcesCompat.getDrawable(view.resources, slotImageId, view.context.theme) else null
            view.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
//            val slotCarry = ship?.carrys?.get(index) ?: -1
//            if (slotCarry >= 0) view.text = "$slotCarry"
        } catch (e: Exception) {
            Logger.e(e, "Can't get slot image\n")
        }
    }
}

@BindingAdapter("android:src")
fun setSrc(view: ImageView, resId: Int) {
    if (resId == -1) view.setImageDrawable(null)
    else view.setImageResource(resId)
}
