package hxz.www.commonbase.adapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hxz.www.commonbase.R;


public abstract class BaseAdapter<T> extends RecyclerView.Adapter<ViewHolder> {


    protected List<T> dataList = new ArrayList<T>();

    /**
     * 获取指定位置的数据
     *
     * @param position
     * @return
     */
    public T getItem(int position) {
        return dataList.get(position);
    }

    /**
     * 获取数据集合
     *
     * @return
     */
    public List<T> getData() {
        return dataList;
    }

    /**
     * 设置全新的数据集合，如果传入null，则清空数据列表（会清空以前的集合数据）
     *
     * @param datas
     */
    public void setData(List<T> datas) {
        dataList.clear();
        if (datas != null && !datas.isEmpty()) {
            dataList.addAll(datas);
        }
        notifyDataSetChanged();
    }

    /**
     * 添加数据条目
     *
     * @param data
     */
    public void add(T data) {
        dataList.add(data);
        notifyItemInserted(getDataCount() + getHeaderCount());
    }

    /**
     * 在指定位置添加数据条目
     *
     * @param position
     * @param data
     */
    public void add(int position, T data) {
        dataList.add(position, data);
//        notifyDataSetChanged();
        notifyItemInserted(position + getHeaderCount());
    }

    /**
     * 添加数据条目集合
     *
     * @param datas
     */
    public void addAll(List<T> datas) {
        if (datas == null || datas.size() == 0) return;
        dataList.addAll(datas);
        notifyItemRangeInserted(getDataCount() + getHeaderCount() - datas.size(), datas.size());
//        notifyDataSetChanged();
    }

    /**
     * 在指定位置添加数据条目集合
     *
     * @param position
     * @param datas
     */
    public void addAll(int position, List<T> datas) {
        dataList.addAll(position, datas);
//        notifyItemRangeChanged(position, datas.size()-1);
//        notifyDataSetChanged();
        notifyItemRangeInserted(position + getHeaderCount(), datas.size());
    }

    /**
     * 删除指定索引数据条目
     *
     * @param position
     */
    public void remove(int position) {
        if (position >= 0 && position < dataList.size()) {
            dataList.remove(position);
            notifyItemRemoved(position + getHeaderCount());
            notifyItemRangeChanged(position + getHeaderCount(), getDataCount() + getHeaderCount() - position);
        }
    }


    /**
     * 删除指定数据条目
     *
     * @param data
     */
    public void remove(T data) {
        remove(dataList.indexOf(data));
    }


    /**
     * 替换指定索引的数据条目
     *
     * @param position
     * @param newData
     */
    public void replace(int position, T newData) {
        dataList.set(position, newData);
        notifyItemChanged(position);
    }

    /**
     * 替换指定数据条目
     *
     * @param oldData
     * @param newData
     */
    public void replace(T oldData, T newData) {
        replace(dataList.indexOf(oldData), newData);
    }

