package com.longer.creditManager.recording

import android.widget.ImageView
import android.widget.TextView
import com.longer.creditManager.R
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.model.Attachment
import hxz.www.commonbase.util.log.LogShow
import isVisible
import value

class AttachmentAdapter : BaseAdapter<Attachment>() {

    override fun getItemLayoutResId(data: Attachment, position: Int) = R.layout.item_attachment

    override fun bindData(holder: ViewHolder, data: Attachment, position: Int) {
        LogShow.i(" AttachmentAdapter  ", data?.toString())
        var title = holder.getView<TextView>(R.id.tv_title)
        if (data.type.value() == "attachment") {
            title.isVisible = false
            holder.setText(R.id.attachment_name, data.fileName)
            holder.getView<ImageView>(R.id.attachment_cover).setImageResource(getCover(data.fileSuffix))
        } else if (data.type.value() == "name") {
            title.isVisible = true
            title.text = data.remark
        }
    }

    private fun getCover(suffix: String): Int = when (suffix) {
        ".pdf" -> R.mipmap.file_pdf
        ".doc" -> R.mipmap.file_doc
        ".jpg" -> R.mipmap.file_jpg
        ".png" -> R.mipmap.file_jpg
        ".txt" -> R.mipmap.file_txt
        ".xls" -> R.mipmap.file_xls
        ".other" -> R.mipmap.file_other
        else -> R.mipmap.file_other
    }


}