package com.xingxiu.frame.view.dialog

import android.content.Context
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
import hxz.www.commonbase.R
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.model.PopModel
import hxz.www.commonbase.util.FastClickUtil
import hxz.www.commonbase.view.dialog.BottomUpDialog
import kotlinx.android.synthetic.main.dialog_bottom_recyclerview.*



class BottomRecyclerViewDialog constructor(context: Context,
                                           list: MutableList<PopModel>
) : BottomUpDialog(context, R.layout.dialog_bottom_recyclerview, null) {

    private var title: String = ""
    private var defaultPosition = -1
    private var enableSelectedEffect = false
    private var contentList: MutableList<PopModel> = list
    private var listener: OnBottomRecyclerViewListener? = null

    fun title(title: String): BottomRecyclerViewDialog {
        this.title = title
        return this
    }

    fun listener(listener: OnBottomRecyclerViewListener?): BottomRecyclerViewDialog {
        this.listener = listener
        return this
    }

    fun defaultPosition(position: Int): BottomRecyclerViewDialog {
        defaultPosition = position
        return this
    }

    fun enableSelectedEffect(): BottomRecyclerViewDialog {
        enableSelectedEffect = true
        return this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter = BottomRecyclerViewAdapter()
        tvTitle?.text = title
        ryContent?.layoutManager = LinearLayoutManager(context)
        ryContent?.adapter = adapter
        adapter.data = contentList
        if (defaultPosition > -1 && enableSelectedEffect) {
            adapter.updateSelectedPosition(defaultPosition)
        }
        adapter.setOnItemClickListener { view, data, position ->
            if (!FastClickUtil.isFastClick()) {
                if (enableSelectedEffect)
                    adapter.updateSelectedPosition(position)
                listener?.onContentClickAction(position, data, this@BottomRecyclerViewDialog)
            }
        }
        tvCancel.setOnClickListener {
            dismiss()
        }
    }
}

interface OnBottomRecyclerViewListener {
    fun onContentClickAction(position: Int, data: PopModel, dialog: BottomRecyclerViewDialog)
}

class BottomRecyclerViewAdapter : BaseAdapter<PopModel>() {
    private var selectedPosition = -1

    fun updateSelectedPosition(position: Int) {
        selectedPosition = position
        notifyDataSetChanged()
    }

    override fun getItemLayoutResId(data: PopModel?, position: Int) = R.layout.adapter_bottom_recyclerview

    override fun bindData(holder: ViewHolder, data: PopModel, position: Int) {
        holder.setText(R.id.tvContent, data.text)
        holder.getView<TextView>(R.id.tvContent).setTextColor(ContextCompat.getColorStateList(holder.context, R.color.sc_bottom_recycler_item_text_color))
        holder.getView<TextView>(R.id.tvContent).isSelected = selectedPosition == position

        holder.getView<TextView>(R.id.tvContent).background = ContextCompat.getDrawable(holder.context, R.drawable.sc_bottom_item)
    }

}
