package hxz.www.commonbase.baseui.mvp;

import com.trello.rxlifecycle2.LifecycleTransformer;


public interface BaseView2 {
    
    void showError(int reqCode, String msg);

    <T> LifecycleTransformer<T> bindLifecycle();
}
