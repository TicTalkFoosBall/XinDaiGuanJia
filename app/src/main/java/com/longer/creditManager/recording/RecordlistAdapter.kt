package com.longer.creditManager.recording
import com.longer.creditManager.R
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.model.todo.HistoryData
import hxz.www.commonbase.model.todo.TaskHistoryInfoBean
import hxz.www.commonbase.model.todo.TodoItem
import hxz.www.commonbase.util.log.LogShow
import value

class RecordlistAdapter : BaseAdapter<HistoryData>() {

    override fun getItemLayoutResId(data: HistoryData, position: Int) = R.layout.item_history

    override fun bindData(holder: ViewHolder, data: HistoryData, position: Int) {
         LogShow.i(" SystemMsgAdapter  ",data.toString());
        holder.setText(R.id.tv_company,data.name)
        holder.setText(R.id.tv_opinion,data?.result?.desc.value())
        holder.setText(R.id.tv_owner,data.fullname)

    }


}