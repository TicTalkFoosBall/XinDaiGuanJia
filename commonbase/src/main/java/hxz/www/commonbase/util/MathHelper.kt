

import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.regex.Matcher
import java.util.regex.Pattern

object MathHelper {
    /**
     * 保留两位小数，不四舍五入
     */
    fun formatFloatNumber(value: Double): String {
        return if (value != 0.00) {
            val decimalFormat = DecimalFormat("0.00")
            decimalFormat.roundingMode = RoundingMode.DOWN
            return if (value >= 10000) {
                val format = decimalFormat.format(value / 10000)
                format + "w"
            } else {
                decimalFormat.format(value)
            }
        } else {
            "0.00"
        }
    }

    /**
     * 判断是否是数字
     */
    fun isNumeric(str: String): Boolean {
        val pattern = Pattern.compile("[0-9]*")
        val isNum = pattern.matcher(str)
        return isNum.matches() || isDouble(str)
    }

    /**
     * 判断字符串是否是浮点数
     */
    fun isDouble(value: String): Boolean {
        return try {
            java.lang.Double.parseDouble(value)
            value.contains(".")
        } catch (e: NumberFormatException) {
            false
        }

    }

}
