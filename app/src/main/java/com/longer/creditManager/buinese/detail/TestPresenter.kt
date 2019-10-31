package com.longer.creditManager.buinese.detail
import com.google.gson.JsonObject
import com.longer.creditManager.basemodel.Api
import hxz.www.commonbase.net.BaseResult
import hxz.www.commonbase.net.BaseResultObserver
import hxz.www.commonbase.uibase.mvp.BasePresenterImpl
import hxz.www.commonbase.util.ToastUtil
import hxz.www.commonbase.util.log.LogShow


class TestPresenter : BasePresenterImpl<TestView>() {

    fun getBusineseDetail(code: String) {

           Api.getApiService().getStatisticsDetail(code).subscribeWith(object : BaseResultObserver<BaseResult<JsonObject>>() {
                override fun onResult(unreadBean: BaseResult<JsonObject>) {
                     LogShow.i("getBusineseDetail   ",unreadBean.result );
//                    mView.onQuery(unreadBean.result)
                }

                override fun onFailure(e: Throwable, error: String) {
                    ToastUtil.show(error)
                }
            })


    }
}