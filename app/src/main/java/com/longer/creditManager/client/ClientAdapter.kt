package com.longer.creditManager.notice

import hxz.www.commonbase.model.client.ClientModel
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.util.log.LogShow
import value


/**
@Author  :rickBei
@Date    :2019/8/9 16:56
@Descripe: From bug to bugs
 **/
class ClientAdapter : BaseAdapter<ClientModel>() {

    override fun getItemLayoutResId(data: ClientModel, position: Int) = com.longer.creditManager.R.layout.item_clientmanagement

    override fun bindData(holder: ViewHolder, data: ClientModel, position: Int) {
         LogShow.i(" ClientAdapter  ",data.toString());
        holder.setText(com.longer.creditManager.R.id.tv_content,data.name)
        var msg=data.name.value()
        if (!msg.isNullOrEmpty())
        {
            if (msg.length>2)
            { msg=msg.substring(msg.length-2,msg.length)
            }
        }
        holder.setText(com.longer.creditManager.R.id.tv_sign,msg)
//       var call= holder.getView<ImageView>(com.longer.creditManager.R.id.iv_call)
//        call.setOnClickListener {
//            Calldialog(holder.context,data.mobile).show()
//        }
    }

}