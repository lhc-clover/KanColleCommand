package cn.cctech.kccommand.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Spannable
import android.text.SpannableString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import cn.cctech.kccommand.BR
import cn.cctech.kccommand.R
import cn.cctech.kccommand.cache.MapSpotHelper
import cn.cctech.kccommand.cache.getSpotColor
import cn.cctech.kccommand.entities.Ship
import cn.cctech.kccommand.events.ui.BattleRefresh
import cn.cctech.kccommand.events.ui.FleetRefresh
import cn.cctech.kccommand.fragments.base.BaseFragment
import cn.cctech.kccommand.managers.BattleManager
import cn.cctech.kccommand.managers.ShipManager
import cn.cctech.kccommand.utils.dp2px
import cn.cctech.kccommand.utils.kAirCommandMap
import cn.cctech.kccommand.utils.kHeadingMap
import cn.cctech.kccommand.widgets.DataBindingHolder
import cn.cctech.kccommand.widgets.ListDivider
import cn.cctech.kccommand.widgets.NextSpotImageSpan
import com.gaodesoft.ecoallogistics.assistant.findView
import com.github.megatronking.svg.sample.drawables.next_spot
import com.github.megatronking.svg.support.SVGDrawable
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter
import com.orhanobut.logger.Logger
import net.lucode.hackware.magicindicator.buildins.UIUtil
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class BattleFragment : BaseFragment() {

    private lateinit var mMineAdapter: CombatAdapter
    private lateinit var mEnemyAdapter: CombatAdapter
    private val mCombatInfo: TextView by lazy { findView<TextView>(R.id.tv_combat_info) }

    override fun onCreateViewLazy(savedInstanceState: Bundle?) {
        super.onCreateViewLazy(savedInstanceState)
        setContentView(R.layout.fragment_combat)
        initList()
    }

    override fun onResumeLazy() {
        super.onResumeLazy()
        setMineFleet()
        setEnemyFleet()
        setCombatInfo()
    }

    private fun initList() {
        val mineFleetListView = findView<UltimateRecyclerView>(R.id.urv_mine_fleet)
        mineFleetListView.layoutManager = LinearLayoutManager(context)
        val enemyFleetListView = findView<UltimateRecyclerView>(R.id.urv_enemy_fleet)
        enemyFleetListView.layoutManager = LinearLayoutManager(context)
        val dividerColor = ResourcesCompat.getColor(resources, android.R.color.transparent, context.theme)
        val backgroundColor = ResourcesCompat.getColor(resources, android.R.color.transparent, context.theme)
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

    @Suppress("unused", "UNUSED_PARAMETER")
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onFleetRefresh(event: FleetRefresh) {
        setMineFleet()
    }

    @Suppress("unused", "UNUSED_PARAMETER")
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onBattleRefresh(event: BattleRefresh) {
        setEnemyFleet()
        setCombatInfo()
    }

    private fun setMineFleet() {
        val fleetIndex = BattleManager.getInBattleFleet()
        val fleet = ShipManager.getFleet(fleetIndex)
        val list = mutableListOf<Ship>()
        fleet?.forEach {
            val ship = ShipManager.getShipById(it)
            if (ship != null) list.add(ship)
        }
        mMineAdapter.data = list
        mMineAdapter.notifyDataSetChanged()
    }

    private fun setEnemyFleet() {
        mEnemyAdapter.data = BattleManager.getEnemyList()
        mEnemyAdapter.notifyDataSetChanged()
    }

    private fun setCombatInfo() {
        val infoStrBuilder = StringBuilder()
        val area = BattleManager.mArea
        val map = BattleManager.mMap
        val node = BattleManager.mNode
        val next = BattleManager.mNext
        val get = BattleManager.mGet
        val type = BattleManager.mNodeType
        if (get.isNotEmpty()) {
            infoStrBuilder.append(getString(R.string.battle_get, get))
        } else {
            // 海域
            if (area != -1 && map != -1) {
                infoStrBuilder.append("$area-$map")
                if (node != -1) {
                    val currSpotMarker = MapSpotHelper.getInstance(context).getSpotMarker(area, map, node)
                    infoStrBuilder.append("-$currSpotMarker")
                }
            }
            // 航向
            val heading = try {
                kHeadingMap[BattleManager.mHeading]!!
            } catch (e: Exception) {
                -1
            }
            if (heading != -1) appendWithJoiner(infoStrBuilder, getString(heading))
            // 制空
            val airCommand = try {
                kAirCommandMap[BattleManager.mAirCommand]!!
            } catch (e: Exception) {
                -1
            }
            if (airCommand != -1) appendWithJoiner(infoStrBuilder, getString(airCommand))
            // 评价
            val rank = BattleManager.mRank
            if (rank.isNotEmpty()) appendWithJoiner(infoStrBuilder, rank)
            // 罗盘剧透
            if (next != -1) {
                val nextSpotMarker = MapSpotHelper.getInstance(context).getSpotMarker(area, map, next)
                appendWithJoiner(infoStrBuilder, getString(R.string.battle_next, nextSpotMarker))
            }
        }
        if (infoStrBuilder.isEmpty()) infoStrBuilder.append(getString(R.string.battle_idle))
        val infoStr = infoStrBuilder.toString()
        val spanString = SpannableString(infoStr)
        val imageSpan = NextSpotImageSpan(drawNextArrow(area, map, node, next, type))
        val spanStart = infoStr.indexOfFirst { it == '{' }
        val spanEnd = infoStr.indexOfLast { it == '}' } + 1
        if (spanStart in 1 until spanEnd)
            spanString.setSpan(imageSpan,
                    spanStart,
                    spanEnd,
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        mCombatInfo.text = spanString

    }

    private fun appendWithJoiner(builder: StringBuilder, str: String?) {
        if (str.isNullOrEmpty()) return
        if (builder.isNotEmpty()) builder.append("/")
        builder.append(str)
    }

    private fun drawNextArrow(area: Int, map: Int, current: Int, next: Int, type: Int): Drawable? {
        return if (area != -1 && map != -1 && /*current != -1 &&*/ next != -1 && type != -1) {
            val arrow = SVGDrawable(next_spot(context))
            arrow.setWidth(dp2px(context, 16f))
            arrow.setHeight(dp2px(context, 16f))
            val rotate = MapSpotHelper.getInstance(context).getSpotRotate(area, map, next)
            arrow.rotation = rotate.toFloat()
            Logger.d("rotation : ${arrow.rotation}")
            arrow.mutate()
            arrow.setTint(getSpotColor(context, type))
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
