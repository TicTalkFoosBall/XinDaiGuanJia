package com.longer.creditManager.login;

import hxz.www.commonbase.base.mvp.IBaseView;
import hxz.www.commonbase.cache.UserInfo;
import hxz.www.commonbase.model.LoginBody;

public interface LoginContracr {

     interface View extends IBaseView{

        void showData(UserInfo loginBeae);

    }
    interface Presenter {
        void getLoginBeae( LoginBody loginBody);
    }


}
