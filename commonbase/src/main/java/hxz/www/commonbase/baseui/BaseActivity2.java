package hxz.www.commonbase.baseui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gyf.immersionbar.ImmersionBar;
import com.trello.rxlifecycle2.LifecycleTransformer;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import hxz.www.commonbase.R;
import hxz.www.commonbase.baseui.mvp.BaseView2;
import hxz.www.commonbase.uibase.mvp.BasePresenterImpl;
import hxz.www.commonbase.util.TUtil;
import yokeyword.fragmentation.SupportActivity;

public abstract class BaseActivity2<T extends BasePresenterImpl> extends SupportActivity implements BaseView2 {

    protected Context mContext;

    protected T mPresenter;


    protected abstract int getLayoutId();

    protected abstract void initEventAndData(Bundle savedInstanceState);

    /**
     * 是否注册eventBus
     *
     * @return
     */
    protected boolean registerEventBus() {
        return false;
    }


    /**
     * 是否开启沉浸式
     *
     * @return
     */
    protected boolean isImmersionBarEnabled() {
        return false;
    }


    /**
     * 初始化沉浸式
     */
    protected void initImmersionBar() {
        ImmersionBar.with(this).statusBarColor(R.color.statusBarColorBoy).statusBarDarkFont(true).init();
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if(savedInstanceState != null){
//            BaseApplication.getInstance().reloadApp();
//        }



        setContentView(getLayoutId());

        ButterKnife.bind(this);

        mContext = this;

        mPresenter = TUtil.getT(this, 0);
        if (mPresenter != null) {
            mPresenter.attachView(this, this);
        }

        if (isImmersionBarEnabled()) {
            try {
                initImmersionBar();
            } catch (Exception e) {
            }
        }

        initEventAndData(savedInstanceState);

        if (registerEventBus()) {
            EventBus.getDefault().register(this);
        }

    }

    @Override
    public <T> LifecycleTransformer<T> bindLifecycle() {
        return this.bindToLifecycle();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onDestroy() {

        if (registerEventBus()) {
            EventBus.getDefault().unregister(this);
        }
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
    }


}
