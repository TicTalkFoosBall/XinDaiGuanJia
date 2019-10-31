package com.longer.creditManager.clientdetail

import com.longer.creditManager.basemodel.Api
import com.longer.creditManager.notice.ClientDetailView
import hxz.www.commonbase.model.client.ClientDetail
import hxz.www.commonbase.model.client.ClientModel
import hxz.www.commonbase.net.BaseResult
import hxz.www.commonbase.net.BaseResultObserver
import hxz.www.commonbase.uibase.mvp.BasePresenterImpl
import hxz.www.commonbase.util.ToastUtil
import hxz.www.commonbase.util.log.LogShow
import io.reactivex.disposables.Disposable

class ClientDetailPresenter : BasePresenterImpl<ClientDetailView>()
{

    private var mDisposable: Disposable? = null
    fun getClientPerson(id:String) {
        LogShow.i("getClientPerson ",id);
        mDisposable= Api.getApiService().getCustomerPerson(id).
                subscribeWith(object : BaseResultObserver<BaseResult<ClientDetail>>() {
                    override fun onResult(loginBeae: BaseResult<ClientDetail>?) {
                        LogShow.i("getClientPerson   ",loginBeae?.result?.toString());
                        mView.onQueryClient(loginBeae?.result)
                    }
                    override fun onFailure(e: Throwable, error: String) {
                        ToastUtil.show(error)
                    }
                } )
    }
}
