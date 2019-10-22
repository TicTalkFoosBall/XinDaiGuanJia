package com.longer.creditManager;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;


import com.hjq.bar.TitleBar;
import com.hjq.bar.style.TitleBarLightStyle;
import com.hjq.toast.ToastUtils;
import com.hjq.toast.style.ToastBlackStyle;
import com.longer.creditManager.bean.Token;
import com.longer.creditManager.constant.ApiService;
import com.longer.creditManager.net.HttpManger;


public class MyApplication extends MultiDexApplication{

    /**
     * 全局的上下文.
     */
    private static Context mContext;

    static MyApplication app;
     private static Token token;
    public static String TOKEN="";
    public MyApplication() {

    }

    // todo 腾讯云ID
    public static final String id = "1400247127";


    @Override
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        initLunZiUi();
        initHttp();
        token = new Token();







    }
    /**
     * 初始化网络请求
     */
    private void initHttp() {
        HttpManger.getInstance()
                .setBaseUrl(ApiService.BASE_URL)
                .setOkHttpClient(HttpManger.getInstance().createDefaultClient())
                .setRetrofit(HttpManger.getInstance().createRetrofit());
    }


    /***
     *  初始化轮子全家桶
     */
    private void initLunZiUi() {
        /**
         * ToastBlackStyle  不是固定的可以自己实现自己的风格
         */
        ToastUtils.init(this, new ToastBlackStyle());
        /**
         * TitleBarLightStyle  不是固定的可以自己实现自己的风格
         */
        TitleBar.initStyle(new TitleBarLightStyle(getContext()));
    }

    /**
     * 获取Context.
     *
     * @return
     */
    public static Context getContext() {
        return mContext;
    }

    public static MyApplication get() {
        return app;
    }


}


