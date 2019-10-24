package com.longer.creditManager.notice
import com.longer.creditManager.basemodel.Api
import com.longer.creditManager.client.ClientModel
import hxz.www.commonbase.net.BaseResult
import hxz.www.commonbase.net.BaseResultObserver
import hxz.www.commonbase.uibase.mvp.BasePresenterImpl
import hxz.www.commonbase.util.ToastUtil
import hxz.www.commonbase.util.log.LogShow
import io.reactivex.disposables.Disposable

class ClientPresenter : BasePresenterImpl<ClientContract.View>() {
    private var mDisposable: Disposable? = null
    fun queryClient(page: Int) {
         LogShow.i("queryClient ",page);
            mDisposable=Api.getApiService().getCustomer(page,20,"").
        subscribeWith(object : BaseResultObserver<BaseResult<MutableList<ClientModel>>>() {
            override fun onResult(loginBeae: BaseResult<MutableList<ClientModel>>?) {
                 LogShow.i("queryClient   ",loginBeae?.result?.toString());
                mView.queryClient(loginBeae?.result)
            }
            override fun onFailure(e: Throwable, error: String) {
                ToastUtil.show(error)
            }
        } )
    }
}