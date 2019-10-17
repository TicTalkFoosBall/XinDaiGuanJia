package com.longer.creditManager.preseenter;

import com.longer.creditManager.bean.ExamineBean;
import com.longer.creditManager.bean.LoginBeae;
import com.longer.creditManager.bean.body.ListBody;
import com.longer.creditManager.contract.ExamineContracr;
import com.longer.creditManager.net.BaseResultObserver;
import com.longer.creditManager.specificmodel.MainModel;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import hxz.www.commonbase.base.mvp.BasePresenter;
import io.reactivex.disposables.Disposable;

public class ExaminePreseenter extends BasePresenter<ExamineContracr.View>implements ExamineContracr.Presenter{

    private MainModel mainModel; // 所有请求的基类
    private Disposable mDisposable;



    @Override
    public void getExamineBean(String token, ListBody listBody) {
        mDisposable = mainModel.getExamineBean(token, listBody, new BaseResultObserver<ExamineBean>() {
                @Override
                protected void onResult(ExamineBean examineBean) {
                   mView.showData(examineBean);
                }

                @Override
                protected void onFailure(Throwable e, String error) {
                    ToastUtil.toastLongMessage("数据请求失败");

                }
            });


    }
    public ExaminePreseenter() {
        mainModel = getModel(MainModel.class);
    }


}