    /**
     * 交换两个数据条目的位置
     *
     * @param fromPosition
     * @param toPosition
     */
    public void move(int fromPosition, int toPosition) {
        Collections.swap(dataList, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    public int getDataCount() {
        return dataList.size();
    }

    /**
     * 清空
     */
    public void clear() {
        dataList.clear();
        notifyDataSetChanged();
    }


    // 用来存放底部和头部View的集合  比Map要高效一些
    private SparseArray<View> mHeaderViews = new SparseArray<>();
    private SparseArray<View> mFooterViews = new SparseArray<>();

    private static int TYPE_HEADER = 0x100;
    private static int TYPE_FOOTER = 0x200;

    private OnItemTouchListener onItemTouchListener;
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;

    protected abstract int getItemLayoutResId(T data, int position);

    protected abstract void bindData(ViewHolder holder, T data, int position);


    @Override
    public int getItemViewType(int position) {
        if (isHeaderPosition(position)) {
            return mHeaderViews.keyAt(position);
        }

        if (isFooterPosition(position)) {
            position = position - getHeaderCount() - getDataCount();
            return mFooterViews.keyAt(position);
        }
        position = position - getHeaderCount();
        return getItemLayoutResId(getItem(position), position);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (isHeaderViewType(viewType)) {
            return new ViewHolder(mHeaderViews.get(viewType));
        }

        if (isFooterViewType(viewType)) {
            return new ViewHolder(mFooterViews.get(viewType));
        }

        ViewHolder holder = new ViewHolder(parent, viewType);

        //给所有列表增加点击效果。
        if (setSelectableItemBackground()) {
            TypedValue typedValue = new TypedValue();
            parent.getContext().getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
            holder.getConvertView().setBackgroundResource(typedValue.resourceId);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (isFooterPosition(position) || isHeaderPosition(position)) return;
        final int finalPosition = position - getHeaderCount();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    try {
                        onItemClickListener.onItemClick(holder.itemView, dataList.get(finalPosition), finalPosition);
                    } catch (Exception e) {

                    }
                }
            }
        });
        if (onItemTouchListener != null) {
            holder.itemView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    try {
                        onItemTouchListener.onItemTouch(v, dataList.get(finalPosition), event);
                    } catch (Exception e) {

                    }
                    return false;
                }
            });
        }

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onItemLongClickListener != null) {
                    try {
                        return onItemLongClickListener.onItemLongClick(holder.itemView, dataList.get(finalPosition));
                    } catch (Exception e) {

                    }
                }
                return false;
            }
        });
        bindData(holder, getItem(finalPosition), finalPosition);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {   // 布局是GridLayoutManager所管理
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) manager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    // 如果是Header、Footer的对象则占据spanCount的位置，否则就只占用1个位置
                    return (isHeaderPosition(position) || isFooterPosition(position)) ? gridLayoutManager.getSpanCount() : 1;
                }
            });
        }
    }

    @Override
    public void onViewAttachedToWindow(ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        int position = holder.getLayoutPosition();
        if (isFooterPosition(position) || isHeaderPosition(position)) {
            ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
            if (lp != null && lp instanceof StaggeredGridLayoutManager.LayoutParams) {
                StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
                p.setFullSpan(true);
            }
        }
    }

    @Override
    public int getItemCount() {
        return getDataCount() + getHeaderCount() + getFooterCount();
    }


    public int getHeaderCount() {
        return mHeaderViews.size();
    }

    public int getFooterCount() {
        return mFooterViews.size();
    }


    private boolean isHeaderPosition(int position) {
        return position < getHeaderCount();
    }

    private boolean isFooterPosition(int position) {
        return position >= (getHeaderCount() + getDataCount());
    }


    private boolean isFooterViewType(int viewType) {
        int position = mFooterViews.indexOfKey(viewType);
        return position >= 0;
    }

    private boolean isHeaderViewType(int viewType) {
        int position = mHeaderViews.indexOfKey(viewType);
        return position >= 0;
    }


    public void addHeaderView(View view) {
        int position = mHeaderViews.indexOfValue(view);
        if (position < 0) {
            mHeaderViews.put(TYPE_HEADER++, view);
        }
        notifyDataSetChanged();
    }

    public void addFooterView(View view) {
        int position = mFooterViews.indexOfValue(view);
        if (position < 0) {
            mFooterViews.put(TYPE_FOOTER++, view);
        }
        notifyDataSetChanged();
    }

    public void removeHeaderView(View view) {
        int index = mHeaderViews.indexOfValue(view);
        if (index < 0) return;
        mHeaderViews.removeAt(index);
        notifyDataSetChanged();
    }

    public boolean isAddHeaderView(View view) {
        return mHeaderViews.indexOfValue(view) >= 0;
    }

    public void removeFooterView(View view) {
        int index = mFooterViews.indexOfValue(view);
        if (index < 0) return;
        mFooterViews.removeAt(index);
        notifyDataSetChanged();
    }


    /**
     * 是否有点击效果
     *
     * @return
     */
    protected boolean setSelectableItemBackground() {
        return false;
    }

    public BaseAdapter setOnItemTouchListener(OnItemTouchListener<T> onItemTouchListener) {
        this.onItemTouchListener = onItemTouchListener;
        return this;
    }

    public BaseAdapter setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        return this;
    }

    public BaseAdapter setOnItemLongClickListener(OnItemLongClickListener<T> onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
        return this;
    }

    public interface OnItemClickListener<T> {
        void onItemClick(View view, T data, int position);
    }

    public interface OnItemLongClickListener<T> {
        boolean onItemLongClick(View view, T data);
    }

    public interface OnItemTouchListener<T> {
        boolean onItemTouch(View view, T data, MotionEvent event);
    }


}