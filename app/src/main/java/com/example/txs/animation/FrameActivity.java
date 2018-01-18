package com.example.txs.animation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;

public class FrameActivity extends AppCompatActivity {
    private SimpleDraweeView mImgvOne;
    private ImageView mImgvTwo;
    private AnimationDrawable animationDrawableOne;
    private AnimationDrawable animationDrawableTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        mImgvOne = (SimpleDraweeView) findViewById(R.id.imgv_one);
        mImgvTwo = (ImageView) findViewById(R.id.imgv_two);
        setAnimation();

    }

    private void setAnimation() {
        //Fresco的动画 和ImageView用法一样
        mImgvOne.setImageResource(R.drawable.fram_one);
        animationDrawableOne = (AnimationDrawable) mImgvOne.getDrawable();
        animationDrawableOne.start();
        //ImageView的动画
        mImgvTwo.setImageResource(R.drawable.fram_two);
        animationDrawableTwo = (AnimationDrawable) mImgvTwo.getDrawable();
        animationDrawableTwo.start();
    }
}
