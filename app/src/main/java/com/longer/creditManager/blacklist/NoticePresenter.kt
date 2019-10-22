package com.longer.creditManager.blacklist
import com.longer.creditManager.basemodel.Api
import com.longer.creditManager.bean.LoginBeae
import com.longer.creditManager.net.BaseResultObserver
import hxz.www.commonbase.uibase.mvp.BasePresenterImpl
import hxz.www.commonbase.util.ToastUtil
import hxz.www.commonbase.util.log.LogShow
import io.reactivex.disposables.Disposable

/**
@Author  :rickBei
@Date    :2019/8/9 16:16
@Descripe: From bug to bugs
 **/
class NoticePresenter : BasePresenterImpl<NoticeListContract.View>() {
    private var mDisposable: Disposable? = null
    fun queryNoticeList(page: Int) {
         LogShow.i("  queryNoticeList ",page);
            mDisposable=Api.getApiService().getNotice(page,20).
        subscribeWith(object : BaseResultObserver<MutableList<NoticeListModel>>() {
            override fun onResult(loginBeae: MutableList<NoticeListModel>) {
                mView.onQueryBlackList(loginBeae)
            }

            override fun onFailure(e: Throwable, error: String) {
                ToastUtil.show(error)
            }
        } )

    }
}