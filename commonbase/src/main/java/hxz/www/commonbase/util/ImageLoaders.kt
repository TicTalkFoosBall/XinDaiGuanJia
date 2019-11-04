package hxz.www.commonbase.util

import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import hxz.www.commonbase.R
import hxz.www.commonbase.app.BaseApplication
import java.io.File

object ImageLoaders {

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
//        if (TextUtils.isEmpty(url)) {
//            imageView.setImageResource(R.drawable.transparent)
//            return
//        }
        Glide.with(BaseApplication.getInstance()).load(url).thumbnail(THUMBNAIL).into(imageView)

    }

    fun loadBusinesw(url: String?, imageView: ImageView) {
        val options = RequestOptions()
                .format(DecodeFormat.PREFER_RGB_565)
                .priority(Priority.LOW)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)

        options.placeholder(R.mipmap.business_default).error(R.mipmap.business_default)
        Glide.with(BaseApplication.getInstance()).load(url).apply(options).into(imageView)

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





}