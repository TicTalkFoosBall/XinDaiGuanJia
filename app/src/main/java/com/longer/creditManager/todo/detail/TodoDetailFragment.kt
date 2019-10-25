package com.longer.creditManager.todo.detail

import android.content.Intent
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
import com.longer.creditManager.R
import com.longer.creditManager.activity.ExaminationActivity
import com.longer.creditManager.basemodel.Api
import com.longer.creditManager.fragment.BaseListFragment
import hxz.www.commonbase.adapter.VerticalItemDecoration
import hxz.www.commonbase.baseui.mvp.BaseView2
import hxz.www.commonbase.model.TodoItem
import hxz.www.commonbase.model.todo.FieldListBean
import hxz.www.commonbase.model.todo.TodoDetailItem
import hxz.www.commonbase.net.BaseResult
import hxz.www.commonbase.net.BaseResultObserver
import hxz.www.commonbase.state.MultiStateView
import hxz.www.commonbase.uibase.mvp.BasePresenterImpl
import hxz.www.commonbase.util.ToastUtil
import hxz.www.commonbase.util.log.LogShow
import hxz.www.commonbase.view.KLRefreshLayout
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_noticelist.*
import value


class TodoDetailFragment : BaseListFragment<TodoDetailPresenter, TodoDetailAdapter>(), TodoDetailView {

    override fun bindAdapter() = TodoDetailAdapter()

    override fun initRefreshLayout(refreshLayout: KLRefreshLayout?) {
        LogShow.i("initRefreshLayout  ", refreshLayout);
        refreshLayout?.setLayoutManager(LinearLayoutManager(_mActivity))
        refreshLayout?.setEnableLoadMore(true)
        refreshLayout?.recyclerView?.addItemDecoration(VerticalItemDecoration(8))
    }

    var taskId = ""
    var procInstId = ""
    var todoItem: TodoItem? = null
    override fun initData() {
        todoItem = getParameter(0) as TodoItem?
        taskId = todoItem?.taskId.value()
        procInstId = todoItem?.masterId.value()
        refreshLayout?.recyclerView?.let {

        }
//        iv_back_notice.click {
//            _mActivity.finish()
//        }
        mAdapter.setOnItemClickListener { view, data, position ->
            startActivity(Intent(_mActivity, ExaminationActivity::class.java))
        }
        toolbar.setLeftClick(View.OnClickListener
        {
            _mActivity.finish()
        }).setRightImage(R.mipmap.more)
                .setRightClick(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        initPopupWindow()
                    }

                })
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
        //        view.findViewById(R.id.iv_4).setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //                lighton();
        //                Toast.makeText(ExaminationActivity.this, "4", Toast.LENGTH_SHORT).show();
        //            }
        //        });
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
        LogShow.i("onLazyInitView ", "");
        refresh()
    }


    override fun onQuery(list: MutableList<FieldListBean>?) {
        LogShow.i(" onQuery  ", list?.size, mAdapter);
        refreshLayout?.postDelayed({
            var filterList = list?.filterNot {
                LogShow.i("TodoDetailFragment.kt  onQuery", it.fieldNote, it.fieldNote.contains("隐藏"))
                it.fieldNote.contains("隐藏")
            }

            mAdapter?.data = filterList
            refreshLayout?.finishLoad()
            refreshLayout?.setMultiStateView(if (mAdapter.dataCount == 0) MultiStateView.VIEW_STATE_EMPTY else MultiStateView.VIEW_STATE_CONTENT)
        }, 500)
    }

    override fun getLayoutId() = R.layout.fragment_noticelist
}

class TodoDetailPresenter : BasePresenterImpl<TodoDetailView>() {
    private var mDisposable: Disposable? = null
    fun queryTodoDetail(taskId: String, procInstId: String) {
        LogShow.i("queryodoList ", taskId, procInstId)
        mDisposable = Api.getApiService().getTodoDetail(taskId, procInstId).subscribeWith(object : BaseResultObserver<BaseResult<TodoDetailItem>>() {
            override fun onResult(todoBean: BaseResult<TodoDetailItem>?) {
                LogShow.i("queryodoList   ", todoBean?.result?.fieldList?.size);
                mView.onQuery(todoBean?.result?.fieldList)
            }

            override fun onFailure(e: Throwable, error: String) {
                ToastUtil.show(error)
            }
        })
    }

    fun queryAttachments(todoItem: TodoItem) {
        var params= mutableMapOf<String,String>().apply {    this["masterId"] = todoItem.masterId
            this["formGroupCode"] = todoItem.formGroupCode
            this["formCode"] = todoItem.type
        }
        LogShow.i("queryAttachments ",todoItem.toString())

        mDisposable = Api.getApiService().getAttachments(params).subscribeWith(object : BaseResultObserver<BaseResult<TodoDetailItem>>() {
            override fun onResult(todoBean: BaseResult<TodoDetailItem>?) {
                LogShow.i("queryodoList   ", todoBean?.result?.fieldList?.size);
                mView.onQuery(todoBean?.result?.fieldList)
            }

            override fun onFailure(e: Throwable, error: String) {
                ToastUtil.show(error)
            }
        })
    }
}

interface TodoDetailView : BaseView2 {

    fun onQuery(list: MutableList<FieldListBean>?)
}

