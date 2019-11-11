package com.longer.creditManager.notice

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.longer.creditManager.R
import com.longer.creditManager.buinese.BaseListFragment
import hxz.www.commonbase.adapter.VerticalItemDecoration
import hxz.www.commonbase.model.SystemMsgModel
import hxz.www.commonbase.model.SystemMsgtem
import hxz.www.commonbase.util.log.LogShow
import hxz.www.commonbase.view.KLRefreshLayout
import kotlinx.android.synthetic.main.fragment_noticelist.*

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
//                }
//            })
        }
        toolbar.setTitle("系统消息")
        toolbar.setLeftClick(View.OnClickListener
        {
            _mActivity.finish()
        })
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
        updateData(list)
//        refreshLayout?.postDelayed({
//        mAdapter?.data = list
//        refreshLayout?.finishLoad()
//        refreshLayout?.setMultiStateView(if (mAdapter.dataCount == 0) MultiStateView.VIEW_STATE_EMPTY else MultiStateView.VIEW_STATE_CONTENT)
//    }, 500)
}

    override fun getLayoutId() = R.layout.fragment_noticelist

}