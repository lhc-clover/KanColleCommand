package cn.cctech.kccommand.widgets

import `in`.srain.cube.views.ptr.PtrDefaultHandler
import `in`.srain.cube.views.ptr.PtrFrameLayout
import `in`.srain.cube.views.ptr.PtrHandler
import `in`.srain.cube.views.ptr.PtrUIHandler
import `in`.srain.cube.views.ptr.indicator.PtrIndicator
import android.content.Context
import android.graphics.Color
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import cn.cctech.kccommand.R
import com.marshalchen.ultimaterecyclerview.CustomUltimateRecyclerview

class FleetListView : CustomUltimateRecyclerview {

    private val mPtrDelay = 2000L
    private var mHeaderText: TextView? = null

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        mRecyclerView.setBackgroundColor(Color.TRANSPARENT)
        val ptrView = findViewById<View>(R.id.store_house_ptr_frame)
        ptrView.setBackgroundColor(Color.TRANSPARENT)
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)

        val header = FleetViewHeader(context)
        mHeaderText = header.findViewById(R.id.tv_fleet_header_info)
        setCustomSwipeToRefresh()
        mPtrFrameLayout.removePtrUIHandler(header)
        mPtrFrameLayout.headerView = header
        mPtrFrameLayout.addPtrUIHandler(header)
        mPtrFrameLayout.setPtrHandler(object : PtrHandler {
            override fun checkCanDoRefresh(ptrFrameLayout: PtrFrameLayout, view: View, view2: View): Boolean {
                return PtrDefaultHandler.checkContentCanBePulledDown(ptrFrameLayout, view, view2)
            }

            override fun onRefreshBegin(ptrFrameLayout: PtrFrameLayout) {
                Handler().postDelayed({ mPtrFrameLayout.refreshComplete() }, mPtrDelay)
            }
        })
    }

    fun setHeader(header: String) {
        mHeaderText?.text = header
    }

    private inner class FleetViewHeader : LinearLayout, PtrUIHandler {

        constructor(context: Context) : super(context) {
            init(context)
        }

        constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
            init(context)
        }

        constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
            init(context)
        }

        private fun init(context: Context) {
            LayoutInflater.from(context).inflate(R.layout.fleet_list_header, this)
        }

        override fun onUIReset(frame: PtrFrameLayout) {

        }

        override fun onUIRefreshPrepare(frame: PtrFrameLayout) {

        }

        override fun onUIRefreshBegin(frame: PtrFrameLayout) {

        }

        override fun onUIRefreshComplete(frame: PtrFrameLayout) {

        }

        override fun onUIPositionChange(frame: PtrFrameLayout, isUnderTouch: Boolean, status: Byte, ptrIndicator: PtrIndicator) {

        }
    }
}
