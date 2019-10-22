package com.longer.creditManager.blacklist
import android.widget.ImageView
import com.longer.creditManager.R
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.util.log.LogShow
import hxz.www.commonbase.util.time.DateUtil


/**
@Author  :rickBei
@Date    :2019/8/9 16:56
@Descripe: From bug to bugs
 **/
class NoticelistAdapter : BaseAdapter<NoticeItem>() {


    override fun getItemLayoutResId(data: NoticeItem, position: Int) = R.layout.item_notice

    override fun bindData(holder: ViewHolder, data: NoticeItem, position: Int) {
         LogShow.i(" NoticelistAdapter  ",data.toString());
        holder.setText(R.id.tv_time,data.createtime)
        holder.setText(R.id.tv_content,data.title)
    }


}