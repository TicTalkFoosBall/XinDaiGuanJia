package hxz.www.commonbase.net;


import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;

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
        LogShow.i("BaseResultObserver  onSuccess begin",t instanceof BaseResult);
        if (t instanceof BaseResult) {
            /**
             * 处理接口返回的code码
             */
            BaseResult responseBean = (BaseResult) t;
            if (responseBean.getCode().equals(HttpErrorCode.USER_NO_LOGIN)||responseBean.getCode().equals(HttpErrorCode.USER_TIMEOUT)) {
                ToastUtil.show(responseBean.getMsg());
                Cache.setUserInfo(null);
            }
            LogShow.i("BaseResultObserver  onSuccess",responseBean.getCode());
            if (responseBean.getCode().equals(HttpErrorCode.SUCCESS))
            {
                LogShow.i("BaseResultObserver  onSuccess");
                onResult(t);
            }
            else {
                dispose();
                onFailure(new Throwable(),((BaseResult) t).getMsg());
            }
        }



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
