package hxz.www.commonbase.net;


import android.content.Intent;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;

import hxz.www.commonbase.app.BaseApplication;
import hxz.www.commonbase.cache.Cache;
import hxz.www.commonbase.util.ToastUtil;
import hxz.www.commonbase.util.log.LogShow;
import io.reactivex.observers.DisposableSingleObserver;
import retrofit2.HttpException;

/**
 * Dec:数据回调处理
 *
 * @author 韩湘子
 */
public abstract class BaseResultObserver<T> extends DisposableSingleObserver<T> {


    /***
     *  创建两个方法  成功失败
     */

    @Override
    public void onSuccess(T t) {
        dispose();
        if (t instanceof ResponseBean) {
            /**
             * 处理接口返回的code码
             */
            ResponseBean responseBean = (ResponseBean) t;
            if (responseBean.getCode().equals(HttpErrorCode.USER_NO_LOGIN)) {
                Cache.setUserInfo(null);
//                BaseApplication.getInstance().tokenExpire();
//                Intent intent = new Intent( BaseApplication.getInstance(), LoginActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                BaseApplication.getInstance().startActivity(intent);
            }

        }
        LogShow.i("BaseResultObserver  onSuccess");
        onResult(t);
    }

    @Override
    public void onError(Throwable e) {
        dispose();
        String msgError = "";
        if (e instanceof ConnectException) {
            msgError = "网络连接异常";
        } else if (e instanceof SocketTimeoutException) {
            msgError = "网络连接超时";
        } else if (e instanceof UnknownHostException) {
            msgError = "网络异常";
        } else if (e instanceof UnknownServiceException) {
            msgError = "网络异常";
        } else if (e instanceof HttpException) {
            msgError = "网络异常";
        } else if (e instanceof Error) {
            msgError = e.getMessage();
        }
        LogShow.i("BaseResultObserver  onError",msgError,e.getMessage());
        ToastUtil.show(msgError);
        onFailure(e, msgError);

    }

    /**
     * 成功回调
     *
     * @param t
     */
    protected abstract void onResult(T t);

    /**
     * 失败回调
     *
     * @param e
     * @param error
     */
    protected abstract void onFailure(Throwable e, String error);


}
