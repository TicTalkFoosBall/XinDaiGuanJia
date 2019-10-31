package hxz.www.commonbase.baseui.mvp;

import android.content.Context;


public interface BasePresenter2<V extends BaseView2> {
    void attachView(Context context, V view);

    void detachView();
}
