package com.xingxiu.frame.util.expand

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.AttrRes
import android.support.annotation.DimenRes
import android.support.annotation.Dimension

import android.support.v4.view.ViewPager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Interpolator
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Scroller
import android.widget.TextView
import hxz.www.commonbase.util.FastClickUtil

fun View.show() {
    if (!isShown && visibility != View.VISIBLE) visibility = View.VISIBLE
}

fun View.hide() {
    hide(false)
}

fun View.hide(gone: Boolean) {
    if (isShown || visibility == View.VISIBLE) {
        visibility = if (gone) View.GONE else View.INVISIBLE
    }
}

/**
 * 计算view的大小
 */
fun Activity.backstageCreateView(layoutRes: Int): View {
    //将布局转化成view对象
    val viewBitmap = LayoutInflater.from(this).inflate(layoutRes, null)

    val manager = this.windowManager
    val outMetrics = DisplayMetrics()
    manager?.defaultDisplay?.getMetrics(outMetrics)
    val width = outMetrics.widthPixels
    val height = outMetrics.heightPixels

    //然后View和其内部的子View都具有了实际大小，也就是完成了布局，相当与添加到了界面上。接着就可以创建位图并在上面绘制了：
    // 整个View的大小 参数是左上角 和右下角的坐标
    viewBitmap.layout(0, 0, width, height)
    val measuredWidth = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY)
    val measuredHeight = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.AT_MOST)

    viewBitmap.measure(measuredWidth, measuredHeight)
    viewBitmap.layout(0, 0, viewBitmap.measuredWidth, viewBitmap.measuredHeight)
    return viewBitmap
}

fun View.backstageCreateBitmap(): Bitmap {
    this.isDrawingCacheEnabled = true
    this.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH
    this.drawingCacheBackgroundColor = Color.WHITE

    // 把一个View转换成图片
    val w = this.width
    val h = this.height

    val bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
    val c = Canvas(bmp)

    c.drawColor(Color.WHITE)
    /** 如果不设置canvas画布为白色，则生成透明  */

    this.layout(0, 0, w, h)
    this.draw(c)
    return bmp
}

fun View.getViewBitmap(): Bitmap? {
    this.clearFocus()
    this.isPressed = false
    val willNotCache = this.willNotCacheDrawing()
    this.setWillNotCacheDrawing(false)
    val color = this.drawingCacheBackgroundColor
    this.drawingCacheBackgroundColor = 0
    if (color != 0) {
        this.destroyDrawingCache()
    }
    this.buildDrawingCache()
    val cacheBitmap = this.drawingCache ?: return null
    val bitmap = Bitmap.createBitmap(cacheBitmap)
    this.destroyDrawingCache()
    this.setWillNotCacheDrawing(willNotCache)
    this.drawingCacheBackgroundColor = color
    return bitmap
}

fun View.getDimensSize(@DimenRes res: Int): Int = ResourceHelper.getDimensionSize(context, res)

fun ProgressBar.updateProgress(progress: Int, animate: Boolean) =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            this.setProgress(progress, animate)
        } else {
            this.progress = progress
        }

fun View.fitSampleBitmap(filePath: String, width: Int, height: Int): Bitmap {
    val options = BitmapFactory.Options()
    options.inJustDecodeBounds = true
    BitmapFactory.decodeFile(filePath, options)
    options.inSampleSize = getFitInSampleSize(width, height, options)
    options.inJustDecodeBounds = false
    return BitmapFactory.decodeFile(filePath, options)
}

fun getFitInSampleSize(reqWidth: Int, reqHeight: Int, options: BitmapFactory.Options): Int {
    var inSampleSize = 1
    if (options.outWidth > reqWidth || options.outHeight > reqHeight) {
        val widthRatio = Math.round(options.outWidth.toFloat() / reqWidth.toFloat())
        val heightRatio = Math.round(options.outHeight.toFloat() / reqHeight.toFloat())
        inSampleSize = Math.min(widthRatio, heightRatio)
    }
    return inSampleSize
}

fun ImageView.scaleBitmap(resource: Bitmap) {
    this.setImageBitmap(resource)
    //获取原图的宽高
    val width = resource.width
    val height = resource.height
    //获取imageView的宽
    val imageViewWidth = this.width

    //计算缩放比例
    val sy = (imageViewWidth * 0.1).toFloat() / (width * 0.1).toFloat()

    //计算图片等比例放大后的高
    val imageViewHeight = (height * sy).toInt()
    val params = this.layoutParams
    params.height = imageViewHeight
    this.layoutParams = params
}

/**
 * 设置View的高度
 */
fun View.height(height: Int): View {
    val params = layoutParams
    params.height = height
    layoutParams = params
    return this
}

/**
 * 设置View高度，限制在min和max范围之内
 * @param h
 * @param min 最小高度
 * @param max 最大高度
 */
