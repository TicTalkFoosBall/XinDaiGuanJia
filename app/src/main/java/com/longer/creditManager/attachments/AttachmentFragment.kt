package com.longer.creditManager.recording

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
    override fun initData() {
        refreshLayout?.recyclerView?.let {
        }
        notiItem = getParameter(0) as NoticeItem?
        toolbar.setTitle("附件")
        toolbar.setLeftClick(View.OnClickListener
        {
            pop()
        })

        mAdapter.setOnItemClickListener { view, data, position ->
            LogShow.i("NoticeListFragment.kt  initData", data.toString())
            start(FragmentHelper.newInstance(WebViewFragment::class.java,ApiService.FILE_URL+ data.realPath))
        }
    }

    override fun onQueryAttachment(attachment: MutableList<Attachment>?) {
        LogShow.i(" onQuery  ", attachment?.size, mAdapter);
        var list= mutableListOf<Attachment>()
//        attachment?.let {
//            list.addAll(attachment)
//        }
        attachment?.forEachIndexed { index, attachment ->
            if (index%2==0)
            {
                var att=Attachment()
                att.type="name"
                att.remark="哈哈哈"
                list.add(att)
                var att1=Attachment()
                att.type="holder"
                list.add(att1)
                var att2=Attachment()
                att.type="holder"
                list.add(att2)
                var att3=Attachment()
                att.type="holder"
                list.add(att3)
            }
            attachment.type="attachment"
            list.add(attachment)
        }

        refreshLayout?.postDelayed({
            mAdapter?.data = list
            refreshLayout?.finishLoad()
            refreshLayout?.setMultiStateView(if (mAdapter.dataCount == 0) MultiStateView.VIEW_STATE_EMPTY else MultiStateView.VIEW_STATE_CONTENT)
        }, 500)
    }

    override fun loadData(page: Int) {
        mPresenter.queryClient(notiItem?.id.toString())
    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
        refresh()
    }


    override fun getLayoutId() = R.layout.fragment_noticelist
}

class AttachmentPresenter : BasePresenterImpl<AttachmentView>() {
    private var mDisposable: Disposable? = null
    fun queryClient(id: String?) {
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
}

interface AttachmentView : BaseView2 {
    fun onQueryAttachment(attachment: MutableList<Attachment>?)

}

