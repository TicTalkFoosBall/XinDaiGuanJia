package com.longer.creditManager.todo.detail

import com.longer.creditManager.R
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.model.todo.FieldListBean
import hxz.www.commonbase.util.log.LogShow
import hxz.www.commonbase.util.time.DateUtil

class TodoDetailAdapter : BaseAdapter<FieldListBean>() {

    override fun getItemLayoutResId(data: FieldListBean, position: Int) = R.layout.item_todo_detail

    override fun bindData(holder: ViewHolder, data: FieldListBean, position: Int) {
        LogShow.i("TodoDetailAdapter.kt  bindData", data.toString())
        holder.setText(R.id.tv_title, data.fieldNote)
        if (data.fieldName.contains("Date") || data.fieldName.contains("Time")) {
            try {
                var time = data.value.toLong()
                holder.setText(R.id.tv_content, DateUtil.millis2String(time))
            } catch (e: Exception) {
                holder.setText(R.id.tv_content, data.value)
            }

        } else {
            holder.setText(R.id.tv_content, data.value)
        }

    }


}