package com.longer.creditManager.login;

import com.longer.creditManager.bean.LoginBeae;
import com.longer.creditManager.bean.body.LoginBody;
import hxz.www.commonbase.net.BaseResultObserver;
import com.longer.creditManager.specificmodel.MainModel;

import hxz.www.commonbase.base.mvp.BasePresenter;
import hxz.www.commonbase.util.ToastUtil;
import io.reactivex.disposables.Disposable;

public class LoginPreseenter extends BasePresenter<LoginContracr.View> implements LoginContracr.Presenter{

    private MainModel mainModel; // 所有请求的基类
    private Disposable mDisposable;

    @Override
    public void getLoginBeae(LoginBody loginBody) {

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

    public LoginPreseenter() {
        mainModel = getModel(MainModel.class);
    }

}
