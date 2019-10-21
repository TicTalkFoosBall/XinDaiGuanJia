package hxz.www.commonbase.uibase.mvp;

import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * Created by Circle on 2019-06-27
 * View基类
 */
public interface BaseView {
    
    void showError(int reqCode, String msg);

    <T> LifecycleTransformer<T> bindLifecycle();
}
