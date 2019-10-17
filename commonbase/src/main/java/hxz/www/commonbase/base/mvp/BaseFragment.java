package hxz.www.commonbase.base.mvp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hxz.www.commonbase.util.Logger;

/**
 *
 * Email:15901419691@163.com
 * Dec:fragment 基类
 */
public abstract class BaseFragment extends Fragment {

    public Activity mActivity;

    public View mRootView;

    /**
     * 在Fragment基类里设置一个Activity mActivity的全局变量，
     * 在onAttach(Activity activity)里赋值，使用mActivity代替getActivity()，
     * 保证Fragment即使在onDetach后，仍持有Activity的引用
     * （有引起内存泄露的风险，但是异步任务没停止的情况下，本身就可能已内存泄漏，相比Crash，这种做法“安全”些）
     */

    @Override
    public void onAttach(Context context) {
        Logger.w("当前生命周期--->" + getClass().getSimpleName() + ":onAttach");
        super.onAttach(context);
        this.mActivity = (Activity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Logger.w("当前生命周期--->" + getClass().getSimpleName() + ":onCreateView");
        View view = inflater.inflate(getLayoutId(), container, false);
        mRootView = view;
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Logger.w("当前生命周期--->" + getClass().getSimpleName() + ":onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Logger.w("当前生命周期--->" + getClass().getSimpleName() + ":onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Logger.w("当前生命周期--->" + getClass().getSimpleName() + ":onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Logger.w("当前生命周期--->" + getClass().getSimpleName() + ":onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Logger.w("当前生命周期--->" + getClass().getSimpleName() + ":onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Logger.w("当前生命周期--->" + getClass().getSimpleName() + ":onDestroyView");
        super.onDestroyView();

    }

    @Override
    public void onDestroy() {
        Logger.w("当前生命周期--->" + getClass().getSimpleName() + ":onDestroy");
        super.onDestroy();
    }


    //获取布局文件
    @LayoutRes
    public abstract int getLayoutId();



}
