package com.longer.creditManager.notice

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.longer.creditManager.R
import com.longer.creditManager.buinese.BaseListFragment
import com.longer.creditManager.client.preview.ClientPreviewView
import dp2px
import hxz.www.commonbase.adapter.VerticalItemDecoration
import hxz.www.commonbase.model.ClientPreviewModel
import hxz.www.commonbase.state.MultiStateView
import hxz.www.commonbase.util.log.LogShow
import hxz.www.commonbase.view.KLRefreshLayout
import kotlinx.android.synthetic.main.fragment_noticelist.*

class ClientPreviewFragment : BaseListFragment<ClientPreviewPresenter, ClientPreviewAdapter>(), ClientPreviewView {

    override fun bindAdapter() = ClientPreviewAdapter()

    override fun initRefreshLayout(refreshLayout: KLRefreshLayout?) {

        refreshLayout?.setLayoutManager(LinearLayoutManager(_mActivity))
        refreshLayout?.setEnableLoadMore(true)
        refreshLayout?.recyclerView?.addItemDecoration(VerticalItemDecoration(10f.dp2px()))
    }

    override fun initData() {
        LogShow.i("initRefreshLayout  ", refreshLayout);
        refreshLayout?.recyclerView?.let {

            mAdapter.setOnItemClickListener { view, data, position ->

            }
        }

        toolbar.setLeftClick(View.OnClickListener
        {
            _mActivity.finish()
        })
        var id=getParameter(0) as String
        LogShow.i("initData   ", id)
        mPresenter.queryClient(id)
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
          updateData(list)
    }

    override fun getLayoutId() = R.layout.fragment_client_preview

}