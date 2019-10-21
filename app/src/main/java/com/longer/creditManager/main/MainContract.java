package com.longer.creditManager.main;

import hxz.www.commonbase.base.mvp.IBaseView;

/**
 * Create by Circle on 2019/7/12
 */
public interface MainContract {
    interface View extends IBaseView {
        void reportLocationResult(boolean isSucc);
    }

}
