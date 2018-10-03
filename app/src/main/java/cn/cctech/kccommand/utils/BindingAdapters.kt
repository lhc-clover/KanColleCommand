package cn.cctech.kccommand.utils

import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.support.v4.content.res.ResourcesCompat
import android.view.View
import android.widget.*
import cn.cctech.kancolle.oyodo.entities.Ship
import cn.cctech.kccommand.R

@BindingAdapter("set_slots")
fun setSlotImages(view: LinearLayout, ship: Ship?) {
    val item5 = view.findView<TextView>(R.id.iv_fleet_item_eq_5)
    item5.visibility = if (ship?.items?.size ?: 0 > 4) View.VISIBLE else View.GONE
    (0 until 5).forEach {
        val slotId = try {
            ship!!.items[it]
        } catch (e: Exception) {
            -1
        }
        when (it) {
            0 -> view.findView<TextView>(R.id.iv_fleet_item_eq_1)
            1 -> view.findView<TextView>(R.id.iv_fleet_item_eq_2)
            2 -> view.findView<TextView>(R.id.iv_fleet_item_eq_3)
            3 -> view.findView<TextView>(R.id.iv_fleet_item_eq_4)
            4 -> item5
            else -> null
        }?.setCompoundDrawables(slotDrawable(view, slotId), null, null, null)
    }
}

@BindingAdapter("set_slot_ex")
fun setExSlotImages(view: TextView, ship: Ship?) {
    val itemEx = view.findView<TextView>(R.id.iv_fleet_item_eq_ex)
    ship?.itemEx?.let { itemEx.setCompoundDrawables(slotDrawable(view, it), null, null, null) }
}

private fun slotDrawable(view: View, slotId: Int): Drawable? {
    val size = dp2px(view.context, 16.0f)
    val slotImageId = getSlotImage(slotId)
    return if (slotImageId != -1) {
        val drawable = ResourcesCompat.getDrawable(view.resources, slotImageId, view.context.theme)
        drawable?.setBounds(0, 0, size, size)
        drawable
    } else null
}

@BindingAdapter("android:src")
fun setSrc(view: ImageView, resId: Int) {
    if (resId == -1) view.setImageDrawable(null)
    else view.setImageResource(resId)
}

@BindingAdapter("itemHpVisible")
fun setCombatItemVisibility(view: RelativeLayout, item: Ship?) {
    view.visibility = if (item == null) View.GONE else View.VISIBLE
}


@BindingAdapter("combatItem1", "combatItem2")
fun setCombatItemGapVisibility(gap: Space, item1: Ship?, item2: Ship?) {
    gap.visibility = if (item1 != null && item2 != null) View.VISIBLE else View.GONE
}
