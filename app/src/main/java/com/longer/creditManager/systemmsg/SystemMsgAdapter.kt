package com.longer.creditManager.notice
import com.longer.creditManager.R
import hxz.www.commonbase.model.SystemMsgtem
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.util.log.LogShow
import hxz.www.commonbase.util.time.DateUtil


class SystemMsgAdapter : BaseAdapter<SystemMsgtem>() {


    override fun getItemLayoutResId(data: SystemMsgtem, position: Int) = R.layout.item_systemmsg

    override fun bindData(holder: ViewHolder, data: SystemMsgtem, position: Int) {
         LogShow.i(" SystemMsgAdapter  ",data.toString());
        holder.setText(R.id.tv_time,DateUtil.millis2String(data.createtime))
        holder.setText(R.id.tv_content,data.content)
        holder.setText(R.id.tv_title,data.title)
    }
}