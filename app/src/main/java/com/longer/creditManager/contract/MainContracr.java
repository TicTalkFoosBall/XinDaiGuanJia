package com.longer.creditManager.contract;


import com.longer.creditManager.bean.Ba1;


import hxz.www.commonbase.base.mvp.IBaseView;

public interface MainContracr {

    /**
     * 为Activity 提供回调方法
     */
    interface View extends IBaseView {

        void showData(Ba1 userBean);

    }

    /**
     * 为 Presenter 提供回调方法
     */
    interface Presenter {
        void getMainData(String a, String b,String c);
    }

}
