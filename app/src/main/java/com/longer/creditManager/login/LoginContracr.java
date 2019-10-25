package com.longer.creditManager.login;

import hxz.www.commonbase.model.LoginBeae;
import hxz.www.commonbase.model.LoginBody;

import hxz.www.commonbase.base.mvp.IBaseView;

public interface LoginContracr {

     interface View extends IBaseView{

        void showData(LoginBeae loginBeae);

    }
    interface Presenter {
        void getLoginBeae( LoginBody loginBody);
    }


}
