package com.longer.creditManager.notice
import com.longer.creditManager.basemodel.Api
import com.longer.creditManager.net.BaseResult
import com.longer.creditManager.net.BaseResultObserver
import com.longer.creditManager.systemmsg.SystemMsgModel
import hxz.www.commonbase.uibase.mvp.BasePresenterImpl
import hxz.www.commonbase.util.ToastUtil
import hxz.www.commonbase.util.log.LogShow
import io.reactivex.disposables.Disposable


class SystemMsgPresenter : BasePresenterImpl<SystemMsgContract.View>() {
    private var mDisposable: Disposable? = null
    fun queryMsgList(page: Int) {
         LogShow.i("queryMsgList ",page);
            mDisposable= Api.getApiService().getSystemMsg(page,20).
        subscribeWith(object : BaseResultObserver<BaseResult<SystemMsgModel>>() {
            override fun onResult(loginBeae: BaseResult<SystemMsgModel>?) {
                 LogShow.i("queryMsgList   ",loginBeae?.result?.toString());

                mView.onQueryBlackList(loginBeae?.result)
            }

            override fun onFailure(e: Throwable, error: String) {
                ToastUtil.show(error)
            }
        } )

    }
}