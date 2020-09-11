package com.example.cehuademo.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;

import androidx.appcompat.widget.AppCompatImageView;


public class CircleImageView extends AppCompatImageView {

    private static final String TAG = "RoundRectImageView";
    private float roundRatio = 1.0f;
    private Path path;

    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        if (path == null) {
            path = new Path();
            path.addCircle(getWidth() / 2, getHeight() / 2, 70, Path.Direction.CW);
        }
        canvas.save();
        canvas.clipPath(path);
        super.onDraw(canvas);
        canvas.restore();
    }
}
