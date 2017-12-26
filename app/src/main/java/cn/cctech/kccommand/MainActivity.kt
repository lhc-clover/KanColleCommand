package cn.cctech.kccommand

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.content.res.ResourcesCompat
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import cn.cctech.kccommand.databinding.InfoPanelBinding
import cn.cctech.kccommand.events.ui.BasicRefresh
import cn.cctech.kccommand.fragments.BattleFragment
import cn.cctech.kccommand.fragments.DockFragment
import cn.cctech.kccommand.fragments.FleetFragment
import cn.cctech.kccommand.fragments.TestFragment
import cn.cctech.kccommand.managers.*
import cn.cctech.kccommand.proxy.VpnService
import com.gaodesoft.ecoallogistics.assistant.findView
import com.orhanobut.logger.Logger
import net.lucode.hackware.magicindicator.MagicIndicator
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.UIUtil
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.TriangularPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppEntry(), NotifyManager.Callback {

    private val kRequestVpn = 666

    private var mTabs: Array<String>? = null
    private var mViewPager: ViewPager? = null
    private var mInfoPanelBinding: InfoPanelBinding? = null
    private var mEventObserver = EventObserver()

    override fun setContentView(view: View) {
        super.setContentView(R.layout.activity_main)
        EventBus.getDefault().register(mEventObserver)
        initViews(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ShipManager.setup()
        EquipManager.setup()
        DockManager.setup()
        BattleManager.setup()
        BasicManager.setup()
        NotifyManager.setup()
        NotifyManager.callback = this
    }

    override fun onDestroy() {
        EventBus.getDefault().unregister(mEventObserver)
        ShipManager.destroy()
        EquipManager.destroy()
        DockManager.destroy()
        BattleManager.destroy()
        BasicManager.destroy()
        NotifyManager.destroy()
        super.onDestroy()
    }

    override fun onNewIntent(aIntent: Intent?) {
        super.onNewIntent(aIntent)
        val authComplete = aIntent?.getBooleanExtra("AuthComplete", false) ?: false
        if (authComplete) {
            startProxy()
        }
    }

    private fun startProxy() {
        try {
            val prepare = VpnService.prepare(this)
            if (prepare == null) {
                Logger.i("Prepare done")
                onActivityResult(kRequestVpn, Activity.RESULT_OK, null)
            } else {
                startActivityForResult(prepare, kRequestVpn)
            }
        } catch (ex: Throwable) {
            // Prepare failed
            Logger.e(ex, "Prepare failed")
        }
    }

    private fun initViews(view: View) {
        val flashContainer = findView<ViewGroup>(R.id.rl_flash)
        flashContainer.addView(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        mTabs = resources.getStringArray(R.array.main_tabs)
        mViewPager = findView(R.id.main_pager)
        mViewPager?.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return when (position) {
                    0 -> FleetFragment.newInstance()
                    1 -> BattleFragment.newInstance()
                    2 -> DockFragment.newInstance()
                    else -> TestFragment.newInstance(position)
                }
            }

            override fun getCount(): Int {
                return mTabs?.size ?: 0
            }
        }
        mViewPager?.offscreenPageLimit = 3
        val magicIndicator = findView<MagicIndicator>(R.id.main_indicator)
        val commonNavigator = CommonNavigator(this)
        commonNavigator.adapter = object : CommonNavigatorAdapter() {

            override fun getCount(): Int {
                return mTabs?.size ?: 0
            }

            override fun getTitleView(context: Context, index: Int): IPagerTitleView {
                val colorTransitionPagerTitleView = ColorTransitionPagerTitleView(context)
                colorTransitionPagerTitleView.normalColor = ResourcesCompat.getColor(resources, R.color.tabTextColorNormal, theme)
                colorTransitionPagerTitleView.selectedColor = ResourcesCompat.getColor(resources, R.color.tabTextColorSelect, theme)
                colorTransitionPagerTitleView.text = mTabs?.get(index)
                colorTransitionPagerTitleView.setOnClickListener { mViewPager?.currentItem = index }
                return colorTransitionPagerTitleView
            }

            override fun getIndicator(context: Context): IPagerIndicator {
                val indicator = TriangularPagerIndicator(context)
                indicator.lineColor = ResourcesCompat.getColor(resources, R.color.colorPrimary, theme)
                indicator.lineHeight = UIUtil.dip2px(context, 2.0)
                indicator.triangleHeight = UIUtil.dip2px(context, 4.0)
                return indicator
            }
        }
        commonNavigator.isAdjustMode = true
        magicIndicator.navigator = commonNavigator
        ViewPagerHelper.bind(magicIndicator, mViewPager)

        val infoPanelGroup = findView<FrameLayout>(R.id.fl_info_panel)
        mInfoPanelBinding = DataBindingUtil.inflate(layoutInflater, R.layout.info_panel, infoPanelGroup, true)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == kRequestVpn) {
            if (resultCode == Activity.RESULT_OK) {
                VpnService.start("prepared", this)
            } else if (resultCode == Activity.RESULT_CANCELED) {
                // Canceled
                Logger.e("Prepare canceled")
            }
        }
    }

    override fun getContext(): Context {
        return this
    }

    inner class EventObserver {

        @Subscribe(threadMode = ThreadMode.MAIN)
        fun onFleetRefresh(event: BasicRefresh) {
            mInfoPanelBinding?.basic = BasicManager.basic
            mInfoPanelBinding?.executePendingBindings()
        }
    }

}
