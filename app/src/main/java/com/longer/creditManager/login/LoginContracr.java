package com.longer.creditManager.login;

import com.longer.creditManager.bean.LoginBeae;
import com.longer.creditManager.bean.body.LoginBody;

import hxz.www.commonbase.base.mvp.IBaseView;

public interface LoginContracr {

     interface View extends IBaseView{

        void showData(LoginBeae loginBeae);

    }
    interface Presenter {
        void getLoginBeae( LoginBody loginBody);
    }


}
