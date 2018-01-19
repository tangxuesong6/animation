package com.example.txs.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

public class TweenActivity extends AppCompatActivity implements View.OnClickListener {
    private SimpleDraweeView mImgvTween;
    /**
     * 动画集合
     */
    private TextView mTvSet;
    /**
     * alpha
     */
    private TextView mTvAlpha;
    /**
     * scale
     */
    private TextView mTvScale;
    /**
     * translate
     */
    private TextView mTvTranslate;
    /**
     * rotate
     */
    private TextView mTvRotate;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);
        initView();
        initListener();
    }

    private void initListener() {
        mTvSet.setOnClickListener(this);
        mTvAlpha.setOnClickListener(this);
        mTvScale.setOnClickListener(this);
        mTvTranslate.setOnClickListener(this);
        mTvRotate.setOnClickListener(this);
        mImgvTween.setOnClickListener(this);
    }

    private void initView() {
        mTvSet = (TextView) findViewById(R.id.tv_set);
        mTvAlpha = (TextView) findViewById(R.id.tv_alpha);
        mTvScale = (TextView) findViewById(R.id.tv_scale);
        mTvTranslate = (TextView) findViewById(R.id.tv_translate);
        mTvRotate = (TextView) findViewById(R.id.tv_rotate);
        mImgvTween = (SimpleDraweeView) findViewById(R.id.imgv_tween);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //点击图片
            case R.id.imgv_tween:
                Toast.makeText(this, "点击了图片", Toast.LENGTH_SHORT).show();
                break;
                //动画集合　alpha和scale的组合
            case R.id.tv_set:
                //xml实现
//                animation = AnimationUtils.loadAnimation(this, R.anim.set_one);
//                mImgvTween.startAnimation(animation);
                //代码实现
                AnimationSet animationSet = new AnimationSet(this,null);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f,1.0f);
                alphaAnimation.setDuration(2000);
                animationSet.addAnimation(alphaAnimation);
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f,1.0f,0.0f,1.0f,Animation.RELATIVE_TO_PARENT,0.5f,Animation.RELATIVE_TO_PARENT,0.5f);
                scaleAnimation.setDuration(2000);
                animationSet.addAnimation(scaleAnimation);
                mImgvTween.startAnimation(animationSet);
                break;
                //透明
            case R.id.tv_alpha:
                //xml实现
//                animation = AnimationUtils.loadAnimation(this, R.anim.alpha_one);
//                mImgvTween.startAnimation(animation);
                //代码实现
                AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(3000);
                mImgvTween.startAnimation(anim);
                break;
                //缩放
            case R.id.tv_scale:
                animation = AnimationUtils.loadAnimation(this, R.anim.scale_one);
                mImgvTween.startAnimation(animation);
                break;
                //位移
            case R.id.tv_translate:
                animation = AnimationUtils.loadAnimation(this, R.anim.translate_one);
                //循环次数　－１表示一直循环
                animation.setRepeatCount(-1);
                mImgvTween.startAnimation(animation);
                break;
                //旋转
            case R.id.tv_rotate:
                animation = AnimationUtils.loadAnimation(this, R.anim.rotate_one);
                mImgvTween.startAnimation(animation);
                break;

            default:
                break;
        }

    }
}
