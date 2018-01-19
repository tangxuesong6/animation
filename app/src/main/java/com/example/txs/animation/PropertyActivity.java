package com.example.txs.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewAnimator;

public class PropertyActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnBegin;
    private TextView mTvTest;
    private Button mBtnSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        mBtnBegin = (Button) findViewById(R.id.btn_begin);
        mTvTest = (TextView) findViewById(R.id.tv_test);
        mBtnSet = (Button) findViewById(R.id.btn_set);
        mBtnBegin.setOnClickListener(this);
        mBtnSet.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_begin:
//                seeValueAnimator();
                seeObjectAnimatorRotation();
                break;
            case R.id.btn_set:
                setAnimationSet();
                break;
                default:
                    break;
        }

    }

    private void setAnimationSet() {
        Animator animator = AnimatorInflater.loadAnimator(this,R.animator.anim_set);
        animator.setTarget(mTvTest);
        animator.start();
    }

    private void seeObjectAnimatorRotation() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mTvTest,"rotation",0f,180f,0f);
        objectAnimator.setDuration(1000);
        objectAnimator.setRepeatCount(3);
        objectAnimator.start();
    }

    private void seeValueAnimator() {
        ValueAnimator animator = ValueAnimator.ofFloat(0f,1f);
        animator.setDuration(3000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float vaule = (float) valueAnimator.getAnimatedValue();
                System.out.println(vaule+"");
            }
        });
        animator.start();
    }
}
