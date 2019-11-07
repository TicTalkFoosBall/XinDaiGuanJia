package com.longer.creditManager.notice

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.longer.creditManager.buinese.BaseListFragment
import com.longer.creditManager.recording.RichTextFragment
import hxz.www.commonbase.adapter.VerticalItemDecoration
import hxz.www.commonbase.model.NoticeItem
import hxz.www.commonbase.model.NoticeListModel
import hxz.www.commonbase.state.MultiStateView
import hxz.www.commonbase.util.fragment.FragmentHelper
import hxz.www.commonbase.util.log.LogShow
import hxz.www.commonbase.view.KLRefreshLayout
import kotlinx.android.synthetic.main.fragment_noticelist.*
import value


class NoticeListFragment : BaseListFragment<NoticePresenter, NoticelistAdapter>(), NoticeListContract.View {

    override fun bindAdapter() = NoticelistAdapter()

    override fun initRefreshLayout(refreshLayout: KLRefreshLayout?) {
        LogShow.i("initRefreshLayout  ", refreshLayout);
        refreshLayout?.setLayoutManager(LinearLayoutManager(_mActivity))
        refreshLayout?.recyclerView?.addItemDecoration(VerticalItemDecoration(8))
        refreshLayout?.setEnableLoadMore(true)
    }

    override fun initData() {

        mAdapter.setOnItemClickListener { view, data, position ->
            LogShow.i("NoticeListFragment.kt  initData", data.content)
            start(FragmentHelper.newInstance(RichTextFragment::class.java, "公告详情", data.content.value(), data))
        }
        toolbar.setTitle("通知公告")
        toolbar.setLeftClick(View.OnClickListener
        {
            _mActivity.finish()
        })

        LogShow.i("initData   ", "")
    }



    override fun loadData(page: Int) {
        mPresenter.queryNoticeList(page)
    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
        LogShow.i("  onLazyInitView ", "")
        refresh()
    }

    override fun onQueryBlackList(list: NoticeListModel?) {
        list?.let { onQuery(list?.list) }
    }

    private fun onQuery(list: MutableList<NoticeItem>?) {
        LogShow.i(" onQuery  ", list?.size, mAdapter);
        refreshLayout?.postDelayed({
            mAdapter?.data = list
            refreshLayout?.finishLoad()
            refreshLayout?.setMultiStateView(if (mAdapter.dataCount == 0) MultiStateView.VIEW_STATE_EMPTY else MultiStateView.VIEW_STATE_CONTENT)
        }, 500)
    }

    override fun getLayoutId() = com.longer.creditManager.R.layout.fragment_noticelist

}