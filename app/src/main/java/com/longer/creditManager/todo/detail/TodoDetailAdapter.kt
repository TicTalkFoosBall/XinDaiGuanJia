package com.longer.creditManager.todo.detail
import com.longer.creditManager.R
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.model.TodoItem
import hxz.www.commonbase.util.log.LogShow

class TodoDetailAdapter : BaseAdapter<TodoItem>() {

    override fun getItemLayoutResId(data:TodoItem, position: Int) = R.layout.item_todo_detail

    override fun bindData(holder: ViewHolder, data: TodoItem, position: Int) {
         LogShow.i(" SystemMsgAdapter  ",data.toString());
        holder.setText(R.id.tv_title,data.title)
        holder.setText(R.id.tv_content,data.timeout)
    }


}