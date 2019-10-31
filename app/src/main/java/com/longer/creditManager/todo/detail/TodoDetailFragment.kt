package com.longer.creditManager.todo.detail

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.PopupWindow
import click
import com.longer.creditManager.R
import com.longer.creditManager.basemodel.Api
import com.longer.creditManager.buinese.BaseListFragment
import com.longer.creditManager.dialog.ExaminationDialog
import com.longer.creditManager.dialog.OptionDialogListener
import com.longer.creditManager.recording.RecordListFragment
import com.longer.creditManager.todo.RefreshTodoEvent
import hxz.www.commonbase.adapter.VerticalItemDecoration
import hxz.www.commonbase.baseui.mvp.BaseView2
import hxz.www.commonbase.model.Attachment
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
import hxz.www.commonbase.view.dialog.BottomRecyclerViewDialog
import hxz.www.commonbase.view.dialog.OnBottomRecyclerViewListener
import io.reactivex.disposables.Disposable
import isVisible
import kotlinx.android.synthetic.main.fragment_noticelist.toolbar
import kotlinx.android.synthetic.main.fragment_tododetaillist.*
import org.greenrobot.eventbus.EventBus
import value


class TodoDetailFragment : BaseListFragment<TodoDetailPresenter, TodoDetailAdapter>(), TodoDetailView {


    override fun bindAdapter() = TodoDetailAdapter()

    override fun initRefreshLayout(refreshLayout: KLRefreshLayout?) {
        refreshLayout?.setLayoutManager(LinearLayoutManager(_mActivity))
        refreshLayout?.setEnableLoadMore(true)
        refreshLayout?.recyclerView?.addItemDecoration(VerticalItemDecoration(8))
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
        commitbean?.taskId = taskId
        commitbean?.processInstanceId = procInstId
        commitbean?.masterId = todoItem?.masterId

        refreshLayout?.recyclerView?.let {

        }

        mAdapter.setOnItemClickListener { view, data, position ->
            //            startActivity(Intent(_mActivity, ExaminationActivity::class.java))
        }
        var footerView = LayoutInflater.from(context).inflate(R.layout.layout_footer_record, null)
        footerView.click { ToastUtil.show("footer") }
        mAdapter.addFooterView(footerView)
        toolbar.setTitle("待办详情")
        toolbar.setLeftClick(View.OnClickListener
        {
            _mActivity.finish()
        }).setRightImage(R.mipmap.more)
                .setRightClick(View.OnClickListener { initPopupWindow() })
//        mPresenter.queryMore(todoItem?.formGroupCode.value())

        tv_recording.click {
            start(FragmentHelper.newInstance(RecordListFragment::class.java, history))
        }

        bt_examine.click {
            var modelList = mutableListOf<PopModel>()

            apprList?.forEach { it ->
                modelList.add(PopModel(it.desc))
                LogShow.i("TodoDetailFragment.kt  initData", it.toString())
            }
            commitDialog = ExaminationDialog(context)
            commitDialog?.setListener(object : OptionDialogListener {
                override fun onCommit(content: String) {
                    commitbean?.comment = content
                    mPresenter.commitApproval(commitbean)
                }

                override fun onResultChoose() {
                    LogShow.i("TodoDetailFragment.kt  onResultChoose")
                    optionUpDialog(modelList)
                }

            })
            commitDialog?.show()
        }
        mPresenter.queryMore(todoItem?.formGroupCode.value())
//        mPresenter.queryAttachments(null)
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
                            commitbean?.result?.code = approv?.code
                            commitbean?.result?.desc = approv?.desc
                            commitDialog?.setResult(approv?.desc)
                            dialog.dismiss()
                        }
                    })
        }
        bottomRecyclerViewDialog?.show()
    }

    // 弹出PopupWindow
    private fun initPopupWindow() {
        val view = LayoutInflater.from(context).inflate(R.layout.popuwindow, null, false)
        var popupWindow = PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, true)
        popupWindow.setBackgroundDrawable(BitmapDrawable())
        popupWindow.setFocusable(true)
        popupWindow.setOutsideTouchable(true)
        lighton()
        var animation = TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 1f, Animation.RELATIVE_TO_PARENT, 0f)
        animation.setInterpolator(AccelerateInterpolator())
        animation.setDuration(200)
        popupWindow.showAtLocation(view, Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 0)
        view.startAnimation(animation)

        popupWindow.setOnDismissListener(PopupWindow.OnDismissListener { lighton() })

        PopupWindowOnClick(view)
    }


    private fun PopupWindowOnClick(view: View) {
        view.findViewById<View>(R.id.iv_1).setOnClickListener {
            lighton()

        }
        view.findViewById<View>(R.id.iv_2).setOnClickListener {
            lighton()
        }
        view.findViewById<View>(R.id.iv_3).setOnClickListener {
            lighton()
        }

        view.findViewById<View>(R.id.iv_5).setOnClickListener {
            lighton()
        }

        view.findViewById<View>(R.id.iv_6).setOnClickListener {
            lighton()
        }
        view.findViewById<View>(R.id.iv_7).setOnClickListener {
            lighton()
        }
        view.findViewById<View>(R.id.iv_8).setOnClickListener {
            lighton()
        }

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
        LogShow.i("onLazyInitView ", "")
        refresh()
    }


    override fun onQueryMore(list: MutableList<TodoMoreMenuModel>?) {

        list?.forEach {   LogShow.i("onQueryMore  ", it.name)  }
        list?.let {
            mPresenter.queryAttachments(todoItem, it[0]?.code.value())
        }


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
            var filterList = detailBean?.fieldList?.filterNot {
                it.fieldNote.contains("隐藏") || it.fieldNote.contains("占位") || it.controlType.contains("21") || it.controlType.contains("13")
            }

            mAdapter?.data = filterList
            refreshLayout?.finishLoad()
            refreshLayout?.setMultiStateView(if (mAdapter.dataCount == 0) MultiStateView.VIEW_STATE_EMPTY else MultiStateView.VIEW_STATE_CONTENT)
        }, 500)
        if (detailBean?.fieldList.isNullOrEmpty()) {
            tv_recording.isVisible = false
        }
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

    fun queryAttachments(todoItem: TodoItem?, code: String) {
        LogShow.i("TodoDetailFragment.kt  queryAttachments", code)
        mDisposable = Api.getApiService().getAttachments(todoItem?.formGroupCode, code, todoItem?.masterId).subscribeWith(object : BaseResultObserver<BaseResult<List<Attachment>>>() {
            override fun onResult(todoBean: BaseResult<List<Attachment>>?) {
                LogShow.i("queryAttachments   ", todoBean?.result)
            }

            override fun onFailure(e: Throwable, error: String) {
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
                    ToastUtil.show(error)
                }
            })
        }

    }
}

interface TodoDetailView : BaseView2 {

    fun onQueryMore(list: MutableList<TodoMoreMenuModel>?)

    fun onCommitApproal(isSUccess: Boolean)

    fun onQueryDetail(detailBean: TodoDetailItem?)

}

