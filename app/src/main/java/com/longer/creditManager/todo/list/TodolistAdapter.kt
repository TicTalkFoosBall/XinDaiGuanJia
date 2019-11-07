package com.longer.creditManager.todo.list

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.longer.creditManager.R
import com.longer.creditManager.todo.detail.TodoDetailActivity
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.model.todo.TodoItem
import hxz.www.commonbase.util.log.LogShow

class TodolistAdapter : BaseAdapter<TodoItem>() {

    override fun getItemLayoutResId(data: TodoItem, position: Int) = R.layout.item_examine

    override fun bindData(holder: ViewHolder, data: TodoItem, position: Int) {
        LogShow.i(" SystemMsgAdapter  ", data.toString())
        holder.setText(R.id.tv_company, data.taskName)
        holder.setText(R.id.bt_time, data.timeout)
        holder.setText(R.id.tv_starttime, data.startTime)
        var startBt = holder.getView<Button>(R.id.b_1)
        startBt.setOnClickListener {
            holder.context.startActivity(Intent(holder.context, TodoDetailActivity::class.java).apply {
                putExtra("params",
                        Bundle().apply {
                            putSerializable("todoItem", data)
                        })
            })
        }
    }


}