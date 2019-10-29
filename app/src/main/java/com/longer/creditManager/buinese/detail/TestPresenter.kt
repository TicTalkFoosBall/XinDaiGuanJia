package com.longer.creditManager.buinese.detail
import com.longer.creditManager.basemodel.Api
import hxz.www.commonbase.model.todo.buinese.BusineseDetailBean
import hxz.www.commonbase.net.BaseResult
import hxz.www.commonbase.net.BaseResultObserver
import hxz.www.commonbase.uibase.mvp.BasePresenterImpl
import hxz.www.commonbase.util.ToastUtil


/**
@Author  :rickBei
@Date    :2019/10/29 14:44
@Descripe: From bug to bugs
 **/
class TestPresenter : BasePresenterImpl<TestView>() {

    fun getBusineseDetail(code: String) {

           Api.getApiService().getStatisticsDetail(code).subscribeWith(object : BaseResultObserver<BaseResult<BusineseDetailBean>>() {
                override fun onResult(unreadBean: BaseResult<BusineseDetailBean>) {
                    mView.onQuery(unreadBean.result)
                }

                override fun onFailure(e: Throwable, error: String) {
                    ToastUtil.show(error)
                }
            })


    }
}