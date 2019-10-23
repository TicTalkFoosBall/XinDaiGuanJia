package com.longer.creditManager.notice

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.longer.creditManager.R
import com.longer.creditManager.fragment.BaseListFragment
import hxz.www.commonbase.state.MultiStateView
import hxz.www.commonbase.util.log.LogShow
import hxz.www.commonbase.view.KLRefreshLayout

/**
@Author  :rickBei
@Date    :2019/8/9 16:09
@Descripe: From bug to bugs
 **/
class NoticeListFragment : BaseListFragment<NoticePresenter, NoticelistAdapter>(), NoticeListContract.View {

    override fun bindAdapter() = NoticelistAdapter()

    override fun initRefreshLayout(refreshLayout: KLRefreshLayout?) {
         LogShow.i("initRefreshLayout  ",refreshLayout);
        refreshLayout?.setLayoutManager(LinearLayoutManager(_mActivity))
        refreshLayout?.setEnableLoadMore(true)
    }

    override fun initData() {
        refreshLayout?.recyclerView?.let {
//            ItemClickSupport.addTo(it).addOnChildClickListener(R.id.iv_delete, object : ItemClickSupport.OnChildClickListener {
//                override fun onChildClicked(recyclerView: RecyclerView, position: Int, v: View) {
//
//                }
//            })
        }
         LogShow.i("initData   ","");
    }

    override fun loadData(page: Int) {
        mPresenter.queryNoticeList(page)
    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
         LogShow.i("  onLazyInitView ","");
        refresh()
    }

    override fun onQueryBlackList(list: NoticeListModel?) {
        list?.let {    onQuery(list?.list) }
    }

    private fun onQuery(list: MutableList<NoticeItem>?) {
         LogShow.i(" onQuery  ",list?.size,mAdapter);
        refreshLayout?.postDelayed({
            mAdapter?.data = list
            refreshLayout?.finishLoad()
            refreshLayout?.setMultiStateView(if (mAdapter.dataCount == 0) MultiStateView.VIEW_STATE_EMPTY else MultiStateView.VIEW_STATE_CONTENT)
        }, 500)
    }

    override fun getLayoutId() = R.layout.fragment_noticelist

}