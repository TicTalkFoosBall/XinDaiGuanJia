package hxz.www.commonbase.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;

/**
 * Created by Circle on 2018/11/1
 */
public class SoftKeyBoardListener implements ViewTreeObserver.OnGlobalLayoutListener {
    private View rootView;//activity的根视图
    int rootViewVisibleHeight;//纪录根视图的显示高度
    private OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener;


    public SoftKeyBoardListener(Activity activity, OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        //获取activity的根视图
        rootView = activity.getWindow().getDecorView();
        this.onSoftKeyBoardChangeListener = onSoftKeyBoardChangeListener;
        addOnGlobalLayoutListener();
    }


    private void addOnGlobalLayoutListener() {
        if (rootView == null || rootView.getViewTreeObserver() == null)
            return;
        destroy();
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public void destroy() {
        if (rootView != null && rootView.getViewTreeObserver() != null) {
            rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    @Override
    public void onGlobalLayout() {
        //获取当前根视图在屏幕上显示的大小
        Rect r = new Rect();
        rootView.getWindowVisibleDisplayFrame(r);
        int visibleHeight = r.height();
        if (rootViewVisibleHeight == 0) {
            rootViewVisibleHeight = visibleHeight;
//            destroy();
            return;
        }

        //根视图显示高度没有变化，可以看作软键盘显示／隐藏状态没有改变
        if (rootViewVisibleHeight == visibleHeight) {
            return;
        }

        //根视图显示高度变小超过200，可以看作软键盘显示了
        if (rootViewVisibleHeight - visibleHeight > 200) {
            if (onSoftKeyBoardChangeListener != null) {
                onSoftKeyBoardChangeListener.keyBoardShow(rootViewVisibleHeight - visibleHeight);
            }
            rootViewVisibleHeight = visibleHeight;
            return;
        }

        //根视图显示高度变大超过200，可以看作软键盘隐藏了
        if (visibleHeight - rootViewVisibleHeight > 200) {
            if (onSoftKeyBoardChangeListener != null) {
                onSoftKeyBoardChangeListener.keyBoardHide(visibleHeight - rootViewVisibleHeight);
            }
            rootViewVisibleHeight = visibleHeight;
            return;
        }
        rootViewVisibleHeight = visibleHeight;
    }

    public interface OnSoftKeyBoardChangeListener {
        void keyBoardShow(int height);

        void keyBoardHide(int height);
    }


}
