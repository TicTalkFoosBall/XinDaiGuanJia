package hxz.www.commonbase.uibase.mvp;

import android.content.Context;

/**
 * Created by Circle on 2019-06-27
 * Presenter基类
 */
public interface BasePresenter<V extends BaseView> {
    void attachView(Context context, V view);

    void detachView();
}
