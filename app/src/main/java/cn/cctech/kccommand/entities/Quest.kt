package cn.cctech.kccommand.entities

import android.content.Context
import android.support.v4.content.res.ResourcesCompat
import cn.cctech.kccommand.R
import cn.cctech.kccommand.events.api.QuestList

class Quest {

    var id: Int = 0
    var title: String = ""
    var state: Int = 0
    var category: Int = 0

    constructor(entity: QuestList.ApiDataBean.ApiListBean?) {
        id = entity?.api_no ?: 0
        title = entity?.api_title ?: ""
        state = entity?.api_state ?: 0
        category = entity?.api_category ?: 0
    }

    fun getTypeColor(context: Context): Int {
        val colorResId = when (category) {
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

}
