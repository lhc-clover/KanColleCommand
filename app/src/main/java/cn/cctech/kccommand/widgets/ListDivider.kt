package cn.cctech.kccommand.widgets

import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.support.annotation.ColorInt
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

class ListDivider
/**
 * 列表分割线
 *
 * @param dividerColor    分割线颜色
 * @param backgroundColor 列表背景颜色
 * @param thickness       分割线粗细
 * @param startPadding    起始padding px
 * @param endPadding      终止padding px
 * @param orientation     列表方向
 * @param startOffset     起始偏移个数
 * @param endOffset       终止偏移个数
 */
(@param:ColorInt private val mDividerColor: Int, @param:ColorInt private val mBackgroundColor: Int, private val mThickness: Int,
 private val mStartPadding: Int, private val mEndPadding: Int, orientation: Int, private val mStartOffset: Int, private val mEndOffset: Int) : RecyclerView.ItemDecoration() {
    private var mOrientation: Int = 0

    init {
        setOrientation(orientation)
    }

    fun setOrientation(orientation: Int) {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw IllegalArgumentException("invalid orientation")
        }
        mOrientation = orientation
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        if (mOrientation == VERTICAL_LIST) {
            drawVertical(c, parent)
        } else {
            drawHorizontal(c, parent)
        }
    }

    private fun drawVertical(c: Canvas?, parent: RecyclerView?) {
        val left = parent!!.paddingLeft
        val right = parent.width - parent.paddingRight

        val childCount = parent.childCount
        val totalItemCount = parent.adapter?.itemCount ?: 0
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val position = parent.getChildAdapterPosition(child)
            if (position == -1 || position < mStartOffset || position > totalItemCount - mEndOffset)
                continue
            val params = child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + mThickness
            val background = ColorDrawable(mBackgroundColor)
            background.setBounds(left, top, right, bottom)
            background.draw(c)
            val divider = ColorDrawable(mDividerColor)
            divider.setBounds(left + mStartPadding, top, right - mEndPadding, bottom)
            divider.draw(c)
        }
    }

    private fun drawHorizontal(c: Canvas?, parent: RecyclerView?) {
        val top = parent!!.paddingTop
        val bottom = parent.height - parent.paddingBottom

        val childCount = parent.childCount
        val totalItemCount = parent.adapter?.itemCount ?: 0
        for (i in mStartOffset until childCount) {
            val child = parent.getChildAt(i)
            val position = parent.getChildAdapterPosition(child)
            if (position == -1 || position < mStartOffset || position > totalItemCount - mEndOffset)
                continue
            val params = child.layoutParams as RecyclerView.LayoutParams
            val left = child.right + params.rightMargin
            val right = left + mThickness
            val background = ColorDrawable(mBackgroundColor)
            background.setBounds(left, top, right, bottom)
            background.draw(c)
            val divider = ColorDrawable(mDividerColor)
            divider.setBounds(left, top + mStartPadding, right, bottom - mEndPadding)
            divider.draw(c)
        }
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val itemPosition = parent.getChildAdapterPosition(view)
        val totalItemCount = parent.adapter?.itemCount ?: 0
        if (itemPosition < mStartOffset || itemPosition > totalItemCount - mEndOffset) return
        if (mOrientation == VERTICAL_LIST) {
            outRect.set(0, 0, 0, mThickness)
        } else {
            outRect.set(0, 0, mThickness, 0)
        }
    }

    companion object {

        val HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL
        val VERTICAL_LIST = LinearLayoutManager.VERTICAL
    }
}
