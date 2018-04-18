package cn.cctech.kccommand.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Spannable
import android.text.SpannableString
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import cn.cctech.kancolle.oyodo.Oyodo
import cn.cctech.kancolle.oyodo.entities.Ship
import cn.cctech.kancolle.oyodo.managers.Battle
import cn.cctech.kancolle.oyodo.managers.getShips
import cn.cctech.kccommand.BR
import cn.cctech.kccommand.R
import cn.cctech.kccommand.cache.MapSpotHelper
import cn.cctech.kccommand.cache.getSpotColor
import cn.cctech.kccommand.fragments.base.LazyFragment
import cn.cctech.kccommand.utils.dp2px
import cn.cctech.kccommand.utils.findView
import cn.cctech.kccommand.utils.kAirCommandMap
import cn.cctech.kccommand.utils.kHeadingMap
import cn.cctech.kccommand.widgets.DataBindingHolder
import cn.cctech.kccommand.widgets.ListDivider
import cn.cctech.kccommand.widgets.NextSpotImageSpan
import com.github.megatronking.svg.sample.drawables.next_spot
import com.github.megatronking.svg.support.SVGDrawable
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter
import com.orhanobut.logger.Logger
import net.lucode.hackware.magicindicator.buildins.UIUtil

class BattleFragment : LazyFragment() {

    private lateinit var mMineAdapter: CombatAdapter
    private lateinit var mEnemyAdapter: CombatAdapter
    private val mCombatInfo: TextView by lazy { findView<TextView>(R.id.tv_combat_info) }

    override fun onCreateViewLazy(savedInstanceState: Bundle?) {
        super.onCreateViewLazy(savedInstanceState)
        setContentView(R.layout.fragment_combat)
        initList()
        Oyodo.attention().watch(Battle.phase, { activity?.runOnUiThread { refreshBattle(it) } })
    }

    private fun initList() {
        val mineFleetListView = findView<UltimateRecyclerView>(R.id.urv_mine_fleet)
        mineFleetListView.layoutManager = LinearLayoutManager(context)
        val enemyFleetListView = findView<UltimateRecyclerView>(R.id.urv_enemy_fleet)
        enemyFleetListView.layoutManager = LinearLayoutManager(context)
        val dividerColor = ResourcesCompat.getColor(resources, android.R.color.transparent, context?.theme)
        val backgroundColor = ResourcesCompat.getColor(resources, android.R.color.transparent, context?.theme)
        val dividerHeight = UIUtil.dip2px(context, 4.0)
        val divider = ListDivider(dividerColor, backgroundColor, dividerHeight, 0, 0,
                ListDivider.VERTICAL_LIST, 0, 0)
        mineFleetListView.addItemDecoration(divider)
        enemyFleetListView.addItemDecoration(divider)
        mMineAdapter = CombatAdapter()
        mEnemyAdapter = CombatAdapter()
        mineFleetListView.setAdapter(mMineAdapter)
        enemyFleetListView.setAdapter(mEnemyAdapter)
    }

    private fun refreshBattle(phase: Battle.Phase) {
        setMineFleet()
        setEnemyFleet()
        setCombatInfo(phase)
    }

    private fun setMineFleet() {
        val fleetIndex = Battle.friendIndex
        val list = getShips(fleetIndex)
        mMineAdapter.data = list
        mMineAdapter.notifyDataSetChanged()
    }

    private fun setEnemyFleet() {
        mEnemyAdapter.data = Battle.enemyList
        mEnemyAdapter.notifyDataSetChanged()
    }

