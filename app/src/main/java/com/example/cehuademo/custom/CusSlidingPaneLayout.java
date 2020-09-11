package com.example.cehuademo.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;

public class CusSlidingPaneLayout extends SlidingPaneLayout {

    private boolean isForbid = false;

    public CusSlidingPaneLayout(@NonNull Context context) {
        this(context, null);
    }

    public CusSlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CusSlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 让外面可以调用此方法来禁止滑动
     *
     * @param isForbid
     */
    public void forbidSlide(boolean isForbid) {
        this.isForbid = isForbid;
    }

    /**
     * 拦截触屏事件
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            if (isForbid) {
                return false;
            }
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            if (isForbid) {
                return false;
            }
        }
        return super.onTouchEvent(ev);
    }
}
