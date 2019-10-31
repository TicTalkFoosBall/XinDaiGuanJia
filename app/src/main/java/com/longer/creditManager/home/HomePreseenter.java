package com.longer.creditManager.home;

import com.longer.creditManager.basemodel.Api;
import com.longer.creditManager.login.MainModel;

import hxz.www.commonbase.base.mvp.BasePresenter;
import hxz.www.commonbase.model.UnreadBean;
import hxz.www.commonbase.model.todo.buinese.BusineseTab;
import hxz.www.commonbase.net.BaseResult;
import hxz.www.commonbase.net.BaseResultObserver;
import hxz.www.commonbase.util.ToastUtil;
import io.reactivex.disposables.Disposable;

public class HomePreseenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter{

    private MainModel mainModel; // 所有请求的基类
    private Disposable mDisposable;


    public void getUnreadCount()
    {
        if (!isNotDisposed(mDisposable)){
            mDisposable = Api.getApiService().getUnreadCount().subscribeWith( new BaseResultObserver<BaseResult<UnreadBean>>() {
                @Override
                protected void onResult(BaseResult<UnreadBean> unreadBean) {
                    mView.onQueryUnread(unreadBean.getResult());
                }

                @Override
                protected void onFailure(Throwable e, String error) {
                    ToastUtil.show(error);
                }
            });

        }
    }

    public  void readSystemMSg()
    {
        if (!isNotDisposed(mDisposable)){
            mDisposable = Api.getApiService().readSystemMSg().subscribeWith( new BaseResultObserver<BaseResult>() {
                @Override
                protected void onResult(BaseResult unreadBean) {
                }

                @Override
                protected void onFailure(Throwable e, String error) {
                    ToastUtil.show(error);
                }
            });

        }
    }


    public void getTabs() {
        if (!isNotDisposed(mDisposable)) {
            mDisposable = Api.getApiService().getStatisticsTab().subscribeWith(new BaseResultObserver<BaseResult<BusineseTab>>() {
                @Override
                protected void onResult(BaseResult<BusineseTab> unreadBean) {
//                    mView.onQueryBusineseTab(unreadBean.getResult());
                }

                @Override
                protected void onFailure(Throwable e, String error) {
                    ToastUtil.show(error);
                }
            });

        }
    }
}
