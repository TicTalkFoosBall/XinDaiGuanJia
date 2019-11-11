package hxz.www.commonbase.net;


import android.text.TextUtils;

import java.io.IOException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import hxz.www.commonbase.cache.Cache;
import hxz.www.commonbase.util.log.LogShow;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public final class HttpManger {

    public static String FILE_URL = Cache.getBAseUrl().getResourceUrl();

    private Retrofit mRetrofit;
    private Retrofit mOriRetrofit;
    private String mBaseUrl = "http://1234/";
    private String mOriBaseUrl = "http://longersoftdb.vicp.cc:8000/";
    private OkHttpClient mOkHttpClient;
    private OkHttpClient mOriOkHttpClient;
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
        LogShow.i("HttpManger  setBaseUrl",mBaseUrl,this.mBaseUrl);
        if (!TextUtils.isEmpty(mBaseUrl)) {
            this.mBaseUrl = mBaseUrl;
        }
        LogShow.i("HttpManger  setBaseUrl 2",this.mBaseUrl);
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
     * 设置 OkHttpClient
     *
     * @param mOkHttpClient
     * @return
     */
    public HttpManger setOriOkHttpClient(OkHttpClient mOkHttpClient) {
        LogShow.i("HttpManger  setOriOkHttpClient");
        this.mOriOkHttpClient = mOkHttpClient;
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
     * 设置retrofit
     *
     * @param mRetrofit
     * @return
     */
    public void setOriRetrofit(Retrofit mRetrofit) {
        this.mOriRetrofit = mRetrofit;
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
     * @return mRetrofit.create(clazz)
     */
    public <T> T getoriApiService(Class<T> clazz) {
        return mOriRetrofit.create(clazz);
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
     * 自带创建retrofit
     */
    public Retrofit createOriRetrofit() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(mOriBaseUrl)
                .client(mOriOkHttpClient)
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
//                .addInterceptor(new BaseUrlInterceptor())
                .addInterceptor(headerIntercepteor)

                //请求失败重试
                .retryOnConnectionFailure(true)
                .proxy(Proxy.NO_PROXY);
        return builder.build();
    }

    Interceptor headerIntercepteor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request().newBuilder()
                    .header("token", Cache.getToken())

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
