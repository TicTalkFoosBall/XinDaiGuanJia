package com.longer.creditManager.preseenter;


import com.longer.creditManager.bean.Ba1;
import com.longer.creditManager.contract.MainContracr;
import com.longer.creditManager.net.BaseResultObserver;
import com.longer.creditManager.specificmodel.MainModel;


import hxz.www.commonbase.base.mvp.BasePresenter;
import io.reactivex.disposables.Disposable;

public class MP extends BasePresenter<MainContracr.View> implements MainContracr.Presenter{

    private MainModel mainModel;
    private Disposable disposable;



    @Override
    public void getMainData(String a, final String b, String c) {
        if (!isNotDisposed(disposable)){
            disposable = mainModel.getBa1(a, b, c, new BaseResultObserver<Ba1>() {
                @Override
                protected void onResult(Ba1 ba1) {
                    mView.showData(ba1);
                }

                @Override
                protected void onFailure(Throwable e, String error) {
                    mView.showMsg(error);
                }
            });
        }
    }

    public  MP(){
        mainModel = getModel(MainModel.class);
    }


}
