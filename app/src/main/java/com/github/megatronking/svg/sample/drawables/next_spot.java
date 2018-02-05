package com.github.megatronking.svg.sample.drawables;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;

import com.github.megatronking.svg.support.SVGRenderer;

/**
 * AUTO-GENERATED FILE.  DO NOT MODIFY.
 * 
 * This class was automatically generated by the
 * SVG-Generator. It should not be modified by hand.
 */
public class next_spot extends SVGRenderer {

    public next_spot(Context context) {
        super(context);
        mAlpha = 1.0f;
        mWidth = dip2px(297.0f);
        mHeight = dip2px(297.0f);
    }

    @Override
    public void render(Canvas canvas, int w, int h, ColorFilter filter) {
        final float scaleX = w / 297.0f;
        final float scaleY = h / 297.0f;
        
        mPath.reset();
        mRenderPath.reset();
        
        mFinalPathMatrix.setValues(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f});
        mFinalPathMatrix.postScale(scaleX, scaleY);
        
        mPath.moveTo(148.5f, 0.0f);
        mPath.cubicTo(66.485f, 0.0f, 0.0f, 66.485f, 0.0f, 148.5f);
        mPath.cubicTo(0.0f, 230.515f, 66.485f, 297.0f, 148.5f, 297.0f);
        mPath.cubicTo(230.515f, 297.0f, 297.0f, 230.515f, 297.0f, 148.5f);
        mPath.cubicTo(297.0f, 66.485f, 230.515f, 0.0f, 148.5f, 0.0f);
        mPath.close();
        mPath.moveTo(148.5f, 0.0f);
        mPath.moveTo(91.972f, 230.051f);
        mPath.rLineTo(32.016f, -81.504f);
        mPath.lineTo(91.972f, 66.449f);
        mPath.rLineTo(131.057f, 81.371f);
        mPath.lineTo(91.972f, 230.051f);
        mPath.close();
        mPath.moveTo(91.972f, 230.051f);
        
        mRenderPath.addPath(mPath, mFinalPathMatrix);
        if (mFillPaint == null) {
            mFillPaint = new Paint();
            mFillPaint.setStyle(Paint.Style.FILL);
            mFillPaint.setAntiAlias(true);
        }
        mFillPaint.setColor(applyAlpha(-1052689, 1.0f));
        mFillPaint.setColorFilter(filter);
        canvas.drawPath(mRenderPath, mFillPaint);

    }

}