package com.longer.creditManager.notice
import com.longer.creditManager.R
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.model.NoticeItem
import hxz.www.commonbase.util.log.LogShow


class NoticelistAdapter : BaseAdapter<NoticeItem>() {


    override fun getItemLayoutResId(data: NoticeItem, position: Int) = R.layout.item_notice

    override fun bindData(holder: ViewHolder, data: NoticeItem, position: Int) {
         LogShow.i(" SystemMsgAdapter  ",data.toString());
        holder.setText(R.id.tv_time,""+data.createtime)
        holder.setText(R.id.tv_content,data.title)
    }


}