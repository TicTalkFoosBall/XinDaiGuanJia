package com.longer.creditManager.buinese;

import com.longer.creditManager.basemodel.Api;

import hxz.www.commonbase.base.mvp.BasePresenter;
import hxz.www.commonbase.model.todo.buinese.BusineseTab;
import hxz.www.commonbase.net.BaseResult;
import hxz.www.commonbase.net.BaseResultObserver;
import hxz.www.commonbase.util.ToastUtil;
import io.reactivex.disposables.Disposable;

public class BusinesePreseenter extends BasePresenter<BusineseView> {

    private Disposable mDisposable;


    public void getTabs() {
        if (!isNotDisposed(mDisposable)) {
            mDisposable = Api.getApiService().getStatisticsTab().subscribeWith(new BaseResultObserver<BaseResult<BusineseTab>>() {
                @Override
                protected void onResult(BaseResult<BusineseTab> unreadBean) {
                    mView.onQueryBusineseTab(unreadBean.getResult());
                }

                @Override
                protected void onFailure(Throwable e, String error) {
                    ToastUtil.show(error);
                }
            });

        }
    }

}
