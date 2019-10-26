package com.longer.creditManager.recording

import com.longer.creditManager.R
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.model.Attachment
import hxz.www.commonbase.util.log.LogShow

class AttachmentAdapter : BaseAdapter<Attachment>() {

    override fun getItemLayoutResId(data: Attachment, position: Int) = R.layout.item_attachment

    override fun bindData(holder: ViewHolder, data: Attachment, position: Int) {
        LogShow.i(" AttachmentAdapter  ", data.toString())
        holder.setText(R.id.attachment_name, data.fileName)
    }


}