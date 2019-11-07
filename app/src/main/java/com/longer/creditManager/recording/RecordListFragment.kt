package com.longer.creditManager.recording

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.longer.creditManager.R
import com.longer.creditManager.buinese.BaseListFragment
import hxz.www.commonbase.adapter.VerticalItemDecoration
import hxz.www.commonbase.baseui.mvp.BaseView2
import hxz.www.commonbase.model.todo.detail.HistoryData
import hxz.www.commonbase.model.todo.detail.TaskHistoryInfoBean
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
        toolbar.setTitle("审核记录")
        toolbar.setLeftClick(View.OnClickListener
        {
            pop()
        })
        var history = getParameter(0) as TaskHistoryInfoBean
        LogShow.i("initData   ", history.toString());

        onQuery(history.data)

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
            var dataList = list?.filterNot { it.result == null }
            mAdapter?.data = dataList
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

