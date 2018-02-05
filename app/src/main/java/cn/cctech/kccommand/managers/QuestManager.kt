package cn.cctech.kccommand.managers

import android.util.SparseArray
import cn.cctech.kccommand.entities.Quest
import cn.cctech.kccommand.events.api.ClearItemGet
import cn.cctech.kccommand.events.api.QuestList
import cn.cctech.kccommand.events.ui.QuestRefresh
import com.google.gson.Gson
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@Suppress("unused", "MemberVisibilityCanBePrivate")
object QuestManager : IManager() {

    private val questMap: SparseArray<Quest> = SparseArray()

    private fun notifyQuestRefresh() {
        val event = QuestRefresh()
        event.dispatch()
    }

    fun getQuestList(): List<Quest> {
        return (0 until questMap.size()).map { questMap.valueAt(it) }.filter { it.state >= 2 }
    }

    fun setQuestClear(id: Int) {
        questMap.get(id).state = 1
    }

    fun setAllQuestClear() {
        (0 until questMap.size()).forEach { questMap.valueAt(it).state = 1 }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onQuestList(event: QuestList) {
        if (event.api_result == 1) {
//            val count = event.api_data?.api_count
//            val execCount = event.api_data?.api_exec_count
//            if (count == execCount) {
//                setAllQuestClear()
//            }
            event.api_data?.api_list?.forEach {
                val value = try {
                    it.asInt
                } catch (e: Exception) {
                    0
                }
                if (value != -1) {
                    val quest = Quest(Gson().fromJson(it, QuestList.ApiDataBean.ApiListBean::class.java))
                    val id = quest.id
                    if (id > 0) questMap.put(id, quest)
                }
            }
            notifyQuestRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onQuestClear(event: ClearItemGet) {
        if (event.api_result == 1) {
            val questId = try {
                event.paramMap["api_quest_id"]?.toInt()!!
            } catch (e: Exception) {
                -1
            }
            setQuestClear(questId)
        }
        notifyQuestRefresh()
    }

}
