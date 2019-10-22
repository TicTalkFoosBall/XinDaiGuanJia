package com.longer.creditManager.blacklist
import com.longer.creditManager.basemodel.Api
import com.longer.creditManager.bean.LoginBeae
import com.longer.creditManager.net.BaseResult
import com.longer.creditManager.net.BaseResultObserver
import hxz.www.commonbase.uibase.mvp.BasePresenterImpl
import hxz.www.commonbase.util.ToastUtil
import hxz.www.commonbase.util.log.LogShow
import io.reactivex.disposables.Disposable


class NoticePresenter : BasePresenterImpl<NoticeListContract.View>() {
    private var mDisposable: Disposable? = null
    fun queryNoticeList(page: Int) {
         LogShow.i("  queryNoticeList ",page);
            mDisposable=Api.getApiService().getNotice(page,20).
        subscribeWith(object : BaseResultObserver<BaseResult<NoticeListModel>>() {
            override fun onResult(loginBeae: BaseResult<NoticeListModel>?) {
                 LogShow.i("queryNoticeList   ",loginBeae?.result?.toString());

                mView.onQueryBlackList(loginBeae?.result)
            }

            override fun onFailure(e: Throwable, error: String) {
                ToastUtil.show(error)
            }
        } )

    }
}