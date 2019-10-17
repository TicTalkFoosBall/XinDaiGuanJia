package com.longer.creditManager.contract;

import com.longer.creditManager.bean.ExamineBean;
import com.longer.creditManager.bean.LoginBeae;
import com.longer.creditManager.bean.body.ListBody;
import com.longer.creditManager.bean.body.LoginBody;

import hxz.www.commonbase.base.mvp.IBaseView;

public interface ExamineContracr {

    interface View extends IBaseView {
        void showData(ExamineBean examineBean);

    }
    interface Presenter {
        void getExamineBean(String token, ListBody listBody);
    }


}
