package hxz.www.commonbase.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.ArraySet;

import com.gyf.immersionbar.ImmersionBar;


/**
 *
 *
 * Dec:  mvp Activity 基类
 */
public abstract class BaseMvpActivity<P extends BasePresenter<? extends IBaseView>> extends BaseActivity implements IBaseView {


    protected P mPresenter;

    private ImmersionBar mImmersionBar;
    /**
     * 存放N个Presenter
     */
    private ArraySet<BasePresenter> mPresenters = new ArraySet<>(1);

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {
        initStatusBar();
        mPresenter = getPresenter();
        addToPresenters(mPresenter);
        initView();
        initEvent();
        initData();
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
    protected void onDestroy() {
        for (BasePresenter presenter : mPresenters) {
            presenter.detachView();
        }
        mPresenters.clear();
        super.onDestroy();
    }


    public void initStatusBar() {
        mImmersionBar = ImmersionBar.with(this);//初始化
        mImmersionBar.init();
    }
}
