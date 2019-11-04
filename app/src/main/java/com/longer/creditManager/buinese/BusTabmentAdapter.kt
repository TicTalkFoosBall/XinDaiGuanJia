package com.longer.creditManager.recording

import android.widget.ImageView
import com.longer.creditManager.R
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.model.todo.buinese.DefaultListBean
import hxz.www.commonbase.net.constant.ApiService
import hxz.www.commonbase.util.ImageLoaders
import hxz.www.commonbase.util.log.LogShow

class BusTabmentAdapter : BaseAdapter<DefaultListBean>() {

    override fun getItemLayoutResId(data: DefaultListBean, position: Int) = R.layout.item_attachment

    override fun bindData(holder: ViewHolder, data: DefaultListBean, position: Int) {
        LogShow.i("BusTabmentAdapter  ", data.toString())

        holder.setText(R.id.attachment_name, data.name)
        var cover = holder.getView<ImageView>(R.id.attachment_cover)
        if (data.iconRes != 0) {
            cover.setImageResource(data.iconRes)
        } else {
            if (data.icon.isNullOrEmpty()) {
                cover.setImageResource(R.mipmap.business_default)
            } else {
                ImageLoaders.loadBusinesw(ApiService.FILE_URL + data.icon, cover)
            }

        }

    }


}