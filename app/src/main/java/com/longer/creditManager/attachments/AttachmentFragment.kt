package com.longer.creditManager.recording

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.longer.creditManager.R
import com.longer.creditManager.basemodel.Api
import com.longer.creditManager.buinese.BaseListFragment
import com.longer.creditManager.view.webview.WebViewFragment
import hxz.www.commonbase.adapter.VerticalItemDecoration
import hxz.www.commonbase.baseui.mvp.BaseView2
import hxz.www.commonbase.model.Attachment
import hxz.www.commonbase.model.NoticeItem
import hxz.www.commonbase.model.TodoAttachment
import hxz.www.commonbase.model.todo.TodoItem
import hxz.www.commonbase.net.BaseResult
import hxz.www.commonbase.net.BaseResultObserver
import hxz.www.commonbase.net.constant.ApiService
import hxz.www.commonbase.state.MultiStateView
import hxz.www.commonbase.uibase.mvp.BasePresenterImpl
import hxz.www.commonbase.util.ToastUtil
import hxz.www.commonbase.util.fragment.FragmentHelper
import hxz.www.commonbase.util.log.LogShow
import hxz.www.commonbase.view.KLRefreshLayout
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_noticelist.*


class AttachmentFragment : BaseListFragment<AttachmentPresenter, AttachmentAdapter>(), AttachmentView {


    override fun bindAdapter() = AttachmentAdapter()

    override fun initRefreshLayout(refreshLayout: KLRefreshLayout?) {
        val manager = GridLayoutManager(context, 4)
        refreshLayout?.setLayoutManager(manager)
        refreshLayout?.setEnableLoadMore(true)
        refreshLayout?.recyclerView?.addItemDecoration(VerticalItemDecoration(8))
    }

    var notiItem: NoticeItem? = null
    var todoItem: TodoItem? = null
    var type = ""
    var fromCode = ""
    override fun initData() {

        toolbar.setTitle("附件")
        toolbar.setLeftClick(View.OnClickListener
        {
            pop()
        })
        type = getParameter(0) as String
        LogShow.i("Reportragment.kt  initData type", type)
        when (type) {
            "notic" -> {
                notiItem = getParameter(1) as NoticeItem?
            }
            "todo" -> {
                todoItem = getParameter(1) as TodoItem?
                fromCode = getParameter(2) as String
                LogShow.i("Reportragment.kt  initData", todoItem.toString(), fromCode)
            }
        }

        mAdapter.setOnItemClickListener { view, data, position ->
            LogShow.i("NoticeListFragment.kt  initData", data.toString())
            openAttachment(ApiService.FILE_URL + data.realPath)
        }
    }

    private fun openAttachment(url: String) {
        if (isSupport(url)) {
            start(FragmentHelper.newInstance(WebViewFragment::class.java, url))
        } else {
            val intent = Intent()
            intent.action = "android.intent.action.VIEW"
            val content_url = Uri.parse(url)
            intent.data = content_url
            startActivity(intent)
        }

    }

    private fun isSupport(url: String) = url.endsWith("jpg") || url.endsWith("png") || url.endsWith("txt")

    override fun onQueryAttachment(attachment: MutableList<Attachment>?) {
        LogShow.i(" onQuery  ", attachment?.size, mAdapter);
        var list = mutableListOf<Attachment>()

        attachment?.forEachIndexed { index, attachment ->
            attachment.type = "attachment"
            list.add(attachment)
        }

        refreshLayout?.postDelayed({
            mAdapter?.data = list
            refreshLayout?.finishLoad()
            refreshLayout?.setMultiStateView(if (mAdapter.dataCount == 0) MultiStateView.VIEW_STATE_EMPTY else MultiStateView.VIEW_STATE_CONTENT)
        }, 500)
    }


    override fun onQueryTodoAttachments(attachment: MutableList<TodoAttachment>?) {
        var list = mutableListOf<Attachment>()
        attachment?.forEach { parent ->
            var bean = Attachment()
            bean.type = "name"
            bean.remark = parent.gropname
            list.add(bean)
            list.addAll(createHoldeBeanList(3))
            parent.list.forEachIndexed { index, listBean ->
                var bean = Attachment()
                bean.fileName = listBean.name
                bean.fileSuffix = "." + listBean.path.substringAfterLast(".")
                bean.realPath = listBean.path
                bean.type = "attachment"
                list.add(bean)
                LogShow.i("Reportragment.kt  onQueryTodoAttachments foreach", listBean.toString(), listBean.path.substringAfterLast("."))
            }
            var holderCount = 4 - if (parent.list.size == 0) 4 else parent.list.size % 4
            list.addAll(createHoldeBeanList(holderCount))
            LogShow.i("Reportragment.kt  onQueryTodoAttachments", list.size)
        }
        refreshLayout?.postDelayed({
            mAdapter?.data = list
            refreshLayout?.finishLoad()
            refreshLayout?.setMultiStateView(if (mAdapter.dataCount == 0) MultiStateView.VIEW_STATE_EMPTY else MultiStateView.VIEW_STATE_CONTENT)
        }, 500)
    }

    private fun createHoldeBeanList(count: Int): MutableList<Attachment> {
        LogShow.i("Reportragment.kt  createHoldeBeanList begim", count)
        var list = mutableListOf<Attachment>()
        for (i in 0 until count) {
            var bean = Attachment()
            bean.type = "holder"
            list.add(bean)
        }
        LogShow.i("Reportragment.kt  createHoldeBeanList", list.size)
        return list
    }

    override fun loadData(page: Int) {
        LogShow.i("Reportragment.kt  loadData", type)
        when (type) {
            "notic" -> {
                mPresenter.queryNoticeATtachment(notiItem?.id.toString())
            }
            "todo" -> {
                mPresenter.queryAttachments(todoItem, fromCode)
            }
        }


    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
        refresh()
    }


    override fun getLayoutId() = R.layout.fragment_noticelist
}

class AttachmentPresenter : BasePresenterImpl<AttachmentView>() {
    private var mDisposable: Disposable? = null
    fun queryNoticeATtachment(id: String?) {
        LogShow.i("queryClient ", id)
        id?.let {
            mDisposable = Api.getApiService().getNoticeAttachments(id).subscribeWith(object : BaseResultObserver<BaseResult<MutableList<Attachment>>>() {
                override fun onResult(loginBeae: BaseResult<MutableList<Attachment>>?) {

                    mView.onQueryAttachment(loginBeae?.result)
                }

                override fun onFailure(e: Throwable, error: String) {
                    ToastUtil.show(error)
                }
            })
        }
    }

    fun queryAttachments(todoItem: TodoItem?, code: String) {
        LogShow.i("Reportragment.kt  queryAttachments", code)
        mDisposable = Api.getApiService().getAttachments(todoItem?.formGroupCode, code, todoItem?.masterId).subscribeWith(object : BaseResultObserver<BaseResult<MutableList<TodoAttachment>>>() {
            override fun onResult(todoBean: BaseResult<MutableList<TodoAttachment>>?) {
                LogShow.i("queryAttachments   ", todoBean?.result)
                mView.onQueryTodoAttachments(todoBean?.result)
            }

            override fun onFailure(e: Throwable, error: String) {
                ToastUtil.show(error)
            }
        })
    }
}

interface AttachmentView : BaseView2 {
    fun onQueryAttachment(attachment: MutableList<Attachment>?)

    fun onQueryTodoAttachments(attachment: MutableList<TodoAttachment>?)
}

