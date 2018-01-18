package com.example.txs.animation;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @author txs
 * @date 2018/01/17
 */

public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
