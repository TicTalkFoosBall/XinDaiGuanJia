package com.longer.creditManager.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import com.longer.creditManager.R;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import hxz.www.commonbase.adapter.BaseAdapter;
import hxz.www.commonbase.baseui.BaseFragment2;
import hxz.www.commonbase.state.MultiStateView;
import hxz.www.commonbase.uibase.mvp.BasePresenterImpl;
import hxz.www.commonbase.util.ListUtil;
import hxz.www.commonbase.util.log.LogShow;
import hxz.www.commonbase.view.KLRefreshLayout;

/**
 * Created by Circle on 2019-06-27
 */
public abstract class BaseListFragment<T extends BasePresenterImpl, A extends BaseAdapter> extends BaseFragment2<T> {

    @Nullable
    @BindView(R.id.refreshLayout)
    public KLRefreshLayout refreshLayout;

    protected A mAdapter;

    protected int mPage = 0;

    protected abstract A bindAdapter();

    protected abstract void initRefreshLayout(KLRefreshLayout refreshLayout);

    protected abstract void initData();

    protected abstract void loadData(int page);

    protected boolean isCanLoadMore() {
        return true;
    }

    protected boolean isCanRefresh() {
        return true;
    }

    public void setEnableRefresh(boolean anable) {
        refreshLayout.setEnableRefresh(anable);
    }

    public void scrollToPosition(int position) {
        refreshLayout.scrollToPosition(position);
    }

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();

    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        refreshLayout=rootView.findViewById(R.id.refreshLayout);
        initRefreshLayout(refreshLayout);
        refreshLayout.setAdapter(mAdapter);
        refreshLayout.setOnRetryClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPage = 0;
                refresh(false);
            }
        });

        if (isCanRefresh()) {
            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                    LogShow.i("refreshAA", refreshLayout.getState());
                    refresh(true);
                }
            });
        } else {
            refreshLayout.setMultiStateView(MultiStateView.VIEW_STATE_CONTENT);
            refreshLayout.setEnableRefresh(false);
        }

        if (isCanLoadMore()) {
            refreshLayout.setEnableLoadMore(false);
            refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
                @Override
                public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                    loadData(mPage);
                }
            });
        } else {
            refreshLayout.setEnableLoadMore(false);
        }
        initData();
    }

    protected void refresh() {
        refresh(false);
    }


    protected void refresh(boolean isPostRefresh) {
        mPage = 0;
        if (!isPostRefresh)
            refreshLayout.setMultiStateView(MultiStateView.VIEW_STATE_LOADING);
        loadData(mPage);
    }

    public void updateData(List list) {
        if (refreshLayout == null) {
            return;
        }
        if (mPage == 0) {
            mAdapter.setData(list);
        } else {
            mAdapter.addAll(list);
        }
        refreshLayout.finishLoad();
        if (isCanLoadMore()) {
            if (ListUtil.getSize(list) <= 5) {
                refreshLayout.setEnableLoadMore(false);
            } else {
                mPage++;
                refreshLayout.setEnableLoadMore(true);
            }
        }
        LogShow.i("BaseListFragment  updateData",mPage,mAdapter.getData().size());
        if (mAdapter.getDataCount() == 0) {
            refreshLayout.setMultiStateView(MultiStateView.VIEW_STATE_EMPTY);
        } else {
            refreshLayout.setMultiStateView(MultiStateView.VIEW_STATE_CONTENT);
        }
    }

    @Override
    public void showError(int reqCode, String msg) {
        refreshLayout.finishLoad();
    }

    public void showErrorView() {
        showErrorView(0, 0);
    }

    public void showErrorView(int errorMsg) {
        showErrorView(0, errorMsg);
    }

    public void showErrorView(int iconResId, int errorMsg) {
        refreshLayout.setMultiStateView(MultiStateView.VIEW_STATE_ERROR);
        if (iconResId != 0)
            refreshLayout.setErrorIcon(iconResId);
        if (errorMsg != 0)
            refreshLayout.setErrorText(errorMsg);
    }

    public void showEmptyView() {
        showEmptyView(0, 0);
    }

    public void showEmptyView(int emptyMsg) {
        showEmptyView(0, emptyMsg);
    }

    public void showEmptyView(int iconResId, int emptyMsg) {
        refreshLayout.setMultiStateView(MultiStateView.VIEW_STATE_EMPTY);
        if (iconResId != 0)
            refreshLayout.setEmptyIcon(iconResId);
        if (emptyMsg != 0)
            refreshLayout.setErrorText(emptyMsg);
    }

    public void showErrorView(int iconResId, int errorMsgResId, int retryMsgResId) {
        if (refreshLayout != null) {
            showErrorView(iconResId, errorMsgResId);
            refreshLayout.setRetryClickContent(retryMsgResId);
        }
    }

    public void showErrorView(int iconResId, String errorMsg) {
        if (refreshLayout != null) {
            refreshLayout.setMultiStateView(MultiStateView.VIEW_STATE_ERROR);
            if (iconResId != 0)
                refreshLayout.setErrorIcon(iconResId);
            if (!TextUtils.isEmpty(errorMsg))
                refreshLayout.setErrorText(errorMsg);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            if(mAdapter != null){
                mAdapter.clear();
            }
        }catch (Exception e){

        }

    }
}
