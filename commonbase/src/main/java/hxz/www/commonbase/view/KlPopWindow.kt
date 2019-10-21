package hxz.www.commonbase.view

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.BitmapDrawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import hxz.www.commonbase.R
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.BaseAdapter.OnItemClickListener
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.model.PopModel
import hxz.www.commonbase.util.DisplayUtil


/**
@Descripe:  自定义popwindow
 *                       demo for java:
 *                       KlPopwindow
 *                       .build(getContext(), PopModelStore.getRedModels())
 *                       .setOnItemClick((index, model，popupwindow) ->
 *                       {
 *                       return null;
 *                       })
 *                       .show(updateSkin1);
 **/

class KlPopWindow(private var context: Context, list: MutableList<PopModel>, itemClickListener: OnItemClickListener<PopModel>) : PopupWindow() {

    private var recyclerView: RecyclerView? = null
    private val mAdapter = PopWindowListAdapter()

    init {
        createPop(context)
        setRecyclerView(list, itemClickListener)
    }

    companion object {
        @JvmStatic
        fun build(context: Context, list: MutableList<PopModel>, itemClickListener: OnItemClickListener<PopModel>): KlPopWindow = KlPopWindow(context, list, itemClickListener)
    }

    /**
     * 其他通用屬性暫時不用,默认布局还是
     */
    private fun createPop(context: Context) {
        contentView = LayoutInflater.from(context).inflate(R.layout.layout_popwindow_list, null)
        recyclerView = contentView.findViewById(R.id.recyclerView)
        this.width = ViewGroup.LayoutParams.WRAP_CONTENT
        this.height = ViewGroup.LayoutParams.WRAP_CONTENT
        this.isOutsideTouchable = true
        this.isFocusable = true
        this.setBackgroundDrawable(BitmapDrawable())
    }

    private fun setRecyclerView(list: MutableList<PopModel>, itemClickListener: OnItemClickListener<PopModel>) {
        recyclerView?.layoutManager = LinearLayoutManager(context)
        mAdapter.setOnItemClick(itemClickListener)
        mAdapter.data = list
        recyclerView?.adapter = mAdapter
    }


    fun show(anchor: View) {
        showAsDropDown(anchor, DisplayUtil.dp2px(10f), 0)
    }

    //只用于消息列表筛选红点显示
    fun showUnreadStat(friendUnreadCount: Int, groupUnreadCount: Int) {
        mAdapter.data[1].showUnReadStat = friendUnreadCount > 0
        mAdapter.data[2].showUnReadStat = groupUnreadCount > 0
        mAdapter.notifyDataSetChanged()
    }
}

class PopWindowListAdapter : BaseAdapter<PopModel>() {

    private var selectedPosition = 0
    private var itemClickListener: OnItemClickListener<PopModel>? = null

    fun setOnItemClick(itemClickListener: OnItemClickListener<PopModel>) {
        this.itemClickListener = itemClickListener;
    }

    override fun getItemLayoutResId(data: PopModel, position: Int): Int {
        return R.layout.adapter_popwindow
    }

    override fun bindData(holder: ViewHolder, data: PopModel, position: Int) {
        holder.setImageResource(R.id.iv_pop, data.imgRes)
        holder.setText(R.id.tv_name, data.text)
        holder.setVisible(R.id.view_line, if (position == dataCount - 1) View.GONE else View.VISIBLE)
        val llItem: LinearLayout = holder.getView(R.id.ll_item)

        holder.itemView.setOnClickListener {
            selectedPosition = position
            notifyDataSetChanged()
            itemClickListener?.onItemClick(holder.itemView, dataList[position], position)
        }
        val context = holder.context

        val states = arrayOf(
                intArrayOf(-android.R.attr.state_selected), // unchecked
                intArrayOf(android.R.attr.state_selected)  // checked
        )
        holder.getView<TextView>(R.id.tv_name).setTextColor(ColorStateList(states,
                intArrayOf(ContextCompat.getColor(context, R.color.white), ContextCompat.getColor(context, R.color.gray_66686E))))

        when (position) {
            0 -> llItem.background = ContextCompat.getDrawable(context, R.drawable.sc_pop_item_selected_top)
            dataCount - 1 -> llItem.background = ContextCompat.getDrawable(context, R.drawable.sc_pop_item_selected_bottom)
            else -> llItem.background = ContextCompat.getDrawable(context, R.drawable.sc_pop_item_selected_center)
        }

        holder.getView<TextView>(R.id.tv_name).isSelected = position == selectedPosition
        holder.getView<MsgView>(R.id.msg_tip).visibility = if (data.showUnReadStat) View.VISIBLE else View.GONE

    }


}