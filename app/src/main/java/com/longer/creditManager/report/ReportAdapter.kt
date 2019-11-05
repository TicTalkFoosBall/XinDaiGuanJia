package com.longer.creditManager.recording

import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.longer.creditManager.R
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.model.report.ConfigBean
import hxz.www.commonbase.util.log.LogShow

class ReportAdapter : BaseAdapter<ConfigBean>() {
    private var detailData: MutableMap<String, String>? = null
    private var inflater: LayoutInflater? = null

    override fun getItemLayoutResId(data: ConfigBean, position: Int) = R.layout.item_report

    override fun bindData(holder: ViewHolder, data: ConfigBean, position: Int) {
        LogShow.i(" ReportAdapter  ", data.toString(), detailData?.size)
        var title = holder.getView<TextView>(R.id.tv_subTitle)
        var container = holder.getView<LinearLayout>(R.id.ll_report_container)
        inflater = LayoutInflater.from(holder.context)
        title.text = data.gropname
        data.list.forEach {
            var view = inflater?.inflate(R.layout.layout_report, null)
            view?.apply {
                var title = this.findViewById<TextView>(R.id.tv_reportTitle)
                var value = this.findViewById<TextView>(R.id.tv_reportValue)
                title.setText(it.fieldNote)
                value.setText(detailData?.get(it.fieldName))
            }
            container.addView(view)
        }

    }

    fun setData(data: MutableMap<String, String>) {
        this.detailData = data
    }


}