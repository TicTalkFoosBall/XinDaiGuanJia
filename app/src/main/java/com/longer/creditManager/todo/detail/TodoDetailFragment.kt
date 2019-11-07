package com.longer.creditManager.todo.detail

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import click
import com.longer.creditManager.R
import com.longer.creditManager.basemodel.Api
import com.longer.creditManager.buinese.BaseListFragment
import com.longer.creditManager.buinese.detail.BusinessDetailFragment
import com.longer.creditManager.dialog.ExaminationDialog
import com.longer.creditManager.dialog.OptionDialogListener
import com.longer.creditManager.recording.AttachmentFragment
import com.longer.creditManager.recording.RecordListFragment
import com.longer.creditManager.recording.ReportFragment
import com.longer.creditManager.todo.RefreshTodoEvent
import hxz.www.commonbase.adapter.VerticalItemDecoration
import hxz.www.commonbase.baseui.mvp.BaseView2
import hxz.www.commonbase.model.PopModel
import hxz.www.commonbase.model.todo.TodoItem
import hxz.www.commonbase.model.todo.TodoMoreMenuModel
import hxz.www.commonbase.model.todo.detail.Approval
import hxz.www.commonbase.model.todo.detail.ApprovalResultListBean
import hxz.www.commonbase.model.todo.detail.TaskHistoryInfoBean
import hxz.www.commonbase.model.todo.detail.TodoDetailItem
import hxz.www.commonbase.net.BaseResult
import hxz.www.commonbase.net.BaseResultObserver
import hxz.www.commonbase.state.MultiStateView
import hxz.www.commonbase.uibase.mvp.BasePresenterImpl
import hxz.www.commonbase.util.ToastUtil
import hxz.www.commonbase.util.fragment.FragmentHelper
import hxz.www.commonbase.util.log.LogShow
import hxz.www.commonbase.view.KLRefreshLayout
import hxz.www.commonbase.view.dialog.BottomRecyclerGridViewDialog
import hxz.www.commonbase.view.dialog.BottomRecyclerViewDialog
import hxz.www.commonbase.view.dialog.OnBottomRecyclerGridViewListener
import hxz.www.commonbase.view.dialog.OnBottomRecyclerViewListener
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_noticelist.toolbar
import kotlinx.android.synthetic.main.fragment_tododetaillist.*
import org.greenrobot.eventbus.EventBus
import toast
import value


class TodoDetailFragment : BaseListFragment<TodoDetailPresenter, TodoDetailAdapter>(), TodoDetailView {

    private var footerView: View? = null
    override fun bindAdapter() = TodoDetailAdapter()

    override fun initRefreshLayout(refreshLayout: KLRefreshLayout?) {
        refreshLayout?.setLayoutManager(LinearLayoutManager(_mActivity))
        refreshLayout?.setEnableLoadMore(true)
        refreshLayout?.recyclerView?.addItemDecoration(VerticalItemDecoration(8))

        footerView = LayoutInflater.from(context).inflate(R.layout.layout_footer_record, null)
        mAdapter.addFooterView(footerView)
        footerView?.click {
            start(FragmentHelper.newInstance(RecordListFragment::class.java, history))
        }
    }

    var taskId = ""
    var procInstId = ""
    var todoItem: TodoItem? = null
    var history: TaskHistoryInfoBean? = null
    var apprList: MutableList<ApprovalResultListBean>? = null
    override fun initData() {
        todoItem = getParameter(0) as TodoItem?
        taskId = todoItem?.taskId.value()
        procInstId = todoItem?.procInstId.value()
        commitbean.taskId = taskId
        commitbean.processInstanceId = procInstId
        commitbean.masterId = todoItem?.masterId

        toolbar.setTitle("待办详情")
        toolbar.setLeftClick(View.OnClickListener
        {
            _mActivity.finish()
        }).setRightImage(R.mipmap.more)
                .setRightClick(View.OnClickListener {
                    mPresenter.queryMore(todoItem?.formGroupCode.value())
                })


        bt_examine.click {
            LogShow.i("TodoDetailFragment.kt  initData", todoItem?.canAppTodoable)
            if (todoItem?.canAppTodoable ?: false) {
                var modelList = mutableListOf<PopModel>()
                apprList?.forEach { it ->
                    modelList.add(PopModel(it.desc))
                    LogShow.i("TodoDetailFragment.kt  initData", it.toString())
                }
                commitDialog = ExaminationDialog(context)
                commitDialog?.setListener(object : OptionDialogListener {
                    override fun onCommit(content: String) {
                        if (commitbean.result.desc.isNullOrEmpty()) {
                            ToastUtil.show("请选择审批结果")
                        } else {
                            commitbean.comment = content
                            mPresenter.commitApproval(commitbean)
                        }

                    }

                    override fun onResultChoose() {
                        optionUpDialog(modelList)
                    }

                })
                commitDialog?.show()
            } else {
                "请在Pc端审核".toast()
            }

        }

    }

    var commitDialog: ExaminationDialog? = null
    var commitbean: Approval = Approval()
    var bottomRecyclerViewDialog: BottomRecyclerViewDialog? = null
    private fun optionUpDialog(modelList: MutableList<PopModel>) {
        if (bottomRecyclerViewDialog == null) {
            bottomRecyclerViewDialog = BottomRecyclerViewDialog(_mActivity, modelList)
                    .title("请选择审批结果")
                    .listener(object : OnBottomRecyclerViewListener {
                        override fun onContentClickAction(position: Int, data: PopModel, dialog: BottomRecyclerViewDialog) {
                            var approv = apprList?.get(position)
                            commitbean.result?.code = approv?.code
                            commitbean.result?.desc = approv?.desc
                            commitDialog?.setResult(approv?.desc)
                            dialog.dismiss()
                        }
                    })
        }
        bottomRecyclerViewDialog?.show()
    }


