package com.longer.creditManager.view.webview

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.*
import com.gyf.immersionbar.ImmersionBar
import hxz.www.commonbase.baseui.BaseFragment2
import hxz.www.commonbase.util.ToastUtil
import hxz.www.commonbase.util.log.LogShow
import hxz.www.commonbase.view.dialog.LoadingDialog
import kotlinx.android.synthetic.main.fragment_webview.*


class WebViewFragment : BaseFragment2<Nothing>() {
    private var mUrl: String = ""
    override fun getLayoutId(): Int {
        return com.longer.creditManager.R.layout.fragment_webview
    }

    override fun initEventAndData(savedInstanceState: Bundle?) {
        if (mParams == null) {
            pop()
            return
        }
        val len = mParams.size
        if (len > 0) { //地址
            mParams[0]?.let {
                mUrl = it as String
            }
        }
        var showToolbar = true
        var isUrl = true
        var mTitle = ""
        if (len > 1) {
            mParams[1]?.let {
                showToolbar = it as Boolean
            }

            toolbar?.setLeftClick(navBackListener())
            if (!showToolbar) {
                toolbar?.visibility = View.GONE
            }
        }

        if (len > 2) {
            mParams[2]?.let {
                mTitle = it as String
            }
            toolbar?.setTitle(mTitle)
        }

        if (len > 3) {
            mParams[3]?.let {
                isUrl = it as Boolean
            }
        }

        if (len > 4) {
        }
        LogShow.i("WebViewFragment.kt  initEventAndData", showToolbar, isUrl, isSupport(), mUrl, mTitle)

        initWebview()
        webView.webChromeClient = object : WebChromeClient() {

        }
        webView.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                LogShow.d("shouldOverrideUrlLoading url:$url")
                var shouldOverride = false

                return shouldOverride
            }

            override fun onPageFinished(view: WebView?, url: String) {
                LogShow.d("onPageFinished url:$url")
                LoadingDialog.getInstance().dismiss()
                view?.let {
                    LogShow.d(" title " + view.title)
                }
            }
        }

//       mUrl=getHtmlData(mUrl)
        LoadingDialog.getInstance().show(_mActivity)
        if (isUrl) {
            webView.loadUrl(mUrl)
        } else {
            webView.loadDataWithBaseURL(null, mUrl, "text/html", "utf-8", null)
        }
    }

    private fun isSupport() = !(mUrl.endsWith("pdf") || mUrl.endsWith("doc") || mUrl.endsWith("xls") || mUrl.endsWith("other"))

    private fun readPdf() {
        webView.setDownloadListener(object : DownloadListener {
            override fun onDownloadStart(url: String?, userAgent: String?, contentDisposition: String?, mimetype: String?, contentLength: Long) {
                var uri = Uri.parse(url)
                var intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        })
    }

    private fun initWebview() {
        val settings = webView.settings
        // 设置WebView支持JavaScript
        settings.javaScriptEnabled = true
        //支持自动适配
        settings.useWideViewPort = true
        settings.loadWithOverviewMode = true
        settings.setSupportZoom(true)  //支持放大缩小
        settings.builtInZoomControls = true //显示缩放按钮
        settings.blockNetworkImage = true// 把图片加载放在最后来加载渲染
        settings.allowFileAccess = true // 允许访问文件
        settings.saveFormData = true
        settings.setGeolocationEnabled(true)
        settings.domStorageEnabled = true
        //不加这个图片显示不出来
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
        settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
//        }
    }


      fun getHtmlData(bodyHTML: String):String {
        var head = "<head>"+
        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> " +
                "<style>img{max-width: 100%; width:auto; height:auto!important;}</style>" +
                "</head>"
        return "<html>$head<body>$bodyHTML</body></html>"
    }


    override fun initImmersionBar() {
        super.initImmersionBar()
        ImmersionBar.with(this).keyboardEnable(true).init()
    }

    private fun setTransparentStatusBar() {
        if (isFinishing) return
        LogShow.d("setTransparentStatusBar")
        viewTop?.visibility = View.GONE
        ImmersionBar.with(this).transparentStatusBar().keyboardEnable(true).init()
    }

    override fun getTitleBar(): Int {
        return com.longer.creditManager.R.id.viewTop
    }

    override fun showError(reqCode: Int, msg: String) {

    }

    interface IWebView {
        fun shouldOverrideUrl(fragment: WebViewFragment, view: WebView?, url: String): Boolean
    }

    private inner class DefaultDelegate : IWebView {

        override fun shouldOverrideUrl(fragment: WebViewFragment, view: WebView?, url: String): Boolean {
            //            if (url != null && url.contains("?action=")) {
            if (url.startsWith("weixin://")) {
                LogShow.d("微信支付 拦截到了$url")
                try {
                    val intent = Intent()
                    intent.action = Intent.ACTION_VIEW
                    intent.data = Uri.parse(url)
                    startActivity(intent)

                } catch (e: ActivityNotFoundException) {
                    ToastUtil.show("请安装微信最新版！")
                }

            }

            return false
        }
    }


}
