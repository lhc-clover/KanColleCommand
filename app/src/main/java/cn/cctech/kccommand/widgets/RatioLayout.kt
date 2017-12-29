package cn.cctech.kccommand.widgets

import android.content.Context
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import android.widget.RelativeLayout
import cn.cctech.kccommand.R


class RatioLayout : RelativeLayout {

    private var mRatio: Float = 0.toFloat()
    private var mScreenWidth = Integer.MAX_VALUE
    private var mScreenHeight = Integer.MAX_VALUE

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
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val outMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(outMetrics)
        mScreenWidth = outMetrics.widthPixels
        mScreenHeight = outMetrics.heightPixels
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.RatioLayout)
            mRatio = a.getFloat(R.styleable.RatioLayout_ratio, 1f)
            a.recycle()
        } else {
            mRatio = 1f
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(View.getDefaultSize(0, widthMeasureSpec), View.getDefaultSize(0, heightMeasureSpec))
        var childWidthSize = minOf(measuredWidth, mScreenWidth)
        var childHeightSize = (childWidthSize * mRatio).toInt()
        if (childHeightSize > mScreenHeight) {
            childHeightSize = mScreenHeight
            childWidthSize = (mScreenHeight / mRatio).toInt()
        }
        // height is equal to  width
        val width = View.MeasureSpec.makeMeasureSpec(childWidthSize, View.MeasureSpec.EXACTLY)
        val height = View.MeasureSpec.makeMeasureSpec(childHeightSize, View.MeasureSpec.EXACTLY)
        super.onMeasure(width, height)
    }

}