    var menuDialog: BottomRecyclerGridViewDialog? = null
    private fun showMenuDialog(modelList: MutableList<PopModel>) {
        if (menuDialog == null) {
            menuDialog = BottomRecyclerGridViewDialog(_mActivity, modelList)
                    .title("")
                    .listener(object : OnBottomRecyclerGridViewListener {
                        override fun onContentClickAction(position: Int, data: PopModel, dialog: BottomRecyclerGridViewDialog) {
                            if (data.text.contains("附件")) {
                                start(FragmentHelper.newInstance(AttachmentFragment::class.java, "todo", todoItem, data.extend))
                            } else if (data.text.contains("还款")) {
                                start(FragmentHelper.newInstance(BusinessDetailFragment::class.java, "repay", "还款计划", todoItem))
                            } else if (data.text.contains("报告")) {
                                start(FragmentHelper.newInstance(ReportFragment::class.java, data.text, todoItem, data.extend))
                            }
                            dialog.dismiss()
                        }
                    })
        }
        menuDialog?.show()
    }


    /**
     * 设置手机屏幕亮度显示正常
     */
    private fun lighton() {
        val lp = _mActivity.getWindow().getAttributes()
        lp.alpha = 1f
        _mActivity.getWindow().setAttributes(lp)
    }

    override fun loadData(page: Int) {
        mPresenter.queryTodoDetail(taskId, procInstId)
    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
        refresh()
    }

    override fun onQueryRepay(json: String) {

    }

    var moreList: MutableList<TodoMoreMenuModel>? = null
    override fun onQueryMore(list: MutableList<TodoMoreMenuModel>?) {
        var moreList = mutableListOf<PopModel>()
        list?.forEach { it ->
            LogShow.i("TodoDetailFragment.kt  initData", it.toString())
            moreList.add(PopModel(text = it.name, imgUrl = it.icon, extend = it.code))
        }

        showMenuDialog(moreList)
    }


    override fun onCommitApproal(isSUccess: Boolean) {
        commitDialog?.dismiss()
        ToastUtil.show("审批成功")
        EventBus.getDefault().post(RefreshTodoEvent())
        _mActivity.finish()
    }

    override fun onQueryDetail(detailBean: TodoDetailItem?) {
        detailBean?.let {
            apprList = it.taskInitInfo?.data?.extendInfo?.approvalResultList
            history = it.taskHistoryInfo
        }
        refreshLayout?.postDelayed({
            mAdapter.addFooterView(footerView)
            var filterList = detailBean?.fieldList?.filterNot {
                it.fieldNote.contains("隐藏") || it.fieldNote.contains("占位") || it.controlType.contains("21") || it.controlType.contains("13") || it.controlType.contains("6")
            }
            LogShow.i("TodoDetailFragment.kt  onQueryDetail", filterList?.size, detailBean?.fieldList?.size)

            mAdapter?.data = filterList
            refreshLayout?.finishLoad()
            refreshLayout?.setMultiStateView(if (mAdapter.dataCount == 0) MultiStateView.VIEW_STATE_EMPTY else MultiStateView.VIEW_STATE_CONTENT)
        }, 500)
//        if (detailBean?.fieldList.isNullOrEmpty()) {
//            footerView.isVisible = false
//        }
    }


    override fun getLayoutId() = R.layout.fragment_tododetaillist
}

class TodoDetailPresenter : BasePresenterImpl<TodoDetailView>() {
    private var mDisposable: Disposable? = null
    fun queryTodoDetail(taskId: String, procInstId: String) {
        mDisposable = Api.getApiService().getTodoDetail(taskId, procInstId).subscribeWith(object : BaseResultObserver<BaseResult<TodoDetailItem>>() {
            override fun onResult(todoBean: BaseResult<TodoDetailItem>?) {
                mView.onQueryDetail(todoBean?.result)
            }

            override fun onFailure(e: Throwable, error: String) {
                mView.onQueryDetail(null)
                ToastUtil.show(error)
            }
        })
    }


    fun queryMore(fromGroupcode: String) {
        LogShow.i("queryMore   ", fromGroupcode);
        mDisposable = Api.getApiService().getMoreMenu(fromGroupcode).subscribeWith(object : BaseResultObserver<BaseResult<MutableList<TodoMoreMenuModel>>>() {
            override fun onResult(todoBean: BaseResult<MutableList<TodoMoreMenuModel>>?) {
                mView.onQueryMore(todoBean?.result)
            }

            override fun onFailure(e: Throwable, error: String) {
                ToastUtil.show(error)
            }
        })
    }


    fun commitApproval(approval: Approval?) {
        LogShow.i("commitApproval   ", approval.toString())
        approval?.let {
            mDisposable = Api.getApiService().commitApproval(approval).subscribeWith(object : BaseResultObserver<BaseResult<TodoDetailItem>>() {
                override fun onResult(todoBean: BaseResult<TodoDetailItem>?) {
                    mView.onCommitApproal(true)

                }

                override fun onFailure(e: Throwable, error: String) {
                }
            })
        }

    }


}

interface TodoDetailView : BaseView2 {

    fun onQueryMore(list: MutableList<TodoMoreMenuModel>?)

    fun onCommitApproal(isSUccess: Boolean)

    fun onQueryDetail(detailBean: TodoDetailItem?)

    fun onQueryRepay(json: String)

}

