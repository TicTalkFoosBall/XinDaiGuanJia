package hxz.www.commonbase.baseui.mvp;

import android.content.Context;

/**
 * Created by Circle on 2019-06-27
 * Presenter基类
 */
public interface BasePresenter2<V extends BaseView2> {
    void attachView(Context context, V view);

    void detachView();
}
