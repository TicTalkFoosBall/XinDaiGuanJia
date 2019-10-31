package com.longer.creditManager.notice

import com.longer.creditManager.R
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.model.ClientPreviewModel
import hxz.www.commonbase.util.log.LogShow
import value


/**
@Author  :rickBei
@Date    :2019/8/9 16:56
@Descripe: From bug to bugs
 **/
class ClientPreviewAdapter : BaseAdapter<ClientPreviewModel>() {

    override fun getItemLayoutResId(data: ClientPreviewModel, position: Int) = R.layout.adapter_clientpreview

    override fun bindData(holder: ViewHolder, data: ClientPreviewModel, position: Int) {
         LogShow.i(" ClientPreviewAdapter  ",data.toString())
        var content=data.summary?.split(",")
        var contentStr=""
        content?.forEach { it ->
            contentStr+=it+"\n"
        }
        holder.setText(R.id.tv_content,contentStr)
        holder.setText(R.id.tv_title,data?.title.value())
        holder.setText(R.id.tv_duration,data.right.value()+"个月")
        holder.setText(R.id.tv_time,data.left.value())


    }

}