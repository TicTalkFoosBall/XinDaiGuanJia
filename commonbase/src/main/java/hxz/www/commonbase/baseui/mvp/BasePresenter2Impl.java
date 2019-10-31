package hxz.www.commonbase.baseui.mvp;

import android.content.Context;


public abstract class BasePresenter2Impl<V extends BaseView2> implements BasePresenter2<V> {
    protected Context mContext;
    protected V mView;

    @Override
    public void attachView(Context context, V view) {
        mContext = context;
        mView = view;
    }

    @Override
    public void detachView() {
//        mView = null;
    }
}
