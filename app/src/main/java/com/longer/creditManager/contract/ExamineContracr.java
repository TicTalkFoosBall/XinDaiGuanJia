package com.longer.creditManager.contract;

import hxz.www.commonbase.model.ExamineBean;
import hxz.www.commonbase.model.ListBody;

import hxz.www.commonbase.base.mvp.IBaseView;

public interface ExamineContracr {

    interface View extends IBaseView {
        void showData(ExamineBean examineBean);

    }
    interface Presenter {
        void getExamineBean(String token, ListBody listBody);
    }


}