fun View.limitHeight(h: Int, min: Int, max: Int): View {
    val params = layoutParams
    when {
        h < min -> params.height = min
        h > max -> params.height = max
        else -> params.height = h
    }
    layoutParams = params
    return this
}

/**
 * 设置View的宽度
 */
fun View.width(width: Int): View {
    val params = layoutParams
    params.width = width
    layoutParams = params
    return this
}

/**
 * 设置View宽度，限制在min和max范围之内
 * @param w
 * @param min 最小宽度
 * @param max 最大宽度
 */
fun View.limitWidth(w: Int, min: Int, max: Int): View {
    val params = layoutParams
    when {
        w < min -> params.width = min
        w > max -> params.width = max
        else -> params.width = w
    }
    layoutParams = params
    return this
}

/**
 * 设置View的宽度和高度
 * @param width 要设置的宽度
 * @param height 要设置的高度
 */
fun View.widthAndHeight(width: Int, height: Int): View {
    val params = layoutParams
    params.width = width
    params.height = height
    layoutParams = params
    return this
}

/**
 * 设置View的margin
 * @param leftMargin 默认是0
 * @param topMargin 默认是0
 * @param rightMargin 默认是0
 * @param bottomMargin 默认是0
 */
fun View.margin(leftMargin: Int = 0, topMargin: Int = 0, rightMargin: Int = 0, bottomMargin: Int = 0): View {
    val params = layoutParams as ViewGroup.MarginLayoutParams
    params.leftMargin = leftMargin
    params.topMargin = topMargin
    params.rightMargin = rightMargin
    params.bottomMargin = bottomMargin
    layoutParams = params
    return this
}

fun TextView.focusMarquee() {
    this.marqueeRepeatLimit = -1
    this.ellipsize = TextUtils.TruncateAt.MARQUEE
    this.maxLines = 1
    this.setSingleLine()
}

/**
 * 设置点击监听
 */
fun View.click(action: (view: View) -> Unit) {
    setOnClickListener {
        if (!FastClickUtil.isFastClick())
            action(it)
    }
}

fun ViewPager.fixedSpeedScroller(duration: Int = 200) {
    try {
        val field = ViewPager::class.java.getDeclaredField("mScroller")
        field.isAccessible = true
        val scroller = FixedSpeedScroller(this.context, LinearInterpolator())
        field.set(this, scroller)
        scroller.setmDuration(duration)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

/**
 * 获取View的截图, 支持获取整个RecyclerView列表的长截图
 * 注意：调用该方法时，请确保View已经测量完毕，如果宽高为0，则将抛出异常
 */
fun View.toBitmap(): Bitmap {
    if (measuredWidth == 0 || measuredHeight == 0) {
        throw RuntimeException("调用该方法时，请确保View已经测量完毕，如果宽高为0，则抛出异常以提醒！")
    }
    return when (this) {
        is RecyclerView -> {
            this.scrollToPosition(0)
            this.measure(View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))

            val bmp = Bitmap.createBitmap(width, measuredHeight, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bmp)

            //draw default bg, otherwise will be black
            if (background != null) {
                background.setBounds(0, 0, width, measuredHeight)
                background.draw(canvas)
            } else {
                canvas.drawColor(Color.WHITE)
            }
            this.draw(canvas)
            //恢复高度
            this.measure(View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
                    View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.AT_MOST))
            bmp //return
        }
        else -> {
            val screenshot = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_4444)
            val canvas = Canvas(screenshot)
            if (background != null) {
                background.setBounds(0, 0, width, measuredHeight)
                background.draw(canvas)
            } else {
                canvas.drawColor(Color.WHITE)
            }
            draw(canvas)// 将 view 画到画布上
            screenshot //return
        }
    }
}


class FixedSpeedScroller : Scroller {
    private var mDuration = 1500

    constructor(context: Context) : super(context) {}

    constructor(context: Context, interpolator: Interpolator) : super(context, interpolator) {}

    override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int, duration: Int) {
        // Ignore received duration, use fixed one instead
        super.startScroll(startX, startY, dx, dy, mDuration)
    }

    override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int) {
        // Ignore received duration, use fixed one instead
        super.startScroll(startX, startY, dx, dy, mDuration)
    }

    fun setmDuration(time: Int) {
        mDuration = time
    }

    fun getmDuration(): Int {
        return mDuration
    }
}

object ResourceHelper {

    @Dimension
    fun getDimensionSize(context: Context, @DimenRes dimenRes: Int): Int {
        return context.resources.getDimensionPixelSize(dimenRes)
    }

    fun getDrawableByAttr(context: Context, @AttrRes attrRes: Int): Drawable? {
        val attrsArray = intArrayOf(attrRes)
        val typedArray = context.obtainStyledAttributes(attrsArray)
        val drawable = typedArray.getDrawable(0)
        typedArray.recycle()
        return drawable
    }

}

