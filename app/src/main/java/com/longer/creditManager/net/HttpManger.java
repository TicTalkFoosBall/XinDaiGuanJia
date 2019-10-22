package com.longer.creditManager.net;

import android.text.TextUtils;

import com.longer.creditManager.MyApplication;

import java.io.IOException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import hxz.www.commonbase.app.BaseApplication;
import hxz.www.commonbase.util.DeviceUtil;
import hxz.www.commonbase.util.log.LogShow;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Dec: Http  网络请求管理  final 修饰 不行被修改
 *
 * @author 韩湘子 on  2019/5/11
 */
public final class HttpManger {


    private Retrofit mRetrofit;
    private String mBaseUrl;
    private OkHttpClient mOkHttpClient;
    private Boolean debug;

    public HttpManger() {
    }

    /***====================================设置构造方法============================****/

    /**
     * 设置baseUrl
     *
     * @param mBaseUrl
     * @return
     */
    public HttpManger setBaseUrl(String mBaseUrl) {
        this.mBaseUrl = mBaseUrl;
        return Holder.INSTANCE;
    }

    /**
     * 设置 OkHttpClient
     *
     * @param mOkHttpClient
     * @return
     */
    public HttpManger setOkHttpClient(OkHttpClient mOkHttpClient) {
        this.mOkHttpClient = mOkHttpClient;
        return Holder.INSTANCE;
    }


    /**
     * 设置retrofit
     *
     * @param mRetrofit
     * @return
     */
    public void setRetrofit(Retrofit mRetrofit) {
        this.mRetrofit = mRetrofit;
    }


    /**
     * 控制开关  对外暴露关闭方法
     *
     * @param debug
     * @return
     */
    public HttpManger setDebug(Boolean debug) {
        this.debug = debug;
        return Holder.INSTANCE;
    }


    /**
     * @return mRetrofit.create(clazz)
     */
    public <T> T getApiService(Class<T> clazz) {
        return mRetrofit.create(clazz);
    }

    /**
     * 自带创建retrofit
     */
    public Retrofit createRetrofit() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .client(mOkHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(ObserveFactory.createMainScheduler())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()));
        return builder.build();
    }

    /**
     * @return OkHttpclient
     */
    public OkHttpClient createDefaultClient() {
        final int timeOut = 20;
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(timeOut, TimeUnit.SECONDS)
                .readTimeout(timeOut, TimeUnit.SECONDS)
                .writeTimeout(timeOut, TimeUnit.SECONDS)
                .addInterceptor(new LoggerInterceptor("HttpManger", true))
                .addInterceptor(new NetCheckInterceptor())
                .addInterceptor(headerIntercepteor)

                //请求失败重试
                .retryOnConnectionFailure(true)
                .proxy(Proxy.NO_PROXY);
        return builder.build();
    }

    Interceptor headerIntercepteor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
 LogShow.i("HttpManger  intercept ",MyApplication.TOKEN);
            Request request = chain.request().newBuilder()
//                        .header("Connection", "close")
                    .header("token", MyApplication.TOKEN)

                    .build();
            return chain.proceed(request);
        }
    };


    public static HttpManger getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final HttpManger INSTANCE = new HttpManger();
    }


}
