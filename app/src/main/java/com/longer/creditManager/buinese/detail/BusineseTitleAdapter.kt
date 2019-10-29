package com.longer.creditManager.buinese.detail

import com.longer.creditManager.R
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.model.todo.buinese.TitleBean
import hxz.www.commonbase.util.log.LogShow

/**
@Author  :rickBei
@Date    :2019/10/29 14:46
@Descripe: From bug to bugs
 **/
class BusineseTitleAdapter : BaseAdapter<TitleBean>() {
    override fun getItemLayoutResId(data: TitleBean?, position: Int) = R.layout.adapter_title
    override fun bindData(holder: ViewHolder?, data: TitleBean?, position: Int) {
        LogShow.i("BusineDataAdapter.ktter.kt  bindData", data)
        holder?.setText(R.id.tv_name, data?.fieldNote)
    }



}