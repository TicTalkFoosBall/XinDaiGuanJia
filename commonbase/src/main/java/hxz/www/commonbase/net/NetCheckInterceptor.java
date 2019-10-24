package hxz.www.commonbase.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


import hxz.www.commonbase.app.BaseApplication;

import java.io.IOException;
import java.net.UnknownHostException;


import okhttp3.Interceptor;
import okhttp3.Response;

/**
 *
 * Dec:网络检查连接器  拦截器
 * ApplicationInterceptor(应用拦截器)
 * NetworkInterceptor（网络拦截器）
 */
public class NetCheckInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        if (!isNetworkConnected(BaseApplication.getInstance())) {
            throw new UnknownHostException("Network not connected");
        }
        return chain.proceed(chain.request().newBuilder().build());
    }
    /**
     * 判断网络是否连接
     *
     * @param context 上下文
     * @return boolean 网络连接状态
     */
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            //获取连接对象
            if (mNetworkInfo != null) {
                //判断是TYPE_MOBILE网络

                if (ConnectivityManager.TYPE_MOBILE == mNetworkInfo.getType()) {
                    //判断移动网络连接状态
                    NetworkInfo.State STATE_MOBILE = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
                    if (STATE_MOBILE == NetworkInfo.State.CONNECTED) {
                        return mNetworkInfo.isAvailable();
                    }
                }
                //判断是TYPE_WIFI网络
                if (ConnectivityManager.TYPE_WIFI == mNetworkInfo.getType()) {

                    //判断WIFI网络状态
                    NetworkInfo.State STATE_WIFI = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
                    if (STATE_WIFI == NetworkInfo.State.CONNECTED) {
                        return mNetworkInfo.isAvailable();
                    }
                }
            }
        }
        return false;
    }

//    public static boolean isNetworkConnected(Context context){
//        if (context != null){
//            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.COMPANION_DEVICE_SERVICE);
//        }
//
//        return false;
//    }

}
