package hxz.www.commonbase.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import hxz.www.commonbase.app.BaseApplication;

public class InputMethodUtil {
    /**
     * 打卡软键盘
     *
     * @param view
     */
    public static void openKeybord(View view) {
        InputMethodManager imm = (InputMethodManager) BaseApplication.getInstance().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.RESULT_SHOWN);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    /**
     * 关闭软键盘
     *
     * @param view
     */
    public static void closeKeybord(View view) {
        InputMethodManager imm = (InputMethodManager) BaseApplication.getInstance().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }
}
