
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import hxz.www.commonbase.app.BaseApplication

import java.io.File

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
//        if (TextUtils.isEmpty(url)) {
//            imageView.setImageResource(R.drawable.transparent)
//            return
//        }
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





}