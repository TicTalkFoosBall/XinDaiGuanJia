package com.xingxiu.frame.util.expand

import android.view.View
import android.widget.EditText


/**
 * 获取edittext内容
 */
fun EditText?.getTextStr(): String {
    if (this != null && this.text != null) {
        return this.text.toString().value().trim()
    }
    return ""
}

/**
 * 修改view可见性 true 为可见
 */
var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

/**
 * 修改view可见性 true 为不可见
 */
var View.isGone: Boolean
    get() = visibility == View.GONE
    set(value) {
        visibility = if (value) View.GONE else View.VISIBLE
    }


