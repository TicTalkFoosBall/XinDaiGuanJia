package com.longer.creditManager.todo.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.longer.creditManager.R
import com.longer.creditManager.basemodel.Api
import com.longer.creditManager.buinese.BaseListFragment
import com.longer.creditManager.todo.RefreshTodoEvent
import hxz.www.commonbase.adapter.VerticalItemDecoration
import hxz.www.commonbase.baseui.mvp.BaseView2
import hxz.www.commonbase.model.todo.TodoBean
import hxz.www.commonbase.model.todo.TodoItem
import hxz.www.commonbase.net.BaseResult
import hxz.www.commonbase.net.BaseResultObserver
import hxz.www.commonbase.uibase.mvp.BasePresenterImpl
import hxz.www.commonbase.util.ToastUtil
import hxz.www.commonbase.util.log.LogShow
import hxz.www.commonbase.view.KLRefreshLayout
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_noticelist.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class TodoListFragment : BaseListFragment<TodoListPresenter, TodolistAdapter>(), TodoListView {

    override fun bindAdapter() = TodolistAdapter()

    override fun initRefreshLayout(refreshLayout: KLRefreshLayout?) {
        LogShow.i("initRefreshLayout  ", refreshLayout);
        refreshLayout?.setLayoutManager(LinearLayoutManager(_mActivity))
        refreshLayout?.setEnableLoadMore(true)
        refreshLayout?.recyclerView?.addItemDecoration(VerticalItemDecoration(8))
    }

    override fun initData() {
        refreshLayout?.recyclerView?.let {

        }
        toolbar.setTitle("审批待办")
        toolbar.setLeftClick(View.OnClickListener
        {
            _mActivity.finish()
        })
        mAdapter.setOnItemClickListener { view, data, position ->


        }
        EventBus.getDefault().register(this)
        LogShow.i("initData   ", "");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    internal fun refresh(event: RefreshTodoEvent) {
        refresh()
        LogShow.i("TodoListFragment  refresh")
    }
    override fun loadData(page: Int) {
        mPresenter.queryodoList(page)
    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
        LogShow.i("onLazyInitView ", "");
        refresh()
    }


    override fun onQuery(list: MutableList<TodoItem>?) {
        LogShow.i(" onQuery  ", list?.size, mAdapter);
        updateData(list)

    }

    override fun getLayoutId() = R.layout.fragment_noticelist
}

class TodoListPresenter : BasePresenterImpl<TodoListView>() {
    private var mDisposable: Disposable? = null
    fun queryodoList(page: Int) {
        LogShow.i("queryodoList ", page)
        mDisposable = Api.getApiService().getTodoList(page, 20).subscribeWith(object : BaseResultObserver<BaseResult<TodoBean>>() {
            override fun onResult(todoBean: BaseResult<TodoBean>?) {
                LogShow.i("queryodoList   ", todoBean?.result?.list?.size);
                mView.onQuery(todoBean?.result?.list)
            }

            override fun onFailure(e: Throwable, error: String) {
                ToastUtil.show(error)
            }
        })

    }
}

interface TodoListView : BaseView2 {

    fun onQuery(list: MutableList<TodoItem>?)
}

