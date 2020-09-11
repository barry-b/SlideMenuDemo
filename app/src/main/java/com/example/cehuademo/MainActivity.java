package com.example.cehuademo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.cehuademo.custom.CusSlidingPaneLayout;

import static android.graphics.Color.RED;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    private CusSlidingPaneLayout mSlidingPaneLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView head = findViewById(R.id.img_head);
        Glide.with(getBaseContext()).load(R.mipmap.test).into(head);
        mSlidingPaneLayout = findViewById(R.id.slide_layout);
        ImageView btn = findViewById(R.id.btn_pop);

        mSlidingPaneLayout.forbidSlide(false);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mSlidingPaneLayout.isOpen()){
                    mSlidingPaneLayout.closePane();
                }else{
                    mSlidingPaneLayout.openPane();
                }
            }
        });

        initSlidingPaneLayout();
    }

    private void initSlidingPaneLayout() {
        final LinearLayout container = findViewById(R.id.main_container);
        final View leftView = mSlidingPaneLayout.getChildAt(0);
        mSlidingPaneLayout.setPanelSlideListener(new SlidingPaneLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(@NonNull View panel, float slideOffset) {
                //设置侧面栏缩放
                leftView.setPivotX(-leftView.getWidth() / 6.0f);
                leftView.setPivotY(leftView.getHeight() / 2.0f);
                leftView.setScaleX(0.8f + 0.2f * slideOffset);
                leftView.setScaleY(0.8f + 0.2f * slideOffset);

                //设置首页滑动时缩放
                container.setScaleX(1f - 0.2f * slideOffset);
                container.setScaleY(1f - 0.2f * slideOffset);
                container.setElevation(6.0f * slideOffset);
                Log.d(TAG, "onPanelSlide: slideOffset==="+slideOffset);
            }

            @Override
            public void onPanelOpened(@NonNull View panel) {

            }

            @Override
            public void onPanelClosed(@NonNull View panel) {

            }
        });

        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mSlidingPaneLayout.isOpen()){
                    mSlidingPaneLayout.closePane();
                }
            }
        });
    }
}
