package hxz.www.commonbase.uibase.mvp;

import android.content.Context;

/**
 * Created by Circle on 2019-06-27
 */
public abstract class BasePresenterImpl<V extends BaseView> implements BasePresenter<V> {
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