    private fun setCombatInfo(phase: Battle.Phase) {
        val info = when (phase) {
            Battle.Phase.Idle -> getString(R.string.battle_idle)
            Battle.Phase.Start -> {
                val spotMarker = MapSpotHelper.getInstance(context!!).getSpotMarker(Battle.area, Battle.map, Battle.route)
                getSpanInfo("${Battle.area}-${Battle.map}", spotMarker[1])
            }
            Battle.Phase.Next -> {
                val spotMarker = MapSpotHelper.getInstance(context!!).getSpotMarker(Battle.area, Battle.map, Battle.route)
                getSpanInfo("${Battle.area}-${Battle.map}-${spotMarker[0]}", spotMarker[1])
            }
            Battle.Phase.BattleDaytime, Battle.Phase.Practice -> {
                TextUtils.join("/", listOf(getHeading(), getAirCommand(), Battle.rank))
            }
            Battle.Phase.BattleNight, Battle.Phase.PracticeNight -> {
                TextUtils.join("/", listOf(getHeading(), Battle.rank))
            }
            Battle.Phase.BattleNightSp -> {
                TextUtils.join("/", listOf(getHeading(), getAirCommand(), Battle.rank))
            }
            Battle.Phase.BattleResult, Battle.Phase.PracticeResult -> {
                if (TextUtils.isEmpty(Battle.get)) Battle.rank
                else "${Battle.rank}/${getString(R.string.battle_get, Battle.get)}"
            }
            else -> getString(R.string.battle_idle)
        }
        mCombatInfo.text = info
    }

    private fun getHeading(): String {
        return try {
            getString(kHeadingMap[Battle.heading]!!)
        } catch (e: Exception) {
            "未知航向"
        }
    }

    private fun getAirCommand(): String {
        return try {
            getString(kAirCommandMap[Battle.airCommand]!!)
        } catch (e: Exception) {
            "未知制空"
        }
    }

    private fun getSpanInfo(base: String, marker: String): SpannableString {
        val imageSpan = NextSpotImageSpan(drawNextArrow(Battle.area, Battle.map, Battle.route, Battle.nodeType))
        val next = getString(R.string.battle_next, marker)
        val source = TextUtils.join("/", listOf(base, next))
        val spanString = SpannableString(source)
        val spanStart = source.indexOfFirst { it == '{' }
        val spanEnd = source.indexOfLast { it == '}' } + 1
        if (spanStart in 1 until spanEnd)
            spanString.setSpan(imageSpan,
                    spanStart,
                    spanEnd,
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        return spanString
    }

    private fun drawNextArrow(area: Int, map: Int, next: Int, type: Int): Drawable? {
        return if (area != -1 && map != -1 && /*current != -1 &&*/ next != -1 && type != -1) {
            val arrow = SVGDrawable(next_spot(context))
            arrow.mutate()
//            arrow.setTint(getSpotColor(context!!, type))
            arrow.setWidth(dp2px(context!!, 16f))
            arrow.setHeight(dp2px(context!!, 16f))
            val rotate = MapSpotHelper.getInstance(context!!).getSpotRotate(area, map, next)
            arrow.rotation = rotate.toFloat()
            Logger.d("rotation : ${arrow.rotation}")
            arrow
        } else {
            null
        }
    }

    private class CombatAdapter : UltimateViewAdapter<DataBindingHolder>() {

        var data: List<Ship>? = emptyList()

        override fun newFooterHolder(view: View): DataBindingHolder {
            return DataBindingHolder(view, false)
        }

        override fun newHeaderHolder(view: View): DataBindingHolder {
            return DataBindingHolder(view, false)
        }

        override fun onCreateViewHolder(parent: ViewGroup): DataBindingHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.combat_list_item, parent, false)
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
            holder.binding.setVariable(BR.ship1, getItem(position))
            holder.binding.setVariable(BR.combined, false)
            holder.binding.executePendingBindings()
        }

        override fun onCreateHeaderViewHolder(parent: ViewGroup): RecyclerView.ViewHolder? {
            return null
        }

        override fun onBindHeaderViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        }

        private fun getItem(position: Int): Ship? {
            return try {
                data!![position]
            } catch (e: Exception) {
                null
            }
        }

    }

    companion object {

        fun newInstance(): BattleFragment {
            return BattleFragment()
        }
    }
}
