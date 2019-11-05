package com.longer.creditManager.buinese.detail

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.longer.creditManager.R
import hxz.www.commonbase.baseui.BaseFragment2
import hxz.www.commonbase.model.todo.TodoItem
import hxz.www.commonbase.model.todo.buinese.BusineseDetailBean
import hxz.www.commonbase.util.log.LogShow
import isVisible
import kotlinx.android.synthetic.main.fragment_test.*
import value

class BusinessDetailFragment : BaseFragment2<TestPresenter>(), TestView {


    var leftList = mutableListOf<String>()

    override fun onQuery(detail: BusineseDetailBean, name: String?) {

        adapter?.setTitleList(detail.title)
        var dataList = mutableListOf<MutableMap<String, String>>()
        dataList.add(0, mutableMapOf<String, String>().apply { put("key", "value") })
        dataList.addAll(detail.data)
        adapter?.data = dataList
        leftList.clear()

        LogShow.i("onQuery  add   ", leftList.size)
        adapter2?.data = leftList
        if (!name.isNullOrEmpty()) {
            toolbar.setTitle(name.trim('"').value())
        }
    }

    private var adapter: BusineDataAdapter? = null
    private var adapter2: BusineseTitleAdapter? = null

    override fun showError(reqCode: Int, msg: String?) {
    }

    @TargetApi(Build.VERSION_CODES.M)
    override fun initEventAndData(savedInstanceState: Bundle?) {

        var type = getParameter(0) as String
        adapter = BusineDataAdapter()
        if (type == "businese") {
            mPresenter.getBusineseDetail(getParameter(2) as String)
        } else {
            var todoItem = getParameter(2) as TodoItem?
            adapter?.setMode(false)
            mPresenter.queryRepay(todoItem)
        }
        initRecycleview()
        toolbar.setTitle(getParameter(1) as String)
        toolbar.setLeftClick(View.OnClickListener
        {
            _mActivity.finish()
        })

        scroll.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            LogShow.i("BusinessDetailFragment.ktragment.kt  initEventAndData", scrollY - oldScrollY)
            if (!ry_test2.isVisible) {
                ry_test2.isVisible = true
            }
        }

    }

    private fun initRecycleview() {
        val manager = LinearLayoutManager(context)

        ry_test.setLayoutManager(manager)
        ry_test.setAdapter(adapter)
        ry_test.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if (ry_test2.isVisible) {
                    ry_test2.isVisible = false
                }
                ry_test2.scrollTo(0, ry_test.scrollY)
                super.onScrolled(recyclerView, dx, dy)
            }
        })

        val manager2 = LinearLayoutManager(context)
        adapter2 = BusineseTitleAdapter()
        ry_test2.setLayoutManager(manager2)
        ry_test2.setAdapter(adapter2)

        ry_test2.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if (ry_test2.isVisible) {
                    ry_test2.isVisible = false
                }

                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }


    override fun getLayoutId() = R.layout.fragment_test

}