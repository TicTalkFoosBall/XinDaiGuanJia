package hxz.www.commonbase.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;

import hxz.www.commonbase.app.BaseApplication;


public class ViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> viewArray = new SparseArray<>();
    private Context mContext;


    /**
     * 构造ViewHolder
     *
     * @param parent 父类容器
     * @param resId  布局资源文件id
     */
    public ViewHolder(ViewGroup parent, @LayoutRes int resId) {
        super(LayoutInflater.from(parent.getContext()).inflate(resId, parent, false));
        mContext = parent.getContext();
    }

    /**
     * 构建ViewHolder
     *
     * @param view 布局View
     */
    public ViewHolder(View view) {
        super(view);
        mContext = itemView.getContext();
    }

    public Context getContext() {
        return mContext;
    }


    /**
     * 获取布局中的View
     *
     * @param viewId view的Id
     * @param <T>    View的类型
     * @return view
     */
    public <T extends View> T getView(@IdRes int viewId) {
        View view = viewArray.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            viewArray.put(viewId, view);
        }
        return (T) view;
    }


    public View getConvertView() {
        return itemView;
    }

    /****以下为辅助方法*****/

    /**
     * 设置TextView的值
     *
     * @param viewId
     * @param resId
     * @return
     */
    public ViewHolder setText(@IdRes int viewId, @StringRes int resId) {
        TextView tv = getView(viewId);
        tv.setText(resId);
        return this;
    }

    public ViewHolder setText(@IdRes int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public ViewHolder setText(int viewId, SpannableString text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public ViewHolder setImageUrl(@IdRes int viewId, String imageUrl) {
        ImageView view = getView(viewId);
        if (!TextUtils.isEmpty(imageUrl))
            Glide.with(mContext).load(imageUrl).into(view);
        return this;
    }

    public ViewHolder setImageUrl(@IdRes int viewId, File file) {
        ImageView view = getView(viewId);
        Glide.with(mContext).load(file).into(view);
        return this;
    }

    public ViewHolder setImageUrl(@IdRes int viewId, String imageUrl, int defaultImage) {
        ImageView view = getView(viewId);
        if (TextUtils.isEmpty(imageUrl))
            view.setImageResource(defaultImage);
        else
            Glide.with(mContext).load(imageUrl).apply(new RequestOptions().placeholder(defaultImage).error(defaultImage)).into(view);
        return this;
    }

    public ViewHolder setImageResource(@IdRes int viewId, int resId) {
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }

    public ViewHolder setImageBitmap(@IdRes int viewId, Bitmap bitmap) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }

    public ViewHolder setImageDrawable(@IdRes int viewId, Drawable drawable) {
        ImageView view = getView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    public ViewHolder setBackgroundColor(@IdRes int viewId, int color) {
        getView(viewId).setBackgroundColor(color);
        return this;
    }

    public ViewHolder setBackgroundRes(@IdRes int viewId, int backgroundRes) {
        getView(viewId).setBackgroundResource(backgroundRes);
        return this;
    }

    public ViewHolder setTextColor(@IdRes int viewId, int textColor) {
        TextView view = getView(viewId);
        view.setTextColor(textColor);
        return this;
    }

    public ViewHolder setTextColorRes(@IdRes int viewId, int textColorRes) {
        TextView view = getView(viewId);
        view.setTextColor(BaseApplication.getInstance().getResources().getColor(textColorRes));
        return this;
    }

    @SuppressLint("NewApi")
    public ViewHolder setAlpha(@IdRes int viewId, float value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getView(viewId).setAlpha(value);
        } else {
            // Pre-honeycomb hack to set Alpha value
            AlphaAnimation alpha = new AlphaAnimation(value, value);
            alpha.setDuration(0);
            alpha.setFillAfter(true);
            getView(viewId).startAnimation(alpha);
        }
        return this;
    }

    public ViewHolder setVisible(@IdRes int viewId, boolean visible) {
        getView(viewId).setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

    public ViewHolder setVisible(@IdRes int viewId, int visibility) {
        getView(viewId).setVisibility(visibility);
        return this;
    }

    public ViewHolder setTypeface(Typeface typeface, @IdRes int... viewIds) {
        for (@IdRes int viewId : viewIds) {
            TextView view = getView(viewId);
            view.setTypeface(typeface);
            view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        }
        return this;
    }

    public ViewHolder setTag(@IdRes int viewId, Object tag) {
        getView(viewId).setTag(tag);
        return this;
    }

    public ViewHolder setTag(@IdRes int viewId, int key, Object tag) {
        getView(viewId).setTag(key, tag);
        return this;
    }

    /**
     * 关于事件的
     */
    public ViewHolder setOnClickListener(@IdRes int viewId, View.OnClickListener listener) {
        getView(viewId).setOnClickListener(listener);
        return this;
    }

    public ViewHolder setOnTouchListener(@IdRes int viewId, View.OnTouchListener listener) {
        getView(viewId).setOnTouchListener(listener);
        return this;
    }

    public ViewHolder setOnLongClickListener(@IdRes int viewId, View.OnLongClickListener listener) {
        getView(viewId).setOnLongClickListener(listener);
        return this;
    }
}
