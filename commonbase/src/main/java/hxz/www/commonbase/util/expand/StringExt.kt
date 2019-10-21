package com.xingxiu.frame.util.expand

import android.text.TextUtils
import java.util.regex.Pattern


fun String?.value(): String = this ?: ""

fun CharSequence?.value(): CharSequence = this ?: ""

fun String?.value(defaultValue: String): String {
    return if (TextUtils.isEmpty(this)) defaultValue else this!!
}

fun CharSequence?.value(defaultValue: String): CharSequence {
    return if (TextUtils.isEmpty(this)) defaultValue else this!!
}

/**
 * 是否是手机号
 */
fun String.isPhone() = "(\\+\\d+)?1[3458]\\d{9}$".toRegex().matches(this)

/**
 * 是否是邮箱地址
 */
fun String.isEmail() = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?".toRegex().matches(this)

/**
 * 是否是身份证号码
 */
fun String.isIDCard() = "[1-9]\\d{16}[a-zA-Z0-9]".toRegex().matches(this)

/**
 * 是否是中文字符
 */
fun String.isChinese() = "^[\u4E00-\u9FA5]+$".toRegex().matches(this)

/**
 * 从字符串中提取数字
 */
fun String.extractInt(): Int {
    val newString = StringBuffer()
    newString.append("")
    val matcher = Pattern.compile("\\d").matcher(this)
    while (matcher.find()) { newString.append(matcher.group()) }
    return newString.toString().getInt()
}
