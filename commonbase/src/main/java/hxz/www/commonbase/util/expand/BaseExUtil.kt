
import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import android.widget.ImageView
import android.widget.TextView
import hxz.www.commonbase.app.BaseApplication


import hxz.www.commonbase.util.DisplayUtil
import hxz.www.commonbase.util.GsonUtil
import hxz.www.commonbase.util.ImageLoaders
import hxz.www.commonbase.util.ToastUtil



/**
 * 资源地址转color
 */
fun Int.getColor(context: Context =  BaseApplication.getInstance()): Int {
    return try {
        ContextCompat.getColor(context, this)
    } catch (ignore: Resources.NotFoundException) {
        0
    }
}

fun Int.getColor(): Int {
    return try {
        ContextCompat.getColor(BaseApplication.getInstance(), this)
    } catch (ignore: Resources.NotFoundException) {
        0
    }
}
/**
 * 资源地址转drawable
 */
fun Int.getDrawable(): Drawable {
    return try {
        ContextCompat.getDrawable(BaseApplication.getInstance(), this)!!
    } catch (ignore: Resources.NotFoundException) {
        ColorDrawable()
    }
}

/**
 * 资源地址转string
 */
fun Int.getString(): String {
    return try {BaseApplication.getInstance().resources.getString(this)
    } catch (ignore: Resources.NotFoundException) {
        ""
    }
}

fun Float.dp2px(): Int {
    return DisplayUtil.dp2px(this)
}

fun String?.isEquals(string: String?): Boolean {
    return !(TextUtils.isEmpty(this) || !this.equals(string))
}

fun String?.isStrEmpty(): Boolean {
    return TextUtils.isEmpty(this)
}

//字符串转int
fun String.getInt(): Int {
    return if (isEmpty()) {
        0
    } else {
        toInt()
    }
}

fun String.substrAfterLast(delimiterStr: String): String {
    return this.substringAfterLast(delimiterStr)
}

fun String.substrBefore(delimiterStr: String): String {
    return this.substringBefore(delimiterStr)
}

fun String.substrAfter(delimiterStr: String): String {
    return this.substringAfter(delimiterStr)
}

inline fun <reified T> String.fromJson(): T {
    return GsonUtil.fromJson<T>(this, T::class.java)
}

fun String?.toast() {
        ToastUtil.show(this.value())
}

//资源或者string都ok
fun TextView.setText(msg: Any?) {
    try {
        if (msg is Int)
            this.setText(msg)
        if (msg is String)
            this.setText(msg)
    } catch (ignore: Resources.NotFoundException) {
    }
}


//资源或者url都ok
fun ImageView.loadImg(res: Any?) {
    try {
        if (res is Int) {
            this.setImageResource(res)
        } else if (res is String)
            ImageLoaders.load(res, this)
    } catch (ignore: Resources.NotFoundException) {
    }
}

