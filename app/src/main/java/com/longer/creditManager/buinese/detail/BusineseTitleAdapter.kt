package com.longer.creditManager.buinese.detail

import android.service.autofill.TextValueSanitizer
import android.util.TypedValue
import android.widget.LinearLayout
import android.widget.TextView
import com.longer.creditManager.R
import getColor
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.model.todo.buinese.TitleBean
import hxz.www.commonbase.util.log.LogShow

class BusineseTitleAdapter : BaseAdapter<String>() {
    override fun getItemLayoutResId(data: String?, position: Int) = R.layout.adapter_title
    override fun bindData(holder: ViewHolder, data: String, position: Int) {
        LogShow.i("BusineseTitleAdapter  bindData", data)
        var tv=holder.getView<TextView>(R.id.tv_name)
        tv.text=data


        var parent=holder.getView<LinearLayout>(R.id.ll_titleParent)
        if (position==0)
        {
            parent.setBackgroundColor(R.color.gray_E5E5EA.getColor())
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,16F)
        }
        else{
            parent.setBackgroundColor(R.color.white.getColor())
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,12F)
        }

    }

}