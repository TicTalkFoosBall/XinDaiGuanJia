package com.longer.creditManager.home;

import hxz.www.commonbase.base.mvp.IBaseView;
import hxz.www.commonbase.model.UnreadBean;
import hxz.www.commonbase.model.todo.buinese.BusineseTab;

public interface HomeContract {

    interface View extends IBaseView {

        void onQueryBusineseTab(BusineseTab tab);
        void onQueryUnread(UnreadBean unreadBean);

    }

    interface Presenter {

    }


}
