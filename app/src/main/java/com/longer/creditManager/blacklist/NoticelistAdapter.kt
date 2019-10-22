package com.longer.creditManager.blacklist
import android.widget.ImageView
import com.longer.creditManager.R
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.util.time.DateUtil


/**
@Author  :rickBei
@Date    :2019/8/9 16:56
@Descripe: From bug to bugs
 **/
class NoticelistAdapter : BaseAdapter<NoticeListModel>() {
    private var isDeleteMode: Boolean = false

    override fun getItemLayoutResId(data: NoticeListModel, position: Int) = R.layout.item_notice

    override fun bindData(holder: ViewHolder, data: NoticeListModel, position: Int) {

    }


}