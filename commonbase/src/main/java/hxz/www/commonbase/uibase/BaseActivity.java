package hxz.www.commonbase.uibase;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;

import com.gyf.immersionbar.ImmersionBar;
import com.trello.rxlifecycle2.LifecycleTransformer;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.Field;

import butterknife.ButterKnife;
import hxz.www.commonbase.R;
import hxz.www.commonbase.uibase.mvp.BasePresenterImpl;
import hxz.www.commonbase.uibase.mvp.BaseView;
import hxz.www.commonbase.util.TUtil;
import yokeyword.fragmentation.SupportActivity;


/**
 * Created by Circle on 2019-06-27
 */
public abstract class BaseActivity<T extends BasePresenterImpl> extends SupportActivity implements BaseView {

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
        return true;
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

        registerSkin();

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


    private void registerSkin() {

        LayoutInflater layoutInflater = LayoutInflater.from(this);
        //获得Activity的布局加载器
        try {
            //Android 布局加载器 使用 mFactorySet 标记是否设置过Factory,
            //如设置过抛出一次
            //设置 mFactorySet 标签为false
            Field field = LayoutInflater.class.getDeclaredField("mFactorySet");
            field.setAccessible(true);
            field.setBoolean(layoutInflater, false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
