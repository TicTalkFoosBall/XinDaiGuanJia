package hxz.www.commonbase.base.mvp;

import android.os.Bundle;
import android.support.v4.util.ArraySet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 *
 * Dec:mvp  fragment
 */
public abstract class BaseMvpFragment<P extends BasePresenter<? extends IBaseView>> extends BaseFragment implements IBaseView {

    protected P mPresenter;

    private ArraySet<BasePresenter> mPresenters = new ArraySet<>(1);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        mRootView = view;
        mPresenter = getPresenter();
        initView();
        initData();
        initEvent();
        return view;
    }

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化事件监听
     */
    protected abstract void initEvent();

    /**
     * 初始化View
     */
    protected abstract void initView();


    /**
     * 初始化  Presenter  同一调用此Presenter方法,不管多个N个
     */
    protected abstract P getPresenter();


    /**
     * Presenter添加到Presenters集合里
     * 自动绑定View和管理内存释放
     */
    protected <T extends BasePresenter> void addToPresenters(T presenter) {
        presenter.attachView(this);
        mPresenters.add(presenter);
    }


    /**
     * 销毁所有任务
     */
    @Override
    public void onDestroy() {
        for (BasePresenter presenter : mPresenters) {
            presenter.detachView();
        }
        mPresenters.clear();
        super.onDestroy();
    }

}
