package com.longer.creditManager.recording

import android.os.Bundle
import android.view.View
import hxz.www.commonbase.baseui.BaseFragment2
import hxz.www.commonbase.baseui.mvp.BaseView2
import hxz.www.commonbase.model.NoticeItem
import hxz.www.commonbase.net.constant.ApiService.FILE_URL
import hxz.www.commonbase.uibase.mvp.BasePresenterImpl
import hxz.www.commonbase.util.fragment.FragmentHelper
import hxz.www.commonbase.util.log.LogShow
import kotlinx.android.synthetic.main.fragment_noticedetail.*
import kotlinx.android.synthetic.main.fragment_noticelist.toolbar


class RichTextFragment : BaseFragment2<NoticeDetailPresenter>(), NoticeDetailView {
    override fun showError(reqCode: Int, msg: String?) {

    }

    override fun initEventAndData(savedInstanceState: Bundle?) {
        var title = getParameter(0) as String
        toolbar.setTitle(title)
        var url = getParameter(1) as String
        getParameter(2)?.let {
            var item = it as NoticeItem
            toolbar.setRightText("附件")
            toolbar.setRightClick(View.OnClickListener
            {
                start(FragmentHelper.newInstance(AttachmentFragment::class.java, "notic", item))
            })
        }
        url = getHtmlData(url)
        LogShow.i("RichTextFragment initEventAndData", url)

        toolbar.setLeftClick(View.OnClickListener
        {
            pop()
        })

        initWeb()
        webView.loadDataWithBaseURL(FILE_URL, url, "text/html", "utf-8", FILE_URL)
    }

    private fun getHtmlData(bodyHTML: String): String {
        val head = ("<head>"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> "
                + "<style>img{max-width: 100%; width:100%; height:auto;}*{margin:0px;}</style>"
                + "</head>")
        return "<html>$head<body>$bodyHTML</body></html>"
    }

    private fun initWeb() {
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true//允许使用js
        //不支持屏幕缩放
        webSettings.setSupportZoom(false)
        webSettings.builtInZoomControls = false
        //不显示webview缩放按钮
        webSettings.displayZoomControls = false
    }


    override fun getLayoutId() = com.longer.creditManager.R.layout.fragment_noticedetail
}

class NoticeDetailPresenter : BasePresenterImpl<NoticeDetailView>()

interface NoticeDetailView : BaseView2

