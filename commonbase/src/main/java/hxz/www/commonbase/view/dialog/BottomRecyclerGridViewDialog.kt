package hxz.www.commonbase.view.dialog

import android.content.Context
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.GridLayoutManager
import android.widget.ImageView
import android.widget.TextView
import hxz.www.commonbase.R
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.model.PopModel
import hxz.www.commonbase.net.constant.ApiService
import hxz.www.commonbase.util.FastClickUtil
import hxz.www.commonbase.util.ImageLoaders
import hxz.www.commonbase.util.log.LogShow
import kotlinx.android.synthetic.main.dialog_bottom_recyclerview.*

class BottomRecyclerGridViewDialog constructor(context: Context,
                                               list: MutableList<PopModel>
) : BottomUpDialog(context, R.layout.dialog_bottom_recyclerview, null) {

    private var title: String = ""
    private var defaultPosition = -1
    private var enableSelectedEffect = false
    private var contentList: MutableList<PopModel> = list
    private var listener: OnBottomRecyclerGridViewListener? = null

    fun title(title: String): BottomRecyclerGridViewDialog {
        this.title = title
        return this
    }

    fun listener(listener: OnBottomRecyclerGridViewListener?): BottomRecyclerGridViewDialog {
        this.listener = listener
        return this
    }

    fun defaultPosition(position: Int): BottomRecyclerGridViewDialog {
        defaultPosition = position
        return this
    }

    fun enableSelectedEffect(): BottomRecyclerGridViewDialog {
        enableSelectedEffect = true
        return this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter = BottomRecyclerGridViewAdapter()
        tvTitle?.text = title
        ryContent?.layoutManager = GridLayoutManager(context, 3)
        ryContent?.adapter = adapter
        adapter.data = contentList
        if (defaultPosition > -1 && enableSelectedEffect) {
            adapter.updateSelectedPosition(defaultPosition)
        }
        adapter.setOnItemClickListener { view, data, position ->
            if (!FastClickUtil.isFastClick()) {
                if (enableSelectedEffect)
                    adapter.updateSelectedPosition(position)
                listener?.onContentClickAction(position, data, this@BottomRecyclerGridViewDialog)
            }
        }
        tvCancel.setOnClickListener {
            dismiss()
        }
    }
}

interface OnBottomRecyclerGridViewListener {
    fun onContentClickAction(position: Int, data: PopModel, dialog: BottomRecyclerGridViewDialog)
}

class BottomRecyclerGridViewAdapter : BaseAdapter<PopModel>() {
    private var selectedPosition = -1

    fun updateSelectedPosition(position: Int) {
        selectedPosition = position
        notifyDataSetChanged()
    }

    override fun getItemLayoutResId(data: PopModel?, position: Int) = R.layout.adapter_bottom_gridrview

    override fun bindData(holder: ViewHolder, data: PopModel, position: Int) {
         LogShow.i("BottomRecyclerGridViewDialog.kt  bindData",data.toString())
        holder.setText(R.id.tvContent, data.text)
        holder.getView<TextView>(R.id.tvContent).setTextColor(ContextCompat.getColorStateList(holder.context, R.color.sc_bottom_recycler_item_text_color))

        holder.getView<TextView>(R.id.tvContent).background = ContextCompat.getDrawable(holder.context, R.drawable.sc_bottom_item)
        var cover = holder.getView<ImageView>(R.id.iv_cover)
        if (data.imgUrl.isNullOrEmpty()) {
            ImageLoaders.load(ApiService.FILE_URL + data.imgUrl, cover)
        } else {
            cover.setImageResource(R.mipmap.default_bg)
        }
    }

}