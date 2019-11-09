package com.longer.creditManager.buinese.more

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.longer.creditManager.buinese.BaseListFragment
import com.longer.creditManager.buinese.detail.BusineseDetailActivity
import com.longer.creditManager.recording.BusTabmentMoreAdapter
import hxz.www.commonbase.adapter.VerticalItemDecoration
import hxz.www.commonbase.baseui.mvp.BaseView2
import hxz.www.commonbase.model.todo.buinese.OtherListBean
import hxz.www.commonbase.model.todo.buinese.OtherListBeanSeri
import hxz.www.commonbase.state.MultiStateView
import hxz.www.commonbase.util.log.LogShow
import hxz.www.commonbase.view.KLRefreshLayout
import kotlinx.android.synthetic.main.fragment_noticelist.*


class BusineseMoreFragment : BaseListFragment<BusineseMorePresenter, BusTabmentMoreAdapter>(), BusineseMoreView {

    override fun bindAdapter() = BusTabmentMoreAdapter()

    override fun initRefreshLayout(refreshLayout: KLRefreshLayout?) {
        LogShow.i("initRefreshLayout  ", refreshLayout)
        val manager = GridLayoutManager(context, 3)
        refreshLayout?.setLayoutManager(manager)
        refreshLayout?.recyclerView?.addItemDecoration(VerticalItemDecoration(8))
        refreshLayout?.setEnableLoadMore(true)
        mAdapter.setOnItemClickListener { view, model, position ->
            LogShow.i("BusineseMoreFragment  initRecycleview", position)
            val intent = Intent(context, BusineseDetailActivity::class.java)
            intent.putExtra("code", model.getCode())
            intent.putExtra("name", model.getName())
            startActivity(intent)

        }

    }

    override fun initData() {
        var otherBeans: OtherListBeanSeri? = null
        getParameter(0)?.let {
            otherBeans = it as OtherListBeanSeri
            onQuery(otherBeans?.otherListBeans)
        }
        LogShow.i("BusineseMoreFragment.kt  initData", otherBeans?.otherListBeans?.size)
        toolbar.setTitle("更多统计")
        toolbar.setLeftClick(View.OnClickListener
        {
            _mActivity.finish()
        })

        LogShow.i("initData   ", "")
    }

    override fun loadData(page: Int) {
    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
        LogShow.i("  onLazyInitView ", "")
        refresh()
    }


    private fun onQuery(list: MutableList<OtherListBean>?) {
        LogShow.i(" onQuery  ", list?.size, mAdapter);
        refreshLayout?.postDelayed({
            mAdapter?.data = list
            refreshLayout?.finishLoad()
            refreshLayout?.setMultiStateView(if (mAdapter.dataCount == 0) MultiStateView.VIEW_STATE_EMPTY else MultiStateView.VIEW_STATE_CONTENT)
        }, 500)
    }

    override fun getLayoutId() = com.longer.creditManager.R.layout.fragment_noticelist

}


interface BusineseMoreView : BaseView2 {


}
