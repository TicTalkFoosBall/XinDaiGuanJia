package hxz.www.commonbase.baseui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.trello.rxlifecycle2.LifecycleTransformer;

import org.greenrobot.eventbus.EventBus;

import hxz.www.commonbase.baseui.mvp.BaseView2;
import hxz.www.commonbase.uibase.mvp.BasePresenterImpl;
import hxz.www.commonbase.util.TUtil;
import hxz.www.commonbase.util.fragment.FragmentHelper;
import yokeyword.fragmentation.SupportDialogFragment;

public abstract class BaseDialogFragment<T extends BasePresenterImpl> extends SupportDialogFragment implements BaseView2 {

    protected View rootView;

    protected T mPresenter;

    protected Object[] mParameters;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutId(), container, false);
            mPresenter = TUtil.getT(this, 0);
            if (mPresenter != null) {
                mPresenter.attachView(getContext(), this);
            }
        } else {
            ViewGroup viewGroup = (ViewGroup) rootView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(rootView);
            }
        }

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setWindow(getDialog().getWindow());

        //获取参数
        Bundle bundle = getArguments();
        if (bundle != null) {
            mParameters = (Object[]) bundle.getSerializable(FragmentHelper.PARAMS);
        }

        initEventAndData(savedInstanceState);
        if (registerEventBus())
            EventBus.getDefault().register(this);
    }

    @Override
    public <T> LifecycleTransformer<T> bindLifecycle() {
        return this.bindToLifecycle();
    }


    protected void setWindow(Window window) {
        window.getDecorView().setPadding(0, 0, 0, 0);
//        getDialog().setCanceledOnTouchOutside(true);
//        window.setBackgroundDrawableResource(android.R.color.transparent);
//        WindowManager.LayoutParams wlp = window.getAttributes();
//        wlp.gravity = Gravity.BOTTOM;
//        wlp.dimAmount = 0;
//        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
//        wlp.height = getResources().getDimensionPixelSize(R.dimen.pk_dialog_fragment_height);
//        window.setAttributes(wlp);
//        window.setWindowAnimations(R.style.AnimBottom);
    }

    /**
     * true  就是已销毁
     *
     * @return
     */
    public boolean isFinishing() {
        return getActivity() == null || getActivity().isFinishing();
    }


    @Override
    public void show(FragmentManager manager, String tag) {
        FragmentTransaction transaction = manager.beginTransaction();
        if (isAdded()) {
            transaction.remove(this).commit();
        }
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.add(this, tag);
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void dismiss() {
        dismissAllowingStateLoss();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (registerEventBus()) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        mParameters = null;
    }
}
