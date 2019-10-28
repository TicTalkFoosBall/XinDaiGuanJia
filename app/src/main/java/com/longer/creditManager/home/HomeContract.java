package com.longer.creditManager.home;

import hxz.www.commonbase.base.mvp.IBaseView;
import hxz.www.commonbase.model.UnreadBean;

public interface HomeContract {

    interface View extends IBaseView {


        void onQueryUnread(UnreadBean unreadBean);

    }

    interface Presenter {

    }


}
