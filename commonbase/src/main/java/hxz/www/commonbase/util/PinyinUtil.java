package hxz.www.commonbase.util;

import android.text.TextUtils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * Copyright (C)
 * Author: junChenChow
 * Date: 2019/8/6 13:08
 */
public class PinyinUtil {

    public static String getPingYin(String inputString) {
        if (TextUtils.isEmpty(inputString)) {
            return "";
        }
        try {
            HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
            format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
            format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
            format.setVCharType(HanyuPinyinVCharType.WITH_V);
            char[] input = inputString.trim().toCharArray();
            if (input.length > 0) {
                StringBuilder output = new StringBuilder();
                for (char curchar : input) {
                    if (Character.toString(curchar).matches("[\\u4E00-\\u9FA5]+")) {
                        String[] temp = PinyinHelper.toHanyuPinyinStringArray(curchar, format);
                        if (temp.length > 0) {
                            output.append(temp[0]);
                        }
                    } else {
                        output.append(curchar);
                    }
                }
                return output.toString();
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }

        return "";

    }

}
