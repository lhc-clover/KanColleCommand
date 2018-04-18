package cn.cctech.kccommand.fragments

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.os.Message
import cn.cctech.kancolle.oyodo.Oyodo
import cn.cctech.kancolle.oyodo.managers.Dock
import cn.cctech.kccommand.R
import cn.cctech.kccommand.databinding.FragmentDockBinding
import cn.cctech.kccommand.fragments.base.LazyFragment
import java.lang.ref.WeakReference

class DockFragment : LazyFragment() {

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
        setup()
    }

    override fun onResumeLazy() {
        super.onResumeLazy()
        mTimer.sendEmptyMessage(TIME_TICK)
    }

    override fun onPauseLazy() {
        mTimer.removeMessages(TIME_TICK)
        super.onPauseLazy()
    }

    private fun setup() {
        Dock.expeditionList.forEachIndexed { index, it ->
            Oyodo.attention().watch(it, { expedition ->
                when (index) {
                    1 -> binding.expedition1 = expedition
                    2 -> binding.expedition2 = expedition
                    3 -> binding.expedition3 = expedition
                }
            })
        }
        Dock.repairList.forEachIndexed { index, it ->
            Oyodo.attention().watch(it, { repair ->
                when (index) {
                    0 -> binding.repair1 = repair
                    1 -> binding.repair2 = repair
                    2 -> binding.repair3 = repair
                    3 -> binding.repair4 = repair
                }
            })
        }
        Dock.buildList.forEachIndexed { index, it ->
            Oyodo.attention().watch(it, { build ->
                when (index) {
                    0 -> binding.build1 = build
                    1 -> binding.build2 = build
                    2 -> binding.build3 = build
                    3 -> binding.build4 = build
                }
            })
        }
        mTimer.sendEmptyMessage(TIME_TICK)
    }

    private fun update() {
        binding.invalidateAll()
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
