package com.longer.creditManager.home;

import com.longer.creditManager.bean.LoginBeae;
import com.longer.creditManager.bean.body.LoginBody;

import hxz.www.commonbase.base.mvp.IBaseView;

public interface HomeContract {

    interface View extends IBaseView {

        void showData(LoginBeae loginBeae);

        void onQueryUnread(UnreadBean unreadBean);

    }

    interface Presenter {
        void getNoticeList(LoginBody loginBody);
    }


}
