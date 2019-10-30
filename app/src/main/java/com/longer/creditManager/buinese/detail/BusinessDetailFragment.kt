package com.longer.creditManager.buinese.detail

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.longer.creditManager.R
import com.longer.creditManager.recording.AttachmentFragment
import hxz.www.commonbase.baseui.BaseFragment2
import hxz.www.commonbase.model.todo.buinese.BusineseDetailBean
import hxz.www.commonbase.model.todo.buinese.DataBean
import hxz.www.commonbase.model.todo.buinese.TitleListBean
import hxz.www.commonbase.util.GsonUtil
import hxz.www.commonbase.util.fragment.FragmentHelper
import hxz.www.commonbase.util.log.LogShow
import isVisible
import kotlinx.android.synthetic.main.fragment_noticelist.*
import kotlinx.android.synthetic.main.fragment_test.*
import kotlinx.android.synthetic.main.fragment_test.toolbar

/**
@Author  :rickBei
@Date    :2019/10/29 14:01
@Descripe: From bug to bugs
 **/
class BusinessDetailFragment : BaseFragment2<TestPresenter>(), TestView {


    var leftList= mutableListOf<String>()
    override fun onQuery(detail: BusineseDetailBean) {

        var titelList=TitleListBean()
        titelList.titleList.addAll(detail.title)
        var titlejsoon = GsonUtil.toJson( titelList)
         LogShow.i("onQuery  data ",detail.title.size);
        adapter?.setTitleList(titlejsoon)
        var dataList= mutableListOf<DataBean>()
        dataList.addAll(detail.data)
        dataList.add(0,DataBean())
        adapter?.data = dataList
        leftList.clear()

        leftList.add(detail.title.get(0).fieldNote)

        detail.data.forEach {
            var json=GsonUtil.toJson(it)
            if (json.contains(detail.title.get(0).fieldName))
            {
                var value=json.substringAfter(detail.title.get(0).fieldName)
                 value=value.substringBefore(",")
                if (value.contains("}"))
                {
                    value=value.substringBefore("}")
                }
                if (value.contains(":"))
                {
                    value=value.substringAfter(":")
                }
                value=value.substring(1,value.length-1)
                leftList.add(value)
            }
        }
        LogShow.i("onQuery  add   ",leftList.size);
        adapter2?.data = leftList
    }
    private var adapter: BusineDataAdapter? = null
    private var adapter2: BusineseTitleAdapter? = null

    override fun showError(reqCode: Int, msg: String?) {
    }

    @TargetApi(Build.VERSION_CODES.M)
    override fun initEventAndData(savedInstanceState: Bundle?) {
        initRecycleview()
        mPresenter.getBusineseDetail(getParameter(0) as String)
        toolbar.setTitle(getParameter(1) as String)
        toolbar.setLeftClick(View.OnClickListener
        {
           _mActivity.finish()
        })

        scroll.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            LogShow.i("BusinessDetailFragment.ktragment.kt  initEventAndData", scrollY - oldScrollY)
            ry_test2.isVisible = true
        }

    }

    private fun initRecycleview() {
        val manager = LinearLayoutManager(context)
        adapter = BusineDataAdapter()
        ry_test.setLayoutManager(manager)
        ry_test.setAdapter(adapter)
        ry_test.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                LogShow.i("BusinessDetailFragmentilFragment.kt  onScrolled", dx)
                ry_test2.isVisible = false
                super.onScrolled(recyclerView, dx, dy)
            }
        })

        val manager2 = LinearLayoutManager(context)
        adapter2 = BusineseTitleAdapter()
        ry_test2.setLayoutManager(manager2)
        ry_test2.setAdapter(adapter2)
    }


    override fun getLayoutId() = R.layout.fragment_test

}