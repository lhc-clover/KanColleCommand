package cn.cctech.kccommand.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.cctech.kccommand.BR
import cn.cctech.kccommand.R
import cn.cctech.kccommand.entities.Quest
import cn.cctech.kccommand.events.ui.QuestRefresh
import cn.cctech.kccommand.fragments.base.BaseFragment
import cn.cctech.kccommand.managers.QuestManager
import cn.cctech.kccommand.widgets.DataBindingHolder
import com.gaodesoft.ecoallogistics.assistant.findView
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class QuestFragment : BaseFragment() {

    private lateinit var mQuestAdapter: QuestAdapter

    override fun onCreateViewLazy(savedInstanceState: Bundle?) {
        super.onCreateViewLazy(savedInstanceState)
        setContentView(R.layout.fragment_quest)
        initList()
    }

    override fun onResumeLazy() {
        super.onResumeLazy()
        refresh()
    }

    private fun initList() {
        val questListView = findView<UltimateRecyclerView>(R.id.urv_quest)
        questListView.layoutManager = LinearLayoutManager(context)
        mQuestAdapter = QuestAdapter()
        questListView.setAdapter(mQuestAdapter)
    }

    @Suppress("unused", "UNUSED_PARAMETER")
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onFleetRefresh(event: QuestRefresh) {
        refresh()
    }

    private fun refresh() {
        mQuestAdapter.data = QuestManager.getQuestList()
        mQuestAdapter.notifyDataSetChanged()
    }

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
