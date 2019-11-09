package com.longer.creditManager.login;

import hxz.www.commonbase.base.mvp.IBaseView;
import hxz.www.commonbase.cache.UserInfo;
import hxz.www.commonbase.model.BaseUrlModel;
import hxz.www.commonbase.model.LoginBody;

public interface LoginContracr {

    interface View extends IBaseView {

        void showData(UserInfo loginBeae);

        void onQueryBaseUrl(BaseUrlModel model);

    }

    interface Presenter {
        void getLoginBeae(LoginBody loginBody);

        void getBaseUrl(String name);
    }


}
