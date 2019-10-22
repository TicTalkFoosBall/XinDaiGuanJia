package com.longer.creditManager.home;

import com.longer.creditManager.bean.LoginBeae;
import com.longer.creditManager.bean.body.LoginBody;
import com.longer.creditManager.net.BaseResultObserver;
import com.longer.creditManager.specificmodel.MainModel;

import hxz.www.commonbase.base.mvp.BasePresenter;
import hxz.www.commonbase.util.ToastUtil;
import io.reactivex.disposables.Disposable;

public class HomePreseenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter{

    private MainModel mainModel; // 所有请求的基类
    private Disposable mDisposable;

    @Override
    public void getNoticeList(LoginBody loginBody) {
        if (!isNotDisposed(mDisposable)){
            mDisposable = mainModel.getLoginBeae(loginBody, new BaseResultObserver<LoginBeae>() {
                @Override
                protected void onResult(LoginBeae loginBeae) {
                    mView.showData(loginBeae);
                }

                @Override
                protected void onFailure(Throwable e, String error) {
                    ToastUtil.show(error);
                }
            });

        }
    }
}
