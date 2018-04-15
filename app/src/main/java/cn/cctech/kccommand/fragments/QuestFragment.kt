package cn.cctech.kccommand.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.cctech.kancolle.oyodo.Oyodo
import cn.cctech.kancolle.oyodo.entities.Quest
import cn.cctech.kancolle.oyodo.managers.Mission
import cn.cctech.kccommand.BR
import cn.cctech.kccommand.R
import cn.cctech.kccommand.fragments.base.LazyFragment
import cn.cctech.kccommand.utils.findView
import cn.cctech.kccommand.widgets.DataBindingHolder
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter

class QuestFragment : LazyFragment() {

    private lateinit var questAdapter: QuestAdapter

    override fun onCreateViewLazy(savedInstanceState: Bundle?) {
        super.onCreateViewLazy(savedInstanceState)
        setContentView(R.layout.fragment_quest)
        initList()
        Oyodo.attention().watch(Mission.questMap, {
            val quests = it.filter { it.value.state >= 2 }.values.toList()
            refresh(quests)
        })
    }

    private fun refresh(quests: List<Quest>) {
        activity?.runOnUiThread {
            quests.forEach { quest -> Log.d("Oyodo", quest.title) }
            questAdapter.data = quests
            questAdapter.notifyDataSetChanged()
        }
    }

//    override fun onResumeLazy() {
//        super.onResumeLazy()
//        refresh()
//    }

    private fun initList() {
        val questListView = findView<UltimateRecyclerView>(R.id.urv_quest)
        questListView.layoutManager = LinearLayoutManager(context)
        questAdapter = QuestAdapter()
        questListView.setAdapter(questAdapter)
    }

//    @Suppress("unused", "UNUSED_PARAMETER")
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    fun onFleetRefresh(event: QuestRefresh) {
//        refresh()
//    }

//    private fun refresh() {
//        questAdapter.data = QuestManager.getQuestList()
//        questAdapter.notifyDataSetChanged()
//    }

    private class QuestAdapter : UltimateViewAdapter<DataBindingHolder>() {

        var data: List<Quest>? = emptyList()

        override fun newFooterHolder(view: View): DataBindingHolder {
            return DataBindingHolder(view, false)
        }

        override fun newHeaderHolder(view: View): DataBindingHolder {
            return DataBindingHolder(view, false)
        }

        override fun onCreateViewHolder(parent: ViewGroup): DataBindingHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.quest_list_item, parent, false)
            return DataBindingHolder(view, true)
        }

        override fun getAdapterItemCount(): Int {
            return try {
                data!!.size
            } catch (e: Exception) {
                0
            }
        }

        override fun generateHeaderId(position: Int): Long {
            return 0
        }

        override fun onBindViewHolder(holder: DataBindingHolder, position: Int) {
            holder.binding.setVariable(BR.quest, getItem(position))
            holder.binding.executePendingBindings()
        }

        override fun onCreateHeaderViewHolder(parent: ViewGroup): RecyclerView.ViewHolder? {
            return null
        }

        override fun onBindHeaderViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        }

        private fun getItem(position: Int): Quest? {
            return try {
                data!![position]
            } catch (e: Exception) {
                null
            }
        }

    }

    companion object {

        fun newInstance(): QuestFragment {
            return QuestFragment()
        }
    }
}
