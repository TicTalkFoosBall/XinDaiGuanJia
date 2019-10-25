package com.longer.creditManager.preseenter;

import hxz.www.commonbase.model.ExamineBean;
import hxz.www.commonbase.model.ListBody;
import com.longer.creditManager.contract.ExamineContracr;
import hxz.www.commonbase.net.BaseResultObserver;
import com.longer.creditManager.specificmodel.MainModel;

import hxz.www.commonbase.base.mvp.BasePresenter;
import hxz.www.commonbase.util.ToastUtil;
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
                    ToastUtil.show("数据请求失败");
                }
            });


    }
    public ExaminePreseenter() {
        mainModel = getModel(MainModel.class);
    }


}
