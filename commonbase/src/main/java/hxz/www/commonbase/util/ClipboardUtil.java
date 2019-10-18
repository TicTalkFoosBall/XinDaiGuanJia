package hxz.www.commonbase.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

import hxz.www.commonbase.app.BaseApplication;

/**
 * 剪贴板相关工具类
 * Created by Circle on 2019-07-03
 */
public class ClipboardUtil {
    private ClipboardUtil() {
    }

    /**
     * 复制文本到剪贴板
     *
     * @param text 文本
     */
    public static void copyText(final CharSequence text) {
        ClipboardManager clipboard = (ClipboardManager) BaseApplication.getInstance().getSystemService(Context.CLIPBOARD_SERVICE);
        clipboard.setPrimaryClip(ClipData.newPlainText("text", text));
    }

    /**
     * 获取剪贴板的文本
     *
     * @return 剪贴板的文本
     */
    public static CharSequence getText() {
        ClipboardManager clipboard = (ClipboardManager) BaseApplication.getInstance().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = clipboard.getPrimaryClip();
        if (clip != null && clip.getItemCount() > 0) {
            return clip.getItemAt(0).coerceToText(BaseApplication.getInstance());
        }
        return "";
    }


}
