package cn.cctech.kccommand.fragments

import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.cctech.kccommand.BR
import cn.cctech.kccommand.R
import cn.cctech.kccommand.events.ui.FleetRefresh
import cn.cctech.kccommand.fragments.base.BaseFragment
import cn.cctech.kccommand.managers.ShipManager
import cn.cctech.kccommand.utils.Speed
import cn.cctech.kccommand.widgets.DataBindingHolder
import cn.cctech.kccommand.widgets.FleetListView
import cn.cctech.kccommand.widgets.ListDivider
import com.gaodesoft.ecoallogistics.assistant.findView
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter
import org.apache.commons.lang3.StringUtils
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.*

@Suppress("unused", "UNUSED_PARAMETER")
class FleetPageFragment : BaseFragment() {

    private var mIndex = -1
    private var mFleet: List<Int>? = ArrayList()
    private var mAdapter: FleetAdapter? = null
    private var mFleetListView: FleetListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mIndex = arguments.getInt(ARG_INDEX)
        }
    }

    override fun onCreateViewLazy(savedInstanceState: Bundle?) {
        super.onCreateViewLazy(savedInstanceState)
        setContentView(R.layout.fragment_fleet_page)
        mFleet = ShipManager.getFleet(mIndex)
        initList()
    }

    override fun onResumeLazy() {
        super.onResumeLazy()
        setFleet()
    }

    private fun initList() {
        mFleetListView = findView<FleetListView>(R.id.flv_fleet_list)
        val res = resources
        val dividerColor = ResourcesCompat.getColor(res, android.R.color.transparent, null)
        val backgroundColor = ResourcesCompat.getColor(res, android.R.color.transparent, null)
        val dividerHeight = res.getDimensionPixelSize(R.dimen.fleet_divider_height)
        val divider = ListDivider(dividerColor, backgroundColor, dividerHeight, 0, 0,
                ListDivider.VERTICAL_LIST, 0, 0)
        mFleetListView?.addItemDecoration(divider)
        mAdapter = FleetAdapter()
        mFleetListView?.setAdapter(mAdapter)
    }

    private fun setFleet() {
        mFleet = ShipManager.getFleet(mIndex)
        mAdapter?.notifyDataSetChanged()
        mFleetListView?.setFleetInfo(getFleetInfoStr())
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onFleetRefresh(event: FleetRefresh) {
        setFleet()
    }

    private fun getFleetInfoStr(): String {
        val fleetLevel = getString(R.string.ship_level, ShipManager.getFleetLevel(mIndex))
        val fleetSpeed = when (ShipManager.getFleetSpeedType(mIndex)) {
            Speed.SLOW -> getString(R.string.fleet_speed_slow)
            else -> getString(R.string.fleet_speed_fast)
        }
        val airPowerPair = ShipManager.getFleetAirPower(mIndex)
        val fleetAirPower = getString(R.string.fleet_air_power, airPowerPair.first)
//        val fleetAirPower = getString(R.string.fleet_air_power_range, airPowerPair.first, airPowerPair.second)
        val fleetScout = getString(R.string.fleet_scout, Math.floor(ShipManager.getFleetScout(mIndex) * 100) / 100)
        return StringUtils.join(arrayOf(fleetLevel, fleetSpeed, fleetAirPower, fleetScout), "/")
    }

    private inner class FleetAdapter : UltimateViewAdapter<DataBindingHolder>() {

        override fun newFooterHolder(view: View): DataBindingHolder {
            return DataBindingHolder(view, false)
        }

        override fun newHeaderHolder(view: View): DataBindingHolder {
            return DataBindingHolder(view, false)
        }

        override fun onCreateViewHolder(parent: ViewGroup): DataBindingHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.fleet_list_item, parent, false)
            return DataBindingHolder(view, true)
        }

        override fun getAdapterItemCount(): Int {
            return mFleet?.count { it > 0 } ?: 0
        }

        override fun generateHeaderId(position: Int): Long {
            return 0
        }

        override fun onBindViewHolder(holder: DataBindingHolder, position: Int) {
            val ship = ShipManager.getShipById(getItem(position))
            holder.binding.setVariable(BR.ship, ship)
            holder.binding.executePendingBindings()
        }

        override fun onCreateHeaderViewHolder(parent: ViewGroup): RecyclerView.ViewHolder? {
            return null
        }

        override fun onBindHeaderViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        }

        private fun getItem(position: Int): Int {
            return try {
                mFleet!![position]
            } catch (e: Exception) {
                -1
            }
        }

    }

    companion object {

        private val ARG_INDEX = "index"

        fun newInstance(index: Int): FleetPageFragment {
            val fragment = FleetPageFragment()
            val args = Bundle()
            args.putInt(ARG_INDEX, index)
            fragment.arguments = args
            return fragment
        }
    }
}
