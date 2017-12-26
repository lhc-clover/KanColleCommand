package cn.cctech.kccommand.fragments

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.os.Message
import cn.cctech.kccommand.R
import cn.cctech.kccommand.databinding.FragmentDockBinding
import cn.cctech.kccommand.entities.BuildDock
import cn.cctech.kccommand.entities.Expedition
import cn.cctech.kccommand.entities.RepairDock
import cn.cctech.kccommand.events.ui.DockRefresh
import cn.cctech.kccommand.fragments.base.BaseFragment
import cn.cctech.kccommand.managers.DockManager
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.lang.ref.WeakReference

class DockFragment : BaseFragment() {

    private lateinit var binding: FragmentDockBinding
    private val mTimer = Timer(this)

    companion object {

        private const val TIME_TICK = 2333333

        fun newInstance(): DockFragment {
            return DockFragment()
        }
    }

    override fun onCreateViewLazy(savedInstanceState: Bundle?) {
        super.onCreateViewLazy(savedInstanceState)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_dock, null, false)
        contentView = binding.root
    }

    override fun onResumeLazy() {
        super.onResumeLazy()
        setup()
    }

    override fun onPauseLazy() {
        mTimer.removeMessages(TIME_TICK)
        super.onPauseLazy()
    }

    private fun setup() {
        binding.expedition1 = DockManager.expeditionList.getOrElse(1, defaultValue = { Expedition() })
        binding.expedition2 = DockManager.expeditionList.getOrElse(2, defaultValue = { Expedition() })
        binding.expedition3 = DockManager.expeditionList.getOrElse(3, defaultValue = { Expedition() })
        binding.repair1 = DockManager.repairDockList.getOrElse(0, defaultValue = { RepairDock() })
        binding.repair2 = DockManager.repairDockList.getOrElse(1, defaultValue = { RepairDock() })
        binding.repair3 = DockManager.repairDockList.getOrElse(2, defaultValue = { RepairDock() })
        binding.repair4 = DockManager.repairDockList.getOrElse(3, defaultValue = { RepairDock() })
        binding.build1 = DockManager.buildDockList.getOrElse(0, defaultValue = { BuildDock(1) })
        binding.build2 = DockManager.buildDockList.getOrElse(1, defaultValue = { BuildDock(2) })
        binding.build3 = DockManager.buildDockList.getOrElse(2, defaultValue = { BuildDock(3) })
        binding.build4 = DockManager.buildDockList.getOrElse(3, defaultValue = { BuildDock(4) })
        mTimer.sendEmptyMessage(TIME_TICK)
    }

    private fun update() {
        binding.invalidateAll()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onDockRefresh(event: DockRefresh) {
        setup()
    }

    private class Timer(context: DockFragment) : Handler() {

        private val mReference: WeakReference<DockFragment> = WeakReference(context)

        override fun handleMessage(msg: Message?) {
            if (msg?.what == TIME_TICK) {
                mReference.get()?.update()
                sendEmptyMessageDelayed(TIME_TICK, 1000)
            }
        }

    }

}
