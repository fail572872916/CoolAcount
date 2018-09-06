package com.weli.account;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import cn.bmob.v3.Bmob;

public class MyApplication extends MultiDexApplication {

    public static MyApplication application;
    private static Context context;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        context = getApplicationContext();

        //第一：默认初始化
        Bmob.initialize(this, "de7d1d09be6ac525c892f04f62770ca2");
    }

    /**
     * 获取上下文
     * @return
     */
    public static Context getContext() {
        return context;
    }
}
