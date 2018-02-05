package cn.cctech.kccommand.widgets

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.style.ImageSpan

class NextSpotImageSpan(drawable: Drawable?) : ImageSpan(drawable) {

    override fun draw(canvas: Canvas?, text: CharSequence?, start: Int, end: Int, x: Float, top: Int, y: Int, bottom: Int, paint: Paint?) {
        val d = drawable
        canvas?.save()
        val fm = paint?.fontMetricsInt
        if (fm != null) {
            val transY: Float = ((y + fm.descent) + (y + fm.ascent)) / 2.0f - d.bounds.bottom / 2.0f
            canvas?.translate(x, transY)
        }
        d.draw(canvas)
        canvas?.restore()
    }

    override fun getSize(paint: Paint?, text: CharSequence?, start: Int, end: Int, fm: Paint.FontMetricsInt?): Int {
        val d = drawable
        val rect = d.bounds
        if (fm != null) {
            val fmPaint = paint?.fontMetricsInt
            val fontHeight = fmPaint?.bottom?.minus(fmPaint.top) ?: 0
            val imageHeight = rect?.bottom?.minus(rect.top) ?: 0

            val top = imageHeight / 2 - fontHeight / 4
            val bottom = imageHeight / 2 + fontHeight / 4

            fm.ascent = -bottom
            fm.top = -bottom
            fm.bottom = top
            fm.descent = top
        }
        return rect.right
    }
}