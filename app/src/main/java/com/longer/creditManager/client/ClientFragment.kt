package com.longer.creditManager.notice

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.longer.creditManager.R
import com.longer.creditManager.buinese.BaseListFragment
import com.longer.creditManager.clientdetail.ClientDetailActivity
import getTextStr
import hxz.www.commonbase.adapter.ItemClickSupport
import hxz.www.commonbase.adapter.KlDialog
import hxz.www.commonbase.model.client.ClientModel
import hxz.www.commonbase.state.MultiStateView
import hxz.www.commonbase.util.log.LogShow
import hxz.www.commonbase.view.KLRefreshLayout
import kotlinx.android.synthetic.main.fragment_client.*

class ClientFragment : BaseListFragment<ClientPresenter, ClientAdapter>(), ClientContract.View {

    override fun bindAdapter() = ClientAdapter()

    override fun initRefreshLayout(refreshLayout: KLRefreshLayout?) {
        refreshLayout?.setLayoutManager(LinearLayoutManager(_mActivity))
        refreshLayout?.setEnableLoadMore(true)
    }

    override fun initData() {
        refreshLayout?.recyclerView?.let {
            ItemClickSupport.addTo(it).addOnChildClickListener(R.id.iv_call, object : ItemClickSupport.OnChildClickListener {
                override fun onChildClicked(recyclerView: RecyclerView, position: Int, v: View) {
                    var data = mAdapter.data[position]
                    KlDialog.builder(_mActivity)
                            .autoDismiss()
                            .setMessage(data.mobile)
                            .setNegativeButton("取消") {}
                            .setPositiveButton("呼叫") {
                                call(data.mobile)
                            }.show()
                }
            })

            mAdapter.setOnItemClickListener { view, data, position ->
                startActivity(Intent(activity, ClientDetailActivity::class.java).apply {
                    putExtra("params", Bundle().apply { putSerializable("client", data) })
                })
            }
        }


        tv_search.setOnEditorActionListener(object :TextView.OnEditorActionListener {
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    searchData()
                }
                return false
            }


        })

    }


    private fun searchData()
    {
        var key=tv_search.getTextStr();
        var resultList=oriList?.filter { it.name.contains(key) }
        mAdapter?.data = resultList
    }


    private fun call(phoneNumber: String) {
        LogShow.i("call   ", phoneNumber);
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$phoneNumber"))
        startActivity(intent)
    }

    override fun loadData(page: Int) {
        mPresenter.queryClient(page)
    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
        LogShow.i("  onLazyInitView ", "");
        refresh()
    }

    override fun queryClient(list: MutableList<ClientModel>?) {
        list?.let { onQuery(list) }
    }

    private var oriList: MutableList<ClientModel>?=null
    private fun onQuery(list: MutableList<ClientModel>?) {
        LogShow.i(" onQuery  ", list?.size, mAdapter);
        refreshLayout?.postDelayed({
            oriList=list
            mAdapter?.data = list
            refreshLayout?.finishLoad()
            refreshLayout?.setMultiStateView(if (mAdapter.dataCount == 0) MultiStateView.VIEW_STATE_EMPTY else MultiStateView.VIEW_STATE_CONTENT)
        }, 500)
    }

    override fun getLayoutId() = R.layout.fragment_client

}