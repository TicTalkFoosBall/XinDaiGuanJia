package hxz.www.commonbase.view

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.text.TextUtils
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.RelativeLayout
import getDrawable
import hxz.www.commonbase.R
import kotlinx.android.synthetic.main.layout_toolbar.view.*

class KLToolbar @JvmOverloads constructor(context: Context,
                                          attrs: AttributeSet,
                                          defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var title: String? = null
    private var titleTextColor: Int = Color.WHITE
    private var leftImage: Int = R.drawable.skin_toolbar_back
    private var leftImageVisible = true

    private var leftText: String? = null
    private var leftTextColor = Color.TRANSPARENT

    private var rightImage: Int = R.drawable.skin_toolbar_back
    private var rightText: String? = null
    private var rightTextColor = Color.TRANSPARENT

    init {
        View.inflate(context, R.layout.layout_toolbar, this)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.KLToolbar)
        typedArray?.let {

            title = typedArray.getString(R.styleable.KLToolbar_tb_title)
            setTitle(title)

            if (typedArray.hasValue(R.styleable.KLToolbar_tb_titleTextColor)) {
                titleTextColor = typedArray.getColor(R.styleable.KLToolbar_tb_titleTextColor, Color.TRANSPARENT)
                setTitleTextColor(titleTextColor)
            }

            if (typedArray.hasValue(R.styleable.KLToolbar_tb_leftImage)) {
                leftImage = typedArray.getResourceId(R.styleable.KLToolbar_tb_leftImage, R.drawable.skin_toolbar_back)
                setLeftImage(leftImage)
            }
            leftImageVisible = typedArray.getBoolean(R.styleable.KLToolbar_tb_leftImageVisible, true)
            setLeftImageVisible(leftImageVisible)

            if (typedArray.hasValue(R.styleable.KLToolbar_tb_leftText)) {
                leftText = typedArray.getString(R.styleable.KLToolbar_tb_leftText)
                setLeftText(leftText)
            }

            if (typedArray.hasValue(R.styleable.KLToolbar_tb_leftTextColor)) {
                leftTextColor = typedArray.getColor(R.styleable.KLToolbar_tb_leftTextColor, Color.TRANSPARENT)
                setLeftTextColor(leftTextColor)
            }

            if (typedArray.hasValue(R.styleable.KLToolbar_tb_rightImage)) {
                rightImage = typedArray.getResourceId(R.styleable.KLToolbar_tb_rightImage, R.drawable.transparent)
                setRightImage(rightImage)
            }

            if (typedArray.hasValue(R.styleable.KLToolbar_tb_rightText)) {
                rightText = typedArray.getString(R.styleable.KLToolbar_tb_rightText)
                setRightText(rightText)
            }
            if (typedArray.hasValue(R.styleable.KLToolbar_tb_rightTextColor)) {
                rightTextColor = typedArray.getColor(R.styleable.KLToolbar_tb_rightTextColor, Color.TRANSPARENT)
                setRightTextColor(rightTextColor)
            }
        }
    }

    /**
     * 设置标题
     */
    fun setTitle(text: String?): KLToolbar {
        tv_title.text = text ?: ""
        return this
    }

    /**
     * 设置左侧文本颜色
     */
    fun setTitleTextColor(@ColorInt color: Int): KLToolbar {
        tv_title.setTextColor(color)
        return this
    }


    /**
     * 设置标题
     */
    fun setTitle(@StringRes resId: Int): KLToolbar {
        tv_title.setText(resId)
        return this
    }


    /**
     * 设置左侧按钮
     */
    fun setLeftImage(resId: Int): KLToolbar {
        iv_left.setImageResource(resId)
        return this
    }

    /**
     * 设置左侧按钮
     */
    fun setLeftImage(drawable: Drawable): KLToolbar {
        iv_left.setImageDrawable(drawable)
        return this
    }

    /**
     * 设置左侧按钮是否显示 默认显示
     */
    fun setLeftImageVisible(leftImageVisible: Boolean) {
        iv_left.visibility = if (leftImageVisible) View.VISIBLE else View.GONE
    }

    /**
     * 设置左侧文本
     */
    fun setLeftText(text: String?): KLToolbar {
        if (TextUtils.isEmpty(text)) {
            tv_left.visibility = View.GONE
        } else {
            tv_left.visibility = View.VISIBLE
            tv_left.text = text
        }
        return this
    }

    /**
     * 设置左侧文本
     */
    fun setLeftText(@StringRes resId: Int): KLToolbar {
        if (resId == 0) {
            tv_left.visibility = View.GONE
        } else {
            tv_left.visibility = View.VISIBLE
            tv_left.setText(resId)
            setLeftImageVisible(false)
        }
        return this
    }


    /**
     * 设置左侧文本颜色
     */
    fun setLeftTextColor(@ColorInt color: Int): KLToolbar {
        tv_left.setTextColor(color)
        return this
    }

    /**
     * 设置右侧按钮
     */
    fun setRightImage(@DrawableRes resId: Int): KLToolbar {
        iv_right.visibility = View.VISIBLE
        iv_right.setImageResource(resId)
        return this
    }

    /**
     * 设置右侧按钮是否显示 默认显示
     */
    fun setRightImageVisible(visibility: Int) {
        iv_right.visibility = visibility
    }

    /**
     * 设置右侧文本
     */
    fun setRightText(text: String?): KLToolbar {
        if (TextUtils.isEmpty(text)) {
            tv_right.visibility = View.GONE
        } else {
            tv_right.visibility = View.VISIBLE
            tv_right.text = text
        }
        return this
    }


    /**
     * 设置右侧文本
     */
    fun setRightText(@StringRes resId: Int): KLToolbar {
        if (resId == 0) {
            tv_left.visibility = View.GONE
        } else {
            tv_left.visibility = View.VISIBLE
            tv_left.setText(resId)
        }
        return this
    }

    /**
     * 设置右侧文本颜色
     */
    fun setRightTextColor(color: Int): KLToolbar {
        tv_right.setTextColor(color)
        return this
    }

    /**
     * 设置右侧文本颜色
     */
    fun setRightTextColor(color: ColorStateList?): KLToolbar {
        tv_right.setTextColor(color)
        return this
    }

    /**
     * 设置右侧文本背景
     */
    fun setRightTextBack(res: Int): KLToolbar {
        tv_right.background = res.getDrawable()
        return this
    }


    fun setLeftClick(listener: View.OnClickListener?): KLToolbar {
        iv_left.setOnClickListener(listener)
        tv_left.setOnClickListener(listener)
        return this
    }

    fun setRightClick(listener: View.OnClickListener?): KLToolbar {
        iv_right.setOnClickListener(listener)
        tv_right.setOnClickListener(listener)
        return this
    }

    fun setRightEnable(enable: Boolean) {
        iv_right.isEnabled = enable
        tv_right.isEnabled = enable
    }

    fun getRightText() = tv_right.text.toString().trim()

    fun getRightTextView() = this.tv_right
    /**
     * 设置右侧文本
     */
    fun setSubTitleText(text: String?): KLToolbar {
        if (TextUtils.isEmpty(text)) {
            tv_sub_title.visibility = View.GONE
        } else {
            tv_sub_title.visibility = View.VISIBLE
            tv_title.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16f)
            tv_sub_title.text = text
        }
        return this
    }

    fun getRightIcon() = iv_right
    fun getLEftIcon() = iv_left

}
