package com.longer.creditManager.notice

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.longer.creditManager.R
import com.longer.creditManager.buinese.BaseListFragment
import com.longer.creditManager.client.preview.ClientPreviewView
import hxz.www.commonbase.adapter.VerticalItemDecoration
import hxz.www.commonbase.model.ClientPreviewModel
import hxz.www.commonbase.state.MultiStateView
import hxz.www.commonbase.util.log.LogShow
import hxz.www.commonbase.view.KLRefreshLayout
import kotlinx.android.synthetic.main.fragment_noticelist.*

class ClientPreviewFragment : BaseListFragment<ClientPreviewPresenter, ClientPreviewAdapter>(), ClientPreviewView {


    override fun bindAdapter() = ClientPreviewAdapter()

    override fun initRefreshLayout(refreshLayout: KLRefreshLayout?) {
        LogShow.i("initRefreshLayout  ", refreshLayout);
        refreshLayout?.setLayoutManager(LinearLayoutManager(_mActivity))
        refreshLayout?.setEnableLoadMore(true)
        refreshLayout?.recyclerView?.addItemDecoration(VerticalItemDecoration(10))
    }

    override fun initData() {
        refreshLayout?.recyclerView?.let {

            mAdapter.setOnItemClickListener { view, data, position ->

            }
        }

        toolbar.setLeftClick(View.OnClickListener
        {
            _mActivity.finish()
        })
        LogShow.i("initData   ", "")
        mPresenter.queryClient("98367323471091545")
    }


    override fun loadData(page: Int) {
//        mPresenter.queryClient(page)
    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
        LogShow.i("  onLazyInitView ", "");
        refresh()
    }




      override fun onQueryPreview(list: MutableList<ClientPreviewModel>?) {
        LogShow.i(" onQuery  ", list?.size, mAdapter);
        refreshLayout?.postDelayed({
            mAdapter?.data = list
            refreshLayout?.finishLoad()
            refreshLayout?.setMultiStateView(if (mAdapter.dataCount == 0) MultiStateView.VIEW_STATE_EMPTY else MultiStateView.VIEW_STATE_CONTENT)
        }, 500)
    }

    override fun getLayoutId() = R.layout.fragment_client_preview

}