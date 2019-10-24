package com.longer.creditManager.todo.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.longer.creditManager.R
import com.longer.creditManager.basemodel.Api
import com.longer.creditManager.fragment.BaseListFragment
import hxz.www.commonbase.net.BaseResult
import hxz.www.commonbase.net.BaseResultObserver
import hxz.www.commonbase.adapter.VerticalItemDecoration
import hxz.www.commonbase.baseui.mvp.BaseView2
import hxz.www.commonbase.model.TodoBean
import hxz.www.commonbase.model.TodoItem
import hxz.www.commonbase.state.MultiStateView
import hxz.www.commonbase.uibase.mvp.BasePresenterImpl
import hxz.www.commonbase.util.ToastUtil
import hxz.www.commonbase.util.log.LogShow
import hxz.www.commonbase.view.KLRefreshLayout
import io.reactivex.disposables.Disposable



class TodoListFragment : BaseListFragment<TodoListPresenter, TodolistAdapter>(), TodoListView {

    override fun bindAdapter() = TodolistAdapter()

    override fun initRefreshLayout(refreshLayout: KLRefreshLayout?) {
         LogShow.i("initRefreshLayout  ",refreshLayout);
        refreshLayout?.setLayoutManager(LinearLayoutManager(_mActivity))
        refreshLayout?.setEnableLoadMore(true)
        refreshLayout?.recyclerView?.addItemDecoration(VerticalItemDecoration(8))
    }

    override fun initData() {
        refreshLayout?.recyclerView?.let {

        }
//        iv_back_notice.click {
//            _mActivity.finish()
//        }
        mAdapter.setOnItemClickListener{view,data,position->

        }
         LogShow.i("initData   ","");
    }

    override fun loadData(page: Int) {
        mPresenter.queryodoList(page)
    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
         LogShow.i("onLazyInitView ","");
        refresh()
    }



      override fun onQuery(list: MutableList<TodoItem>?) {
         LogShow.i(" onQuery  ",list?.size,mAdapter);
        refreshLayout?.postDelayed({
            mAdapter?.data = list
            refreshLayout?.finishLoad()
            refreshLayout?.setMultiStateView(if (mAdapter.dataCount == 0) MultiStateView.VIEW_STATE_EMPTY else MultiStateView.VIEW_STATE_CONTENT)
        }, 500)
    }

    override fun getLayoutId() = R.layout.fragment_noticelist
}

class TodoListPresenter : BasePresenterImpl<TodoListView>() {
    private var mDisposable: Disposable? = null
    fun queryodoList(page: Int) {
        LogShow.i("queryodoList ",page);
        mDisposable= Api.getApiService().getTodoList(page,20).
                subscribeWith(object : BaseResultObserver<BaseResult<TodoBean>>() {
                    override fun onResult(todoBean: BaseResult<TodoBean>?) {
                        LogShow.i("queryodoList   ",todoBean?.result?.list?.size);
mView.onQuery(todoBean?.result?.list)
                    }

                    override fun onFailure(e: Throwable, error: String) {
                        ToastUtil.show(error)
                    }
                } )

    }
}

interface  TodoListView:BaseView2
{

    fun onQuery(list:MutableList<TodoItem>?)
}

