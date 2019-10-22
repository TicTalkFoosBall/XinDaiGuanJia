package hxz.www.commonbase.baseui.mvp;

import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * Created by Circle on 2019-06-27
 * View基类
 */
public interface BaseView2 {
    
    void showError(int reqCode, String msg);

    <T> LifecycleTransformer<T> bindLifecycle();
}
