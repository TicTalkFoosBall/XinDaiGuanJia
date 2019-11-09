package hxz.www.commonbase.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.multidex.MultiDexApplication;

import com.hjq.bar.TitleBar;
import com.hjq.bar.style.TitleBarLightStyle;
import com.hjq.toast.ToastUtils;
import com.hjq.toast.style.ToastBlackStyle;

import hxz.www.commonbase.cache.Cache;
import hxz.www.commonbase.net.HttpManger;
import hxz.www.commonbase.util.log.LogShow;

public class BaseApplication extends MultiDexApplication {
    private static BaseApplication baseApplication;
    private ActivityLifecycleCallbacks mActivityLifecycleCallbacks;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
        registerActivityListener();
        initLunZiUi();
        LogShow.i("BaseApplication  onCreate");
        initHttp(Cache.getBAseUrl().getServiceUrl());
    }

    /**
     * 初始化网络请求
     */
    public void initHttp(String baseUrl) {
        LogShow.i("BaseApplication  initHttp", baseUrl);
//        if (TextUtils.isEmpty(baseUrl)) {
//            HttpManger.getInstance()
//                    .setOriOkHttpClient(HttpManger.getInstance().createDefaultClient())
//                    .setOriRetrofit(HttpManger.getInstance().createOriRetrofit());
//
//        } else {
//            HttpManger.getInstance()
//                    .setBaseUrl(baseUrl)
//                    .setOkHttpClient(HttpManger.getInstance().createDefaultClient())
//                    .setRetrofit(HttpManger.getInstance().createRetrofit());
//        }

        HttpManger.getInstance()
                .setOriOkHttpClient(HttpManger.getInstance().createDefaultClient())
                .setOriRetrofit(HttpManger.getInstance().createOriRetrofit());

        HttpManger.getInstance()
                .setBaseUrl(baseUrl)
                .setOkHttpClient(HttpManger.getInstance().createDefaultClient())
                .setRetrofit(HttpManger.getInstance().createRetrofit());
    }

    /**
     * 初始化轮子全家桶
     */
    private void initLunZiUi() {
        /**
         * ToastBlackStyle  不是固定的可以自己实现自己的风格
         */
        ToastUtils.init(this, new ToastBlackStyle());
        /**
         * TitleBarLightStyle  不是固定的可以自己实现自己的风格
         */
        TitleBar.initStyle(new TitleBarLightStyle(this));
    }


    public static BaseApplication getInstance() {
        return baseApplication;
    }

    public void reloadApp() {

    }

    /**
     * token过期
     */
    public void tokenExpire() {
        AppManager.getInstance().finishAllActivity();
    }

    /**
     * 退出程序
     */
    public void exitApp() {
        if (mActivityLifecycleCallbacks != null) {
            unregisterActivityLifecycleCallbacks(mActivityLifecycleCallbacks);
        }
    }


    private void registerActivityListener() {
        registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks = new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                AppManager.getInstance().addActivity(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                AppManager.getInstance().removeActivity(activity);
            }
        });
    }


}
