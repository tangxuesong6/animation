package com.example.txs.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout mLlRootview;
    /**
     * 帧动画
     */
    private TextView mTvFrame;
    /**
     * 补间动画
     */
    private TextView mTvTweened;
    /**
     * 属性动画
     */
    private TextView mTvAttribute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        mTvFrame.setOnClickListener(this);
        mTvTweened.setOnClickListener(this);
        mTvAttribute.setOnClickListener(this);
    }

    private void initView() {
        mLlRootview = (LinearLayout) findViewById(R.id.ll_rootview);
        mTvFrame = (TextView) findViewById(R.id.tv_frame);
        mTvTweened = (TextView) findViewById(R.id.tv_tweened);
        mTvAttribute = (TextView) findViewById(R.id.tv_attribute);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            //去往帧动画
            case R.id.tv_frame:
                intent = new Intent(MainActivity.this, FrameActivity.class);
                startActivity(intent);
                break;
                //补间动画
            case R.id.tv_tweened:
                intent = new Intent(MainActivity.this, TweenActivity.class);
                startActivity(intent);
                break;
                //属性动画
            case R.id.tv_attribute:
                break;
            default:
                break;
        }
    }
}
