package com.longer.creditManager.todo.list
import com.longer.creditManager.R
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.model.TodoItem
import hxz.www.commonbase.util.log.LogShow

class TodolistAdapter : BaseAdapter<TodoItem>() {

    override fun getItemLayoutResId(data:TodoItem, position: Int) = R.layout.item_examine

    override fun bindData(holder: ViewHolder, data: TodoItem, position: Int) {
         LogShow.i(" SystemMsgAdapter  ",data.toString());
        holder.setText(R.id.tv_company,data.title)
        holder.setText(R.id.bt_time,data.timeout)
        holder.setText(R.id.tv_starttime,data.startTime)

    }


}