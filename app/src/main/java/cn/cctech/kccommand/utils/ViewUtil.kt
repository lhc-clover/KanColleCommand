package cn.cctech.kccommand.utils

import android.content.Context
import android.support.v4.content.res.ResourcesCompat
import cn.cctech.kancolle.oyodo.entities.Quest
import cn.cctech.kccommand.R

fun dp2px(context: Context, dipValue: Float): Int {
    val scale = context.resources.displayMetrics.density
    return (dipValue * scale + 0.5f).toInt()
}

fun getQuestTypeColor(context: Context, quest: Quest): Int {
    val colorResId = when (quest.category) {
        1 -> R.color.questForm
        2 -> R.color.questCombat
        3 -> R.color.questPractice
        4 -> R.color.questExpedition
        5 -> R.color.questDock
        6 -> R.color.questFactory
        7 -> R.color.questUpgrade
        else -> R.color.questDefault
    }
    return ResourcesCompat.getColor(context.resources, colorResId, context.theme)
}