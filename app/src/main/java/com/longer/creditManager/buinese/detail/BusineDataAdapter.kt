package com.longer.creditManager.buinese.detail

import android.util.TypedValue
import android.widget.LinearLayout
import android.widget.TextView
import com.longer.creditManager.R
import getColor
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.model.todo.buinese.DataBean
import hxz.www.commonbase.model.todo.buinese.TitleListBean
import hxz.www.commonbase.util.GsonUtil
import hxz.www.commonbase.util.log.LogShow
import isVisible
import value

class BusineDataAdapter : BaseAdapter<DataBean>() {

    var titleList: TitleListBean? = null
    var tvList = mutableListOf<TextView>()
    override fun getItemLayoutResId(data: DataBean?, position: Int) = R.layout.adapter_simple
    override fun bindData(holder: ViewHolder, data: DataBean?, position: Int) {
        var container = holder.getView<LinearLayout>(R.id.ll_container)
        var listJson = GsonUtil.toJson(data)
        tvList.clear()
        for (i in 0 until container.childCount) {
            container.getChildAt(i)?.let {
                tvList.add(it as TextView)
            }
        }

        if (position == 0) {
            container.setBackgroundColor(R.color.gray_E5E5EA.getColor())
            titleList?.titleList?.forEachIndexed { index, titleBean ->
                run {
                    if (tvList.size > index) {
                        var tv = tvList.get(index)
                        tv.text = titleBean.fieldNote
                        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16F)
                        tv.isVisible = true
                    }
                }
            }
        } else {
            container.setBackgroundColor(R.color.white.getColor())
            titleList?.titleList?.forEachIndexed { index, titleBean ->
                run {
                    if (tvList.size > index) {
                        var tv = tvList.get(index)
                        tv.text = titleBean.fieldNote
                        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12F)
                        tv.isVisible = true
                        var value = listJson.substringAfter(titleBean.fieldName)

                        if (listJson.contains(titleBean.fieldName)) {
                            value = value.substringBefore(",")
                            if (value.contains("}")) {
                                value = value.substringBefore("}")
                            }
                            if (value.contains(":")) {
                                value = value.substringAfter(":")
                            }
                            value = value.substring(1, value.length - 1)
                            LogShow.i("BusineDataAdaptekt  bindData >0", value)
                            tv.text = value.value()
                        }
                    }
                }

            }
        }
    }

    public fun setTitleList(json: String) {
        titleList = GsonUtil.fromJson(json, TitleListBean::class.java)
    }
}