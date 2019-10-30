package com.longer.creditManager.recording

import android.os.Bundle
import android.view.View
import hxz.www.commonbase.baseui.BaseFragment2
import hxz.www.commonbase.baseui.mvp.BaseView2
import hxz.www.commonbase.model.NoticeItem
import hxz.www.commonbase.uibase.mvp.BasePresenterImpl
import hxz.www.commonbase.util.fragment.FragmentHelper
import hxz.www.commonbase.util.log.LogShow
import kotlinx.android.synthetic.main.fragment_noticedetail.*
import kotlinx.android.synthetic.main.fragment_noticelist.toolbar


class NoticeDetailFragment : BaseFragment2<NoticeDetailPresenter>(), NoticeDetailView {
    override fun showError(reqCode: Int, msg: String?) {

    }

    override fun initEventAndData(savedInstanceState: Bundle?) {
        var url = getParameter(0) as String
        var item = getParameter(1) as NoticeItem
        LogShow.i("NoticeDetailFragment.kt  initEventAndData", item.toString())
        toolbar.setTitle("公告详情")
        toolbar.setRightText("附件")
        toolbar.setRightClick(View.OnClickListener
        {
            start(FragmentHelper.newInstance(AttachmentFragment::class.java,item))
        })
        toolbar.setLeftClick(View.OnClickListener
        {
         pop()
        })


        initWeb()
        webView.loadDataWithBaseURL(null, url, "text/html", "utf-8", null);
    }


    private fun initWeb() {
        val webSettings = webView.getSettings()
        webSettings.setJavaScriptEnabled(true)//允许使用js
//不支持屏幕缩放
        webSettings.setSupportZoom(false)
        webSettings.setBuiltInZoomControls(false)
//不显示webview缩放按钮
        webSettings.setDisplayZoomControls(false)
    }


    override fun getLayoutId() = com.longer.creditManager.R.layout.fragment_noticedetail
}

class NoticeDetailPresenter : BasePresenterImpl<NoticeDetailView>() {

}

interface NoticeDetailView : BaseView2 {


}

