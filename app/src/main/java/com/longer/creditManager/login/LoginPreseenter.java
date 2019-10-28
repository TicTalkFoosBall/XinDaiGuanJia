package com.longer.creditManager.login;

import hxz.www.commonbase.base.mvp.BasePresenter;
import hxz.www.commonbase.cache.UserInfo;
import hxz.www.commonbase.model.LoginBody;
import hxz.www.commonbase.net.BaseResult;
import hxz.www.commonbase.net.BaseResultObserver;
import hxz.www.commonbase.util.ToastUtil;
import io.reactivex.disposables.Disposable;

public class LoginPreseenter extends BasePresenter<LoginContracr.View> implements LoginContracr.Presenter{

    private MainModel mainModel; // 所有请求的基类
    private Disposable mDisposable;

    @Override
    public void getLoginBeae(LoginBody loginBody) {

        if (!isNotDisposed(mDisposable)){
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

    public LoginPreseenter() {
        mainModel = getModel(MainModel.class);
    }

}
