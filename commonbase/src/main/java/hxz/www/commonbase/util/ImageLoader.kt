package com.xingxiu.frame.util

import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.request.RequestOptions
import com.xingxiu.frame.R
import com.xingxiu.frame.app.BaseApplication
import com.xingxiu.frame.app.Config
import retrofit2.http.OPTIONS
import java.io.File

/**
 * Create by Circle on 2019/7/22
 */
object ImageLoader {

    private val THUMBNAIL = 0.5f//默认初始清晰度
    fun load(resId: Int?, imageView: ImageView) {
        Glide.with(imageView).load(resId)
                .into(imageView)
    }

    fun load(file: File, imageView: ImageView) {
        Glide.with(imageView).load(file)
                .into(imageView)
    }



    fun load(url: String?, imageView: ImageView) {
        if (TextUtils.isEmpty(url)) {
            imageView.setImageResource(R.drawable.transparent)
            return
        }
        Glide.with(BaseApplication.getInstance()).load(url).thumbnail(THUMBNAIL).into(imageView)

    }

    fun load(url: String?, imageView: ImageView, emptyResId: Int, defResId: Drawable) {
        if (TextUtils.isEmpty(url))
            imageView.setImageResource(emptyResId)
        else
            Glide.with(BaseApplication.getInstance()).load(url).thumbnail(THUMBNAIL).apply(RequestOptions().placeholder(defResId).error(defResId)).into(imageView)
    }

    fun load(url: String?, imageView: ImageView, defResId: Int) {
        if (TextUtils.isEmpty(url))
            imageView.setImageResource(defResId)
        else
            Glide.with(BaseApplication.getInstance()).load(url).thumbnail(THUMBNAIL).apply(RequestOptions().placeholder(defResId).error(defResId)).into(imageView)
    }

    fun load(url: String?, imageView: ImageView, options: RequestOptions) {
        if (TextUtils.isEmpty(url))
            imageView.setImageResource(options.errorId)
        else
            Glide.with(BaseApplication.getInstance()).load(url).thumbnail(THUMBNAIL).apply(options).into(imageView)
    }


    fun loadAvatar(url: String?, view: ImageView) {
        if (TextUtils.isEmpty(url))
            view.setImageResource(R.mipmap.default_head_circle)
        else
            Glide.with(BaseApplication.getInstance()).load(Config.formatAvatorUrl(url)).thumbnail(THUMBNAIL)
                    .apply(RequestOptions().placeholder(R.mipmap.default_head_circle).error(R.mipmap.default_head_circle).dontAnimate()).into(view)
    }


    fun download(url: String?) {
        Glide.with(BaseApplication.getInstance()).download(url).thumbnail(THUMBNAIL).apply(RequestOptions().priority(Priority.LOW).dontAnimate()).submit()
    }


}