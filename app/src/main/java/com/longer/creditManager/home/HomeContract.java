package com.longer.creditManager.home;

import hxz.www.commonbase.model.LoginBeae;
import hxz.www.commonbase.model.LoginBody;

import hxz.www.commonbase.base.mvp.IBaseView;
import hxz.www.commonbase.model.UnreadBean;

public interface HomeContract {

    interface View extends IBaseView {

        void showData(LoginBeae loginBeae);

        void onQueryUnread(UnreadBean unreadBean);

    }

    interface Presenter {
        void getNoticeList(LoginBody loginBody);
    }


}
