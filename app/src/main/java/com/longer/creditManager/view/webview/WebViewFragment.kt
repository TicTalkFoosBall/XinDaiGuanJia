package com.longer.creditManager.view.webview

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.webkit.DownloadListener
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.gyf.immersionbar.ImmersionBar
import hxz.www.commonbase.baseui.BaseFragment2
import hxz.www.commonbase.util.ToastUtil
import hxz.www.commonbase.util.log.LogShow
import hxz.www.commonbase.view.dialog.LoadingDialog
import kotlinx.android.synthetic.main.fragment_webview.*


class WebViewFragment : BaseFragment2<Nothing>() {
    private var mUrl: String = ""
    private val delegate = DefaultDelegate()
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

            mUrl = mParams[0] as String

        }
        var showToolbar = true
        var isUrl = true
        var openSystem = false//是否启动系统浏览器
        if (len > 1) {
            showToolbar = mParams[1] as Boolean
            toolbar?.setLeftClick(navBackListener())
            if (!showToolbar) {
                toolbar?.visibility = View.GONE
            }
        }

        if (len > 2) {
            val mTitle = mParams[2] as String
            toolbar?.setTitle(mTitle)
        }

        if (len > 3) {
            isUrl = mParams[3] as Boolean
        }

        if (len > 4) {
        }
        LogShow.i("WebViewFragment.kt  initEventAndData", showToolbar, isUrl, isSupport(),mUrl)

            initWebview()
            webView.webChromeClient = object : WebChromeClient() {

            }
            webView.webViewClient = object : WebViewClient() {

                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    LogShow.d("override url:$url")
                    var shouldOverride = false

                    return shouldOverride
                }

                override fun onPageFinished(view: WebView?, url: String) {
                    LoadingDialog.getInstance().dismiss()
                    view?.let {
                        LogShow.d(" title " + view.title)
                        if (!TextUtils.isEmpty(view.title))
                            toolbar?.setTitle(view.title)
                    }

                }

            }

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
    }

    private fun toLoadInnerApp(url: String) {
        try {
            val it = Intent(Intent.ACTION_VIEW)
            it.data = Uri.parse(url)
            startActivity(it)
        } catch (e: Exception) {
            //可能情况： 手机没有安装支付宝或者微信。或者安装支付宝或者微信但是版本过低
        }

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
