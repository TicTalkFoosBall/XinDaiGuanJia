package com.longer.creditManager.todo.detail
import com.longer.creditManager.R
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.model.todo.FieldListBean

class TodoDetailAdapter : BaseAdapter<FieldListBean>() {

    override fun getItemLayoutResId(data:FieldListBean, position: Int) = R.layout.item_todo_detail

    override fun bindData(holder: ViewHolder, data: FieldListBean, position: Int) {
        holder.setText(R.id.tv_title,data.fieldNote)
        holder.setText(R.id.tv_content,data.value)
    }


}