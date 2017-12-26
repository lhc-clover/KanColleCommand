package cn.cctech.kccommand.widgets

import android.content.Context
import android.databinding.BindingAdapter
import android.util.AttributeSet
import cn.cctech.kccommand.entities.Ship

import com.daimajia.numberprogressbar.NumberProgressBar

class BloodBar : NumberProgressBar {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

}

@BindingAdapter("progress_current", "progress_max")
fun setProgress(view: BloodBar, progress: Int, max: Int) {
    if (progress >= 0 && max >= 0 && progress <= max) {
        view.max = max
        view.progress = progress
    }
}

@BindingAdapter("bar_state")
fun setBarState(view: BloodBar, ship: Ship?) {
    if (ship != null) {
        view.reachedBarColor = ship.getHpColor(view.context)
    }
}