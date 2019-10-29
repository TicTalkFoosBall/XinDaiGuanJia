package com.longer.creditManager.buinese.detail

import android.widget.LinearLayout
import android.widget.TextView
import com.longer.creditManager.R
import hxz.www.commonbase.adapter.BaseAdapter
import hxz.www.commonbase.adapter.ViewHolder
import hxz.www.commonbase.model.todo.buinese.DataBean
import hxz.www.commonbase.model.todo.buinese.TitleListBean
import hxz.www.commonbase.util.GsonUtil
import hxz.www.commonbase.util.log.LogShow

/**
@Author  :rickBei
@Date    :2019/10/29 14:46
@Descripe: From bug to bugs
 **/
class BusineDataAdapter : BaseAdapter<DataBean>() {

    var titleList: TitleListBean? = null
    var tvList = mutableListOf<TextView>()
    override fun getItemLayoutResId(data: DataBean?, position: Int) = R.layout.adapter_simple
    override fun bindData(holder: ViewHolder, data: DataBean?, position: Int) {
        var container = holder.getView<LinearLayout>(R.id.ll_container)
        tvList.clear()
            for (i in 0 until container.childCount) {
                container.getChildAt(i)?.let {
                    tvList.add(it as TextView)
                }
            }

        LogShow.i("BusineDataAdapterdapter.kt  bindData",position, container.childCount, tvList.size, data)

        if (position == 0) {
            titleList = GsonUtil.fromJson(data?.lilv, TitleListBean::class.java)
            LogShow.i("BusineDataAdapterdapter.kt  bindData ==0", titleList?.titleList?.size)
            titleList?.titleList?.forEachIndexed { index, titleBean ->
                run {
                    tvList.get(index).text = titleBean.fieldNote
                }
            }
        } else
        {
             LogShow.i("BusineDataAdapter.kt  bindData >0",titleList?.titleList?.size)
            titleList?.titleList?.forEachIndexed { index, titleBean ->
                run {
                    tvList.get(index).text =data?.amount
                }

            }
        }

    }
}