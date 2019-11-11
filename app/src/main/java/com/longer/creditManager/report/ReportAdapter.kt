package com.longer.creditManager.recording

import android.graphics.Typeface
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import click
import com.longer.creditManager.R
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.baseui.BaseActivity2
import hxz.www.commonbase.model.report.ConfigBean
import hxz.www.commonbase.util.fragment.FragmentHelper
import hxz.www.commonbase.util.log.LogShow

class ReportAdapter : BaseAdapter<ConfigBean>() {
    private var detailData: MutableMap<String, String>? = null
    private var inflater: LayoutInflater? = null

    override fun getItemLayoutResId(data: ConfigBean, position: Int) = R.layout.item_report

    override fun bindData(holder: ViewHolder, data: ConfigBean, position: Int) {
        LogShow.i(" ReportAdapter  ", data.toString(), data.list, detailData?.size)
        var title = holder.getView<TextView>(R.id.tv_subTitle)
        var container = holder.getView<LinearLayout>(R.id.ll_report_container)
        inflater = LayoutInflater.from(holder.context)
        title.text = data.gropname
        var parent = holder.context as BaseActivity2<*>
        data.list.forEach {
            var valueStr = detailData?.get(it.fieldName)
            var keyStr = it.fieldNote
            LogShow.i("ReportAdapter.kt  foreach", it.toString(),valueStr,valueStr == "null")
            if (!valueStr.isNullOrEmpty()) {
                var view = inflater?.inflate(R.layout.layout_report, null)
                view?.apply {
                    var title = this.findViewById<TextView>(R.id.tv_reportTitle)
                    var value = this.findViewById<TextView>(R.id.tv_reportValue)
                    title.text = it.fieldNote
                    valueStr = if (valueStr == "null") "" else valueStr
                    LogShow.i("ReportAdapter.kt  value", it.toString(), valueStr, valueStr == "null")
                    if (it.controlType.equals("richTextEditor")) {
                        value.typeface = Typeface.defaultFromStyle(Typeface.BOLD)
                        value.textSize = 16F
                        value.text = "详细报告"
                        click {
                            //                        parent.start(FragmentHelper.newInstance(WebViewFragment::class.java, valueStr, true, keyStr, false))
                            parent.start(FragmentHelper.newInstance(RichTextFragment::class.java, keyStr, valueStr))
                        }
                    } else if (it.controlType.equals("13")) {
                        value.typeface = Typeface.defaultFromStyle(Typeface.BOLD)
                        value.textSize = 16F
                        value.text = "点击查看"
                        click {
                        }
                    } else {
                        value.typeface = Typeface.defaultFromStyle(Typeface.NORMAL)
                        value.textSize = 13F
                        value.text = valueStr
                        click { }
                    }
                }
                container.addView(view)
            }

        }

    }

    fun setData(data: MutableMap<String, String>) {
        this.detailData = data
        detailData?.forEach {
            LogShow.i("ReportAdapter.kt  setData", it.key, it.value)
        }
    }


}