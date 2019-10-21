package hxz.www.commonbase.adapter;

import android.view.View;
import android.view.ViewGroup;

import hxz.www.commonbase.util.DisplayUtil;


public abstract class SizeAdaptiveAdapter<T> extends BaseAdapter<T> {
    private float width, height;

    private int space = DisplayUtil.dp2px(8);//item间距
    private int margin = DisplayUtil.dp2px(16) * 2;//item总边距

    public SizeAdaptiveAdapter() {
        initSize();
    }

    private void initSize() {
        width = (DisplayUtil.getScreenWidth() - getMargin() - getSpace() * (getWidthNumber() - 1)) / getWidthNumber();
        height = width / getAspectRatio();
    }

    @Override
    protected void bindData(ViewHolder holder, T data, int position) {
        View rootView = holder.getConvertView();
        if (width != 0) {
            ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) rootView.getLayoutParams();
            params.width = (int) width;
            params.height = (int) height;
            rootView.setLayoutParams(params);
        }
        bindAdapterData(holder, data, position);
    }


    //每行个数
    protected abstract float getWidthNumber();

    //宽高比
    protected abstract float getAspectRatio();

    protected abstract void bindAdapterData(ViewHolder holder, T data, int position);

    /**
     * item间距
     *
     * @return
     */
    protected int getSpace() {
        return space;
    }


    /**
     * item总边距
     * @return
     */
    protected int getMargin() {
        return margin;
    }
}
