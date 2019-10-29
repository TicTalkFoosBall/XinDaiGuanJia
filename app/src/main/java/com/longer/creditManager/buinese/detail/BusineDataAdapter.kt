package com.longer.creditManager.buinese.detail

import android.view.LayoutInflater
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

    var inflater: LayoutInflater? = null
    var titleList: TitleListBean? = null
    var tvList = mutableListOf<TextView>()
    override fun getItemLayoutResId(data: DataBean?, position: Int) = R.layout.adapter_simple
    override fun bindData(holder: ViewHolder, data: DataBean?, position: Int) {
        var container = holder.getView<LinearLayout>(R.id.ll_container)
        if (tvList.isEmpty()) {
            for (i in 0 until container.childCount) {
                container.getChildAt(i)?.let {
                    tvList.add(it as TextView)
                }
            }

        }
        LogShow.i("BusineDataAdapterdapter.kt  bindData", container.childCount, tvList.size, data)

        if (position == 0) {
            titleList = GsonUtil.fromJson(data?.lilv, TitleListBean::class.java)
            LogShow.i("BusineDataAdapterdapter.kt  bindData list", titleList?.titleList?.size)
            titleList?.titleList?.forEachIndexed { index, titleBean ->
                run {
                    tvList.get(index).text = titleBean.fieldNote
                }

            }

        }

//    private fun createTextview(context: Context, str: String, parent: LinearLayout) {
//        LogShow.i("BusineDataAdapter.kt  createTextview", str)
//        var tv = TextView(context)
//        tv.text = str
//        tv.apply {
//            var params=LinearLayout.LayoutParams(context)
//          layoutParams.width = 100F.dp2px()
//         layoutParams.height = ActionBar.LayoutParams.MATCH_PARENT
//        }
//        var textview=inflater?.inflate(R.layout.layout_title,null)
////        tv.setTextColor(R.color.black.getColor())
////        tv.setTextSize(12F)
//        parent.addView(textview)

//    }

    }
}