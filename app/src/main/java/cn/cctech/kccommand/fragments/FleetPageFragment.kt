package cn.cctech.kccommand.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.cctech.kancolle.oyodo.Oyodo
import cn.cctech.kancolle.oyodo.entities.Ship
import cn.cctech.kancolle.oyodo.managers.*
import cn.cctech.kancolle.oyodo.utils.Speed
import cn.cctech.kccommand.BR
import cn.cctech.kccommand.R
import cn.cctech.kccommand.fragments.base.LazyFragment
import cn.cctech.kccommand.utils.findView
import cn.cctech.kccommand.utils.getFormatCountDown
import cn.cctech.kccommand.widgets.DataBindingHolder
import cn.cctech.kccommand.widgets.FleetListView
import cn.cctech.kccommand.widgets.ListDivider
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter
import com.orhanobut.logger.Logger
import io.reactivex.disposables.Disposable
import org.apache.commons.lang3.StringUtils
import java.lang.ref.WeakReference

class FleetPageFragment : LazyFragment() {

    private var mIndex = -1
    private var mFleet: List<Int> = listOf()
    private var mAdapter: FleetAdapter? = null
    private var mFleetListView: FleetListView? = null
    private var watcher: Disposable? = null
    private var fleetInfo: String = ""
    private var condTime: Long = 0
    private val timer = Timer(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mIndex = arguments?.getInt(ARG_INDEX) ?: -1
    }

    override fun onCreateViewLazy(savedInstanceState: Bundle?) {
        super.onCreateViewLazy(savedInstanceState)
        setContentView(R.layout.fragment_fleet_page)
        initList()
        watchShipMap()
        setFleet()
    }

//    override fun onResumeLazy() {
//        super.onResumeLazy()
//    }

    override fun onPauseLazy() {
        super.onPauseLazy()
        watcher?.dispose()
        timer.removeMessages(TIME_TICK)
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
        watcher = Oyodo.attention().watch(Fleet.deckShipIds[mIndex], { ids ->
            Logger.d("ids : $ids")
            mFleet = ids
            refreshList()
        })
    }

    private fun watchShipMap() {
        Oyodo.attention().watch(Fleet.shipWatcher, {
            refreshList()
        })
        Oyodo.attention().watch(Fleet.slotWatcher, {
            if (it is Transform.All) refreshList()
        })
    }

    private fun refreshList() {
        activity?.runOnUiThread {
            fleetInfo = getFleetInfoStr()
            condTime = getCondRecoveryTime(mIndex)
            mAdapter?.notifyDataSetChanged()
            timer.sendEmptyMessage(TIME_TICK)
        }
    }

    private fun getFleetInfoStr(): String {
        val fleetLevel = getString(R.string.ship_level, getFleetLevel(mIndex))
        val fleetSpeed = when (getFleetSpeedType(mIndex)) {
            Speed.SLOW -> getString(R.string.fleet_speed_slow)
            else -> getString(R.string.fleet_speed_fast)
        }
        val airPowerPair = getFleetAirPower(mIndex)
        val fleetAirPower = getString(R.string.fleet_air_power, airPowerPair.first)
//        val fleetAirPower = getString(R.string.fleet_air_power_range, airPowerPair.first, airPowerPair.second)
        val fleetScout = getString(R.string.fleet_scout, Math.floor(getFleetScout(mIndex) * 100) / 100)
        return StringUtils.join(arrayOf(fleetLevel, fleetSpeed, fleetAirPower, fleetScout), "/")
    }

    private fun buildHeaderText(): String {
        val result = StringBuilder(fleetInfo)
        if (condTime > 0) {
            val countDownStr = getFormatCountDown(context!!, condTime)
            result.append("\n").append(getString(R.string.fleet_cond_recovery, countDownStr))
        }
        return result.toString()
    }

    private fun update() {
        mFleetListView?.setHeader(buildHeaderText())
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
            return mFleet.count { it > 0 }
        }

        override fun generateHeaderId(position: Int): Long {
            return 0
        }

        override fun onBindViewHolder(holder: DataBindingHolder, position: Int) {
            holder.binding.setVariable(BR.ship, getItem(position))
            holder.binding.executePendingBindings()
        }

        override fun onCreateHeaderViewHolder(parent: ViewGroup): RecyclerView.ViewHolder? {
            return null
        }

        override fun onBindHeaderViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        }

        private fun getItem(position: Int): Ship? {
            return Fleet.shipMap[mFleet[position]]
        }

    }

    private class Timer(context: FleetPageFragment) : Handler() {

        private val mReference: WeakReference<FleetPageFragment> = WeakReference(context)

        override fun handleMessage(msg: Message?) {
            if (msg?.what == TIME_TICK) {
                mReference.get()?.update()
                val time = mReference.get()?.condTime ?: 0
                val now = System.currentTimeMillis()
                if (time >= now) sendEmptyMessageDelayed(TIME_TICK, 1000)
            }
        }

    }

    companion object {

        private const val ARG_INDEX = "index"
        private const val TIME_TICK = 998

        fun newInstance(index: Int): FleetPageFragment {
            val fragment = FleetPageFragment()
            val args = Bundle()
            args.putInt(ARG_INDEX, index)
            fragment.arguments = args
            return fragment
        }
    }
}
