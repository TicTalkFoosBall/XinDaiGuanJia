package hxz.www.commonbase.uibase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gyf.immersionbar.ImmersionBar;
import com.trello.rxlifecycle2.LifecycleTransformer;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import hxz.www.commonbase.R;
import hxz.www.commonbase.uibase.mvp.BasePresenterImpl;
import hxz.www.commonbase.uibase.mvp.BaseView;
import hxz.www.commonbase.util.TUtil;
import hxz.www.commonbase.util.fragment.FragmentHelper;
import hxz.www.commonbase.view.dialog.LoadingDialog;
import yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import yokeyword.fragmentation.anim.FragmentAnimator;
import yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Created by Circle on 2019-06-27
 */
public abstract class BaseFragment<T extends BasePresenterImpl> extends SwipeBackFragment implements BaseView {

    private String TAG = getClass().getSimpleName();

    protected View rootView;

    protected T mPresenter;

    protected Object[] mParams;

    protected abstract int getLayoutId();

    protected abstract void initEventAndData(Bundle savedInstanceState);

    private LoadingDialog loadingDialog;

//    private ImageWatcherHelper watcherHelper;

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
     * 是否是透明状态栏
     *
     * @return
     */
    protected boolean isTransparentStatusBar() {
        return false;
    }

    /**
     * 初始化沉浸式 如果需要重新该方法 则实现的方法必须在super.initImmersionBar()之前
     */
    protected void initImmersionBar() {
        updateSkin();
    }

    /**
     * 是否可侧滑
     *
     * @return
     */
    public boolean getSwipeBackEnable() {
        return true;
    }

    public void initParams(Object[] params) {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        if (rootView == null) {
        rootView = inflater.inflate(getLayoutId(), container, false);
//        } else {
//            ViewGroup viewGroup = (ViewGroup) rootView.getParent();
//            if (viewGroup != null) {
//                viewGroup.removeView(rootView);
//            }
//        }
        return attachToSwipeBack(rootView);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        mPresenter = TUtil.getT(this, 0);
        if (mPresenter != null) {
            mPresenter.attachView(getContext(), this);
        }

        //获取参数
        Bundle bundle = getArguments();
        if (bundle != null) {
            mParams = (Object[]) bundle.getSerializable(FragmentHelper.PARAMS);
        }

        initParams(mParams);

        setSwipeBackEnable(getSwipeBackEnable());

        if (getTitleBar() != 0) {
            ImmersionBar.setTitleBarMarginTop(this, rootView.findViewById(getTitleBar()));
        }


        if (registerEventBus()) {
            EventBus.getDefault().register(this);
        }

        initEventAndData(savedInstanceState);

    }

    protected void showLoading() {
        dismissDialog();
        loadingDialog = LoadingDialog.getInstance();
        loadingDialog.show(getContext());
    }

    protected void showUploading() {
        dismissDialog();
        loadingDialog = LoadingDialog.getInstance();
        loadingDialog.showUpload(getContext());
    }

    protected void showWating() {
        if (isFinishing()) return;
        dismissDialog();
        loadingDialog = LoadingDialog.getInstance();
        loadingDialog.showWate(getContext());
    }

    protected void dismissDialog() {

        if (!_mActivity.isFinishing()) {
            if (loadingDialog != null) {
                loadingDialog.dismiss();
                loadingDialog = null;
            }
        }
    }

    @Override
    public <T> LifecycleTransformer<T> bindLifecycle() {
        return this.bindToLifecycle();
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }


    /**
     * true  就是已销毁
     *
     * @return
     */
    public boolean isFinishing() {
        return getActivity() == null || getActivity().isFinishing();
    }

    /**
     * @return 0 代表不设置
     */
    protected int getTitleBar() {
        return R.id.toolbar;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (registerEventBus()) {
            EventBus.getDefault().unregister(this);
        }
        mParams = null;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            dismissDialog();
        }
    }

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        if (isImmersionBarEnabled()) {
            try {
                initImmersionBar();
            } catch (Exception e) {
            }
        }
    }

    /**
     * 换肤 更换状态栏
     */
    public void updateSkin() {
        if (isTransparentStatusBar()) {
            ImmersionBar.with(this).transparentStatusBar().keyboardEnable(false).init();
            return;
        }

        if (isImmersionBarEnabled()) {
            ImmersionBar.with(this).statusBarColor(R.color.statusBarColor).statusBarDarkFont(true).keyboardEnable(false).init();
        }
    }

    public View.OnClickListener navBackListener() {
        return v -> pop();
    }

    public Object getParameter(int index) {
        if (mParams != null && mParams.length > 0 && index < mParams.length) {
            return mParams[index];
        }
        return null;
    }



    @Override
    public boolean onBackPressedSupport() {

        return super.onBackPressedSupport();
    }
}
