package com.longer.creditManager.net;

import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 *
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
     *
     * @return
     */
    public HttpManger setOkHttpClient(OkHttpClient mOkHttpClient) {
        this.mOkHttpClient = mOkHttpClient;
        return Holder.INSTANCE;
    }


    /**
     * 设置retrofit
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
        final int timeOut = 10;
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(timeOut, TimeUnit.SECONDS)
                .readTimeout(timeOut, TimeUnit.SECONDS)
                .writeTimeout(timeOut, TimeUnit.SECONDS)
             //   .addInterceptor(new LoggerInterceptor("HttpManger", debug))
                .addInterceptor(new NetCheckInterceptor())
                //请求失败重试
                .retryOnConnectionFailure(true)
                .proxy(Proxy.NO_PROXY);
        return builder.build();
    }


    public static HttpManger getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final HttpManger INSTANCE = new HttpManger();
    }


}
