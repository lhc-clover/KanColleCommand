package cn.cctech.kccommand.fragments

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.text.TextUtils
import android.view.View
import cn.cctech.kancolle.oyodo.Oyodo
import cn.cctech.kancolle.oyodo.managers.Fleet
import cn.cctech.kccommand.R
import cn.cctech.kccommand.fragments.base.LazyFragment
import cn.cctech.kccommand.utils.findView
import cn.cctech.kccommand.utils.getFleetTagColor
import net.lucode.hackware.magicindicator.MagicIndicator
import net.lucode.hackware.magicindicator.buildins.UIUtil
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.model.PositionData
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView

class FleetFragment : LazyFragment() {

    private var mTabs: Array<String> = arrayOf("1", "2", "3", "4")
    private var mMagicIndicator: MagicIndicator? = null

    companion object {

        fun newInstance(): FleetFragment {
            return FleetFragment()
        }
    }

    override fun onCreateViewLazy(savedInstanceState: Bundle?) {
        super.onCreateViewLazy(savedInstanceState)
        setContentView(R.layout.fragment_fleet)
        initViews()
        setTabNames()
        watchShipMap()
    }

    private fun initViews() {
        mMagicIndicator = findView(R.id.fleet_indicator)
        val commonNavigator = CommonNavigator(context)
        commonNavigator.adapter = object : CommonNavigatorAdapter() {

            override fun getCount(): Int = mTabs.size

            override fun getTitleView(context: Context, index: Int): IPagerTitleView {
                val colorTransitionPagerTitleView = FleetPagerTitleView(context)
                colorTransitionPagerTitleView.normalColor = ResourcesCompat.getColor(resources, R.color.tabTextColorNormal, context.theme)
                colorTransitionPagerTitleView.selectedColor = ResourcesCompat.getColor(resources, R.color.tabTextColorSelect, context.theme)
                colorTransitionPagerTitleView.textSize = 10f
                colorTransitionPagerTitleView.text = mTabs[index]
                colorTransitionPagerTitleView.setOnClickListener {
                    commonNavigator.onPageSelected(index)
                    setCurrentFragment(index)
                }
                return colorTransitionPagerTitleView
            }

            override fun getIndicator(context: Context): IPagerIndicator? = FleetIndicator(context)
        }
        commonNavigator.isAdjustMode = true
        mMagicIndicator?.navigator = commonNavigator
        setCurrentFragment(0)
    }

    private fun setCurrentFragment(index: Int) {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.fleet_pager, FleetPageFragment.newInstance(index))
        transaction.commit()
    }

    private fun invalidateIndicator() {
        activity?.runOnUiThread { mMagicIndicator?.navigator?.notifyDataSetChanged() }
    }

    private fun setTabNames() {
        Fleet.deckNames.forEachIndexed { index, name ->
            mTabs[index] = if (TextUtils.isEmpty(name.value)) getString(R.string.fleet_lock) else name.value
            Oyodo.attention().watch(name, {
                mTabs[index] = it
                invalidateIndicator()
            })
        }
    }

    private fun watchShipMap() {
        Oyodo.attention().watch(Fleet.shipWatcher, {
            invalidateIndicator()
        })
        Fleet.deckShipIds.forEach { Oyodo.attention().watch(it, { invalidateIndicator() }) }
    }

    private class FleetIndicator(context: Context?) : View(context), IPagerIndicator {

        private var mPositionDataList: List<PositionData>? = null
        private var mPaint: Paint = Paint(1)
        private var mPosition = -1

        init {
            mPaint.style = Paint.Style.FILL
        }

        override fun onPositionDataProvide(p0: MutableList<PositionData>?) {
            mPositionDataList = p0
        }

        override fun onPageScrollStateChanged(p0: Int) {

        }

        override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

        }

        override fun onPageSelected(p0: Int) {
            mPosition = p0
            invalidate()
        }

        override fun onDraw(canvas: Canvas?) {
            mPositionDataList?.forEachIndexed { i, positionData ->
                mPaint.color = getColor(i)
                if (i == mPosition) {
                    canvas?.drawRect(positionData.mLeft.toFloat() + 1, positionData.mTop.toFloat(), positionData.mRight.toFloat() - 1, positionData.mBottom.toFloat(), mPaint)
                } else {
                    canvas?.drawRect(positionData.mLeft.toFloat() + 1, positionData.mBottom - 4f, positionData.mRight.toFloat() - 1, positionData.mBottom.toFloat(), mPaint)
                }
            }
        }

        private fun getColor(index: Int): Int {
            val colorResId = getFleetTagColor(index)
            return ResourcesCompat.getColor(resources, colorResId, context.theme)
        }
    }

    private class FleetPagerTitleView(context: Context?) : SimplePagerTitleView(context) {
        init {
            val padding = UIUtil.dip2px(context, 4.0)
            setPadding(padding, 0, padding, 0)
        }
    }
}
