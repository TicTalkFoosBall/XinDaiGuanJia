package com.longer.creditManager.view.webview

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.gyf.immersionbar.ImmersionBar
import com.longer.creditManager.R
import hxz.www.commonbase.baseui.BaseFragment2
import hxz.www.commonbase.util.ToastUtil
import hxz.www.commonbase.util.log.LogShow
import hxz.www.commonbase.view.dialog.LoadingDialog
import kotlinx.android.synthetic.main.fragment_webview.*


class WebViewFragment : BaseFragment2<Nothing>() {
    private var mUrl: String = ""
    private val delegate = DefaultDelegate()
    override fun getLayoutId(): Int {
        return R.layout.fragment_webview
    }

    override fun initEventAndData(savedInstanceState: Bundle?) {
        if (mParams == null) {
            pop()
            return
        }
        val len = mParams.size
        if (len > 0) { //地址

            mUrl = mParams[0] as String

            mUrl += if (mUrl.contains("?")) {
                "&"
            } else {
                "?"
            }

        }

        if (len > 1) {
            val showToolbar = mParams[1] as Boolean
            toolbar?.setLeftClick(navBackListener())
            if (!showToolbar) {
                toolbar?.visibility = View.GONE
            }
        }

        if (len > 2) {
            val mTitle = mParams[2] as String
            toolbar?.setTitle(mTitle)
        }


        webView.webChromeClient = object : WebChromeClient() {

        }
        webView.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                LogShow.d("override url:$url")
                var shouldOverride = false
                url?.let {
                    if (!url.toLowerCase().startsWith("https://") && !url.toLowerCase().startsWith("http://")) {
                        //加载手机内置支付
                        toLoadInnerApp(url)
                        return true
                    }
                    shouldOverride = delegate.shouldOverrideUrl(this@WebViewFragment, view, url)
                    if (url.contains("payCenter.html")) {
                        // 关闭当前页面
                        pop()
                    }

                }

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

        LogShow.d("url=$mUrl")

        webView.loadUrl(mUrl)

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
        return R.id.viewTop
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
