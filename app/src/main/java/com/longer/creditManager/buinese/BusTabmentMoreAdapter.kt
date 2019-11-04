package com.longer.creditManager.recording

import android.widget.ImageView
import com.longer.creditManager.R
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.model.todo.buinese.OtherListBean
import hxz.www.commonbase.net.constant.ApiService
import hxz.www.commonbase.util.ImageLoaders
import hxz.www.commonbase.util.log.LogShow

class BusTabmentMoreAdapter : BaseAdapter<OtherListBean>() {

    override fun getItemLayoutResId(data: OtherListBean, position: Int) = R.layout.item_attachment

    override fun bindData(holder: ViewHolder, data: OtherListBean, position: Int) {
        LogShow.i("BusTabmentMoreAdapter  ", data.toString())

        holder.setText(R.id.attachment_name, data.name)
        var cover = holder.getView<ImageView>(R.id.attachment_cover)
        if (data.icon.isNullOrEmpty()) {
            cover.setImageResource(R.mipmap.business_default)
        } else {
            ImageLoaders.loadBusinesw(ApiService.FILE_URL + data.icon, cover)
        }
    }


}