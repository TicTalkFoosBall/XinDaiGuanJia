package hxz.www.commonbase.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import hxz.www.commonbase.R;
import hxz.www.commonbase.state.MultiStateView;

/**
 * Create by Circle on 2019/7/15
 */
public class KLRefreshLayout extends SmartRefreshLayout {
    public RecyclerView recyclerView;
    private MultiStateView multiStateView;
    private boolean mMultiStateViewEnable = true;

    public KLRefreshLayout(Context context) {
        this(context, null);
    }

    public KLRefreshLayout(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public KLRefreshLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        multiStateView = (MultiStateView) View.inflate(context, R.layout.layout_multi_state, null);
        recyclerView = new RecyclerView(context);
        recyclerView.setOverScrollMode(OVER_SCROLL_NEVER);
        multiStateView.addView(recyclerView, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        addView(multiStateView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    public void setBackColor(int color){
        multiStateView.setBackgroundColor(color);
    }
    public void setBackDrawable(Drawable drawable){
        multiStateView.setBackground(drawable);
    }
    public void setLayoutManager(RecyclerView.LayoutManager layout) {
        recyclerView.setLayoutManager(layout);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        recyclerView.addItemDecoration(itemDecoration);
    }


    public void scrollToPosition(int position) {
        recyclerView.scrollToPosition(position);
    }


    public void finishLoad() {
        finishRefresh(400);
        finishLoadMore();
    }

    public void setRefreshBackgroundColor(@ColorInt int color) {
//        recyclerView.setBackgroundColor(color);
        multiStateView.setBackgroundColor(color);
    }

    public void setRecycledViewScaleY(float scaleY) {
        recyclerView.setScaleY(scaleY);
    }

    /**
     * 空界面是否可用
     *
     * @param multiStateViewEnable
     */
    public void setMultiStateViewEnable(boolean multiStateViewEnable) {
        mMultiStateViewEnable = multiStateViewEnable;
        if (!multiStateViewEnable) {
            multiStateView.setViewState(MultiStateView.VIEW_STATE_CONTENT);
        }
    }

    public void setMultiStateView(@MultiStateView.ViewState int state) {
        if (mMultiStateViewEnable) {
            multiStateView.setViewState(state);
        }
    }


    public void showNetError(View.OnClickListener clickListener) {
        multiStateView.showNetError(clickListener);
    }

    public void showLocationError(View.OnClickListener clickListener) {
        multiStateView.showLocationError(clickListener);
    }


    /**
     * 重试
     *
     * @param listener
     */
    public void setOnRetryClick(View.OnClickListener listener) {
        multiStateView.getView(MultiStateView.VIEW_STATE_ERROR).findViewById(R.id.tv_retry).setOnClickListener(listener);
    }

    /**
     * 重试
     *
     * @param listener
     */
    public void setOnRetryClick(String retyrText, View.OnClickListener listener) {
        ((TextView) multiStateView.getView(MultiStateView.VIEW_STATE_ERROR).findViewById(R.id.tv_retry)).setText(retyrText);
        multiStateView.getView(MultiStateView.VIEW_STATE_ERROR).findViewById(R.id.tv_retry).setOnClickListener(listener);
    }

    /**
     * 设置ErrorView 显示文案
     *
     * @param text
     */
    public void setErrorText(String text) {
        ((TextView) multiStateView.getView(MultiStateView.VIEW_STATE_ERROR).findViewById(R.id.tv_error_message)).setText(text);
    }

    /**
     * 设置ErrorView 显示文案
     *
     * @param resid
     */
    public void setErrorText(@StringRes int resid) {
        ((TextView) multiStateView.getView(MultiStateView.VIEW_STATE_ERROR).findViewById(R.id.tv_error_message)).setText(resid);
    }

    /**
     * 设置ErrorView 显示ICON
     *
     * @param resId
     */
    public void setErrorIcon(@DrawableRes int resId) {
        ((ImageView) multiStateView.getView(MultiStateView.VIEW_STATE_ERROR).findViewById(R.id.iv_error)).setImageResource(resId);
    }


    /**
     * 设置EmptyView 显示文案
     *
     * @param text
     */
    public void setEmptyText(String text) {
        ((TextView) multiStateView.getView(MultiStateView.VIEW_STATE_EMPTY).findViewById(R.id.tv_empty_message)).setText(text);
    }

    /**
     * 设置ErrorView 显示文案
     *
     * @param resid
     */
    public void setEmptyText(@StringRes int resid) {
        ((TextView) multiStateView.getView(MultiStateView.VIEW_STATE_EMPTY).findViewById(R.id.tv_empty_message)).setText(resid);
    }

    /**
     * 设置ErrorView 显示ICON
     *
     * @param resId
     */
    public void setEmptyIcon(@DrawableRes int resId) {
        ((ImageView) multiStateView.getView(MultiStateView.VIEW_STATE_EMPTY).findViewById(R.id.iv_empty)).setImageResource(resId);
    }

    /**
     * 设置重试按钮text
     */
    public void setRetryClickContent(String text) {
        View view = multiStateView.getView(MultiStateView.VIEW_STATE_ERROR);
        if (view != null) {
            TextView tvRetryText = view.findViewById(R.id.tv_retry);
            tvRetryText.setText(text);
        }
    }

    /**
     * 设置重试按钮text
     */
    public void setRetryClickContent(@StringRes int retryMsgResId) {
        View view = multiStateView.getView(MultiStateView.VIEW_STATE_ERROR);
        if (view != null) {
            TextView tvRetryText = view.findViewById(R.id.tv_retry);
            tvRetryText.setText(retryMsgResId);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            recyclerView.removeAllViews();
            removeAllViews();
        }catch (Exception e){

        }
    }
}
