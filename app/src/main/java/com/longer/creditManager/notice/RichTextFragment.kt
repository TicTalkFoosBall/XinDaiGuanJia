package com.longer.creditManager.recording

import android.os.Bundle
import android.view.View
import hxz.www.commonbase.baseui.BaseFragment2
import hxz.www.commonbase.baseui.mvp.BaseView2
import hxz.www.commonbase.model.NoticeItem
import hxz.www.commonbase.net.HttpManger.FILE_URL
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
//        url = "<html><head><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> <style>img{max-width: 100%; width:100%; height:auto;}*{margin:0px;}</style></head><body><p>31231111111</p>\n" +
//                "    <table style=\"border-collapse: collapse; width: 100%;\" border=\"1\">\n" +
//                "    <tbody>\n" +
//                "    <tr>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    </tr>\n" +
//                "    <tr>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    </tr>\n" +
//                "    <tr>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    </tr>\n" +
//                "    <tr>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    </tr>\n" +
//                "    <tr>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\"><img src=\"static/js/plugins/tinymce4.7.5/plugins/emoticons/img/smiley-innocent.gif\" alt=\"innocent\" /></td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    <td style=\"width: 14.2857%;\">&nbsp;</td>\n" +
//                "    </tr>\n" +
//                "    </tbody>\n" +
//                "    </table></body></html>\n"

//        url="<!DOCTYPE html>\n" +
//                "<html>\n" +
//                "<head> \n" +
//                "<meta charset=\"utf-8\"> \n" +
//                "<title>菜鸟教程(runoob.com)</title> \n" +
//                "</head>\n" +
//                "<body>\n" +
//                "\n" +
//                "<img src=\"http://g.hiphotos.baidu.com/image/h%3D300/sign=b5e4c905865494ee982209191df4e0e1/c2cec3fdfc03924590b2a9b58d94a4c27d1e2500.jpg\" alt=\"Smiley face\" width=\"42\" height=\"42\">\n" +
//                "\n" +
//                "</body>\n" +
//                "</html>"
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

