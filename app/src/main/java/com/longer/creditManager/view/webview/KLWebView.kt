package com.longer.creditManager.view.webview

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView



class KLWebView : WebView {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        setPadding(0, 0, 0, 0)
        settings.setSupportZoom(false)
        settings.textZoom = 100
        settings.displayZoomControls = false
        settings.useWideViewPort = true
        settings.cacheMode = WebSettings.LOAD_NO_CACHE
        settings.pluginState = WebSettings.PluginState.ON
        settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
        settings.allowUniversalAccessFromFileURLs = true // h5游戏需要设置允许跨域
        // android 5.0及以上默认不支持Mixed Content
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
        requestFocus(View.FOCUS_DOWN)

//        webViewClient = SslErrorWebClient(context)
    }


    override fun destroy() {
        super.destroy()
        try {
            loadUrl("about:blank")
            webChromeClient = null
            webViewClient = null
            val parent = parent as ViewGroup
            parent.removeView(this)
            destroy()
            clearHistory()//没有历史记录，这里会抛出异常
            clearFormData()
            removeAllViews()
        } catch (e: Exception) {

        }
    }
}
