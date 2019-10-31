package com.longer.creditManager.notice
import com.longer.creditManager.basemodel.Api
import com.longer.creditManager.client.preview.ClientPreviewView
import hxz.www.commonbase.model.ClientPreviewModel
import hxz.www.commonbase.net.BaseResult
import hxz.www.commonbase.net.BaseResultObserver
import hxz.www.commonbase.uibase.mvp.BasePresenterImpl
import hxz.www.commonbase.util.ToastUtil
import hxz.www.commonbase.util.log.LogShow
import io.reactivex.disposables.Disposable

class ClientPreviewPresenter : BasePresenterImpl<ClientPreviewView>() {
    private var mDisposable: Disposable? = null
    fun queryClient(code: String) {
         LogShow.i("queryClient ",code)
            mDisposable=Api.getApiService().getCustomerPreview(code).
        subscribeWith(object : BaseResultObserver<BaseResult<MutableList<ClientPreviewModel>>>() {
            override fun onResult(loginBeae: BaseResult<MutableList<ClientPreviewModel>>?) {
                mView.onQueryPreview(loginBeae?.result)

            }
            override fun onFailure(e: Throwable, error: String) {
                ToastUtil.show(error)
            }
        } )
    }
}