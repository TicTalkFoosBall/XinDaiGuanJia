package com.longer.creditManager.notice

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import click
import com.longer.creditManager.R
import com.longer.creditManager.fragment.BaseListFragment
import com.longer.creditManager.systemmsg.SystemMsgModel
import com.longer.creditManager.systemmsg.SystemMsgtem
import hxz.www.commonbase.adapter.VerticalItemDecoration
import hxz.www.commonbase.state.MultiStateView
import hxz.www.commonbase.util.log.LogShow
import hxz.www.commonbase.view.KLRefreshLayout
import kotlinx.android.synthetic.main.fragment_noticelist.*

/**
@Author  :rickBei
@Date    :2019/8/9 16:09
@Descripe: From bug to bugs
 **/
class SystemMsgFragment : BaseListFragment<SystemMsgPresenter, SystemMsgAdapter>(), SystemMsgContract.View {

    override fun bindAdapter() = SystemMsgAdapter()

    override fun initRefreshLayout(refreshLayout: KLRefreshLayout?) {
         LogShow.i("initRefreshLayout  ",refreshLayout);
        refreshLayout?.setLayoutManager(LinearLayoutManager(_mActivity))
        refreshLayout?.setEnableLoadMore(true)
        refreshLayout?.recyclerView?.addItemDecoration( VerticalItemDecoration(8))
    }

    override fun initData() {
        refreshLayout?.recyclerView?.let {
//            ItemClickSupport.addTo(it).addOnChildClickListener(R.id.iv_delete, object : ItemClickSupport.OnChildClickListener {
//                override fun onChildClicked(recyclerView: RecyclerView, position: Int, v: View) {
//
//                }
//            })
        }
        iv_back_notice.click {
            _mActivity.finish()
        }
         LogShow.i("initData   ","");
    }

    override fun loadData(page: Int) {
        mPresenter.queryMsgList(page)
    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
         LogShow.i("  onLazyInitView ","");
        refresh()
    }

    override fun onQueryBlackList(list: SystemMsgModel?) {
        list?.let {    onQuery(list?.list) }
    }

    private fun onQuery(list: MutableList<SystemMsgtem>?) {
         LogShow.i(" onQuery  ",list?.size,mAdapter);
        refreshLayout?.postDelayed({
            mAdapter?.data = list
            refreshLayout?.finishLoad()
            refreshLayout?.setMultiStateView(if (mAdapter.dataCount == 0) MultiStateView.VIEW_STATE_EMPTY else MultiStateView.VIEW_STATE_CONTENT)
        }, 500)
    }

    override fun getLayoutId() = R.layout.fragment_noticelist

}