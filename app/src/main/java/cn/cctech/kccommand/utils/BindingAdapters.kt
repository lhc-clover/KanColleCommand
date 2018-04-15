package cn.cctech.kccommand.utils

import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.support.v4.content.res.ResourcesCompat
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import cn.cctech.kancolle.oyodo.entities.Ship
import cn.cctech.kccommand.R

@BindingAdapter("ship_entity")
fun setSlotImages(view: LinearLayout, ship: Ship?) {
    fun slotDrawable(slotId: Int): Drawable? {
        val size = dp2px(view.context, 16.0f)
        val slotImageId = getSlotImage(slotId)
        return if (slotImageId != -1) {
            val drawable = ResourcesCompat.getDrawable(view.resources, slotImageId, view.context.theme)
            drawable?.setBounds(0, 0, size, size)
            drawable
        } else null
    }

    val item5 = view.findView<TextView>(R.id.iv_fleet_item_eq_5)
    item5.visibility = if (ship?.items?.size ?: 0 > 4) View.VISIBLE else View.GONE
    ship?.items?.forEachIndexed { index, slotId ->
        when (index) {
            0 -> view.findView<TextView>(R.id.iv_fleet_item_eq_1)
            1 -> view.findView<TextView>(R.id.iv_fleet_item_eq_2)
            2 -> view.findView<TextView>(R.id.iv_fleet_item_eq_3)
            3 -> view.findView<TextView>(R.id.iv_fleet_item_eq_4)
            4 -> item5
            else -> null
        }?.setCompoundDrawables(slotDrawable(slotId), null, null, null)
    }
    val itemEx = view.findView<TextView>(R.id.iv_fleet_item_eq_ex)
    ship?.itemEx?.let { itemEx.setCompoundDrawables(slotDrawable(it), null, null, null) }
}

@BindingAdapter("android:src")
fun setSrc(view: ImageView, resId: Int) {
    if (resId == -1) view.setImageDrawable(null)
    else view.setImageResource(resId)
}
