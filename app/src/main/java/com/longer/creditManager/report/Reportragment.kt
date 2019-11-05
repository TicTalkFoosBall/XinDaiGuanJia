package com.longer.creditManager.recording

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.google.gson.JsonObject
import com.longer.creditManager.R
import com.longer.creditManager.basemodel.Api
import com.longer.creditManager.buinese.BaseListFragment
import dp2px
import hxz.www.commonbase.adapter.VerticalItemDecoration
import hxz.www.commonbase.baseui.mvp.BaseView2
import hxz.www.commonbase.model.Attachment
import hxz.www.commonbase.model.report.ReportBean
import hxz.www.commonbase.model.todo.TodoItem
import hxz.www.commonbase.net.BaseResult
import hxz.www.commonbase.net.BaseResultObserver
import hxz.www.commonbase.state.MultiStateView
import hxz.www.commonbase.uibase.mvp.BasePresenterImpl
import hxz.www.commonbase.util.GsonUtil
import hxz.www.commonbase.util.ToastUtil
import hxz.www.commonbase.util.log.LogShow
import hxz.www.commonbase.view.KLRefreshLayout
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_noticelist.*
import value


class ReportFragment : BaseListFragment<ReportPresenter, ReportAdapter>(), ReportView {


    override fun bindAdapter() = ReportAdapter()

    override fun initRefreshLayout(refreshLayout: KLRefreshLayout?) {
        val manager = LinearLayoutManager(context)
        refreshLayout?.setLayoutManager(manager)
        refreshLayout?.setEnableLoadMore(true)
        refreshLayout?.recyclerView?.addItemDecoration(VerticalItemDecoration(8f.dp2px()))
    }

    var todoItem: TodoItem? = null
    var type = ""
    var fromCode = ""
    override fun initData() {

        toolbar.setTitle( getParameter(0) as String)
        toolbar.setLeftClick(View.OnClickListener
        {
            pop()
        })
        todoItem = getParameter(1) as TodoItem?
        fromCode = getParameter(2) as String

        mAdapter.setOnItemClickListener { view, data, position ->
            LogShow.i("NoticeListFragment.kt  initData", data.toString())
        }
    }


//    override fun onQueryTodoAttachments(attachment: MutableList<TodoAttachment>?) {
//
//
//
//    }

    private fun createHoldeBeanList(count: Int): MutableList<Attachment> {
        LogShow.i("Reportragment.kt  createHoldeBeanList begim", count)
        var list = mutableListOf<Attachment>()
        for (i in 0 until count) {
            var bean = Attachment()
            bean.type = "holder"
            list.add(bean)
        }
        LogShow.i("Reportragment.kt  createHoldeBeanList", list.size)
        return list
    }

    override fun loadData(page: Int) {
        LogShow.i("Reportragment.kt  loadData", type)
        mPresenter.getReport(todoItem, fromCode)
    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
        refresh()
    }


    override fun getLayoutId() = R.layout.fragment_noticelist


    override fun onQueryReport(report: ReportBean?) {
        report?.let {
            refreshLayout?.postDelayed({
                mAdapter.setData(report.data)
                mAdapter?.data = it.config
                refreshLayout?.finishLoad()
                refreshLayout?.setMultiStateView(if (mAdapter.dataCount == 0) MultiStateView.VIEW_STATE_EMPTY else MultiStateView.VIEW_STATE_CONTENT)
            }, 500)
        }


    }
}

class ReportPresenter : BasePresenterImpl<ReportView>() {
    private var mDisposable: Disposable? = null


    fun getReport(todoItem: TodoItem?, code: String) {
        LogShow.i("getReport.kt  queryAttachments", code)
        mDisposable = Api.getApiService().getReport(todoItem?.formGroupCode, code, todoItem?.masterId).subscribeWith(object : BaseResultObserver<BaseResult<JsonObject>>() {
            override fun onResult(todoBean: BaseResult<JsonObject>?) {
                var json = todoBean?.result.toString()
                var detailStr = json.substringAfter("\"data\":{").substringBefore("},")

                var list = detailStr.split(",")
                var dataMap = mutableMapOf<String, String>()
                list.let {
                    list.forEachIndexed { index, s ->
                        var key = s.substringBefore(":").trim('"').value()
                        var value = s.substringAfter(":").trim('"').value()
                        dataMap.put(key, value)
                    }
                }
                var titleStr = json.substringAfter("\"config\":")
                var gsonStr = "{\n" +
                        "  \"config\":"+titleStr
                LogShow.i("getReport  map ", gsonStr)
                var bean = GsonUtil.fromJson(gsonStr, ReportBean::class.java)
                bean.data=dataMap
                LogShow.i("getReport bean  ", bean.config,bean.data.size)
                mView.onQueryReport(bean)
            }

            override fun onFailure(e: Throwable, error: String) {
                ToastUtil.show(error)
            }
        })
    }
}

interface ReportView : BaseView2 {
    fun onQueryReport(report: ReportBean?)
}

