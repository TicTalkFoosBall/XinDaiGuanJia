package com.longer.creditManager.recording

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.longer.creditManager.R
import com.longer.creditManager.fragment.BaseListFragment
import com.longer.creditManager.todo.detail.TodoDetailActivity
import com.longer.creditManager.todo.list.TodoListPresenter
import com.longer.creditManager.todo.list.TodoListView
import hxz.www.commonbase.adapter.VerticalItemDecoration
import hxz.www.commonbase.baseui.mvp.BaseView2
import hxz.www.commonbase.model.todo.HistoryData
import hxz.www.commonbase.model.todo.TaskHistoryInfoBean
import hxz.www.commonbase.model.todo.TodoItem
import hxz.www.commonbase.state.MultiStateView
import hxz.www.commonbase.uibase.mvp.BasePresenterImpl
import hxz.www.commonbase.util.log.LogShow
import hxz.www.commonbase.view.KLRefreshLayout
import kotlinx.android.synthetic.main.fragment_noticelist.*


class RecordListFragment : BaseListFragment<RecorListPresenter, RecordlistAdapter>(), RecorListView {

    override fun bindAdapter() = RecordlistAdapter()

    override fun initRefreshLayout(refreshLayout: KLRefreshLayout?) {

        refreshLayout?.setLayoutManager(LinearLayoutManager(_mActivity))
        refreshLayout?.setEnableLoadMore(true)
        refreshLayout?.recyclerView?.addItemDecoration(VerticalItemDecoration(8))
    }

    override fun initData() {
        refreshLayout?.recyclerView?.let {

        }
        toolbar.setTitle("审批代办")
        toolbar.setLeftClick(View.OnClickListener
        {
            _mActivity.finish()
        })
        var history=getParameter(0) as TaskHistoryInfoBean
         LogShow.i("initData   ",history.toString());
        mAdapter.setOnItemClickListener { view, data, position ->
            startActivity(Intent(_mActivity, TodoDetailActivity::class.java).apply {
                putExtra("params",
                        Bundle().apply {
                            putSerializable("todoItem",data)
                        })
            })
        }
        onQuery(history.data)
        LogShow.i("initData   ", "");
    }

    override fun loadData(page: Int) {
        
    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
        LogShow.i("onLazyInitView ", "");
        refresh()
    }


    override fun onQuery(list: MutableList<HistoryData>?) {
        LogShow.i("onQuery  ", list?.size, mAdapter);
        refreshLayout?.postDelayed({
            mAdapter?.data = list
            refreshLayout?.finishLoad()
            refreshLayout?.setMultiStateView(if (mAdapter.dataCount == 0) MultiStateView.VIEW_STATE_EMPTY else MultiStateView.VIEW_STATE_CONTENT)
        }, 500)
    }

    override fun getLayoutId() = R.layout.fragment_noticelist
}

class RecorListPresenter : BasePresenterImpl<RecorListView>() {

}

interface RecorListView : BaseView2 {

    fun onQuery(list: MutableList<HistoryData>?)
}

