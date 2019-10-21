package hxz.www.commonbase.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import hxz.www.commonbase.R;


/**
 * @Descripe: 从下往上弹出dialog
 **/
public class BottomUpDialog extends Dialog {
    private int layoutId;
    private View rootView;
    private BottomUpCallback callback;

    public interface BottomUpCallback {
        void onRootInflateComplete(Dialog dialog, View rootView);
    }

    /**
     * @param context
     * @param layoutId layout id
     * @param callback
     */
    public BottomUpDialog(@NonNull Context context, int layoutId, BottomUpCallback callback) {
        super(context, R.style.Dialog_BottomUp);
        this.layoutId = layoutId;
        this.callback = callback;
    }

    public BottomUpDialog(@NonNull Context context, int layoutId, int styleId, BottomUpCallback callback) {
        super(context, styleId);
        this.layoutId = layoutId;
        this.callback = callback;
    }

    public void setCallback(BottomUpCallback callback) {
        this.callback = callback;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        //设置dialog在屏幕底部
        if (window != null) {
            window.setGravity(Gravity.BOTTOM);
            window.setWindowAnimations(R.style.Anim_BottomTop);
            window.getDecorView().setPadding(0, 0, 0, 0);
            //获得window窗口的属性
            WindowManager.LayoutParams lp = window.getAttributes();
            //设置窗口宽度为充满全屏
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            //设置窗口高度为包裹内容
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            //将设置好的属性set回去
            window.setAttributes(lp);
        }
        rootView = LayoutInflater.from(getContext()).inflate(layoutId, null);
        setContentView(rootView);
        if (callback != null) {
            callback.onRootInflateComplete(this, rootView);
        }
    }
}
