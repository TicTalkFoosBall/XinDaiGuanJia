package com.longer.creditManager.login;

import com.longer.creditManager.basemodel.Api;

import hxz.www.commonbase.app.BaseApplication;
import hxz.www.commonbase.base.mvp.BasePresenter;
import hxz.www.commonbase.cache.Cache;
import hxz.www.commonbase.cache.UserInfo;
import hxz.www.commonbase.model.BaseUrlModel;
import hxz.www.commonbase.model.LoginBody;
import hxz.www.commonbase.net.BaseResult;
import hxz.www.commonbase.net.BaseResultObserver;
import hxz.www.commonbase.util.ToastUtil;
import hxz.www.commonbase.util.log.LogShow;
import io.reactivex.disposables.Disposable;

public class LoginPreseenter extends BasePresenter<LoginContracr.View> implements LoginContracr.Presenter {

    private MainModel mainModel; // 所有请求的基类
    private Disposable mDisposable;

    @Override
    public void getLoginBeae(LoginBody loginBody) {

        if (!isNotDisposed(mDisposable)) {
            mDisposable = mainModel.getLoginBeae(loginBody, new BaseResultObserver<BaseResult<UserInfo>>() {
                @Override
                protected void onResult(BaseResult<UserInfo> loginBeae) {
                    mView.showData(loginBeae.getResult());
                }

                @Override
                protected void onFailure(Throwable e, String error) {
                    ToastUtil.show(error);
                }
            });
        }
    }

    @Override
    public void getBaseUrl(String name) {

        mDisposable = Api.getOriApiService().getBaseUrl(name).
                subscribeWith(new BaseResultObserver<BaseResult<BaseUrlModel>>() {
                    @Override
                    protected void onResult(BaseResult<BaseUrlModel> loginBeae) {
                        if (loginBeae != null && loginBeae.getResult() != null) {
                            LogShow.i("LoginPreseenter  onResult",loginBeae.getResult().toString());
                            Cache.setBaseUrl(loginBeae.getResult());
                            BaseApplication.getInstance().initHttp(loginBeae.getResult().getServiceUrl());
                            mView.onQueryBaseUrl(loginBeae.getResult());
                        }
                    }

                    @Override
                    protected void onFailure(Throwable e, String error) {
                        ToastUtil.show(error);
                    }
                });
    }


    public LoginPreseenter() {
        mainModel = getModel(MainModel.class);
    }

}
