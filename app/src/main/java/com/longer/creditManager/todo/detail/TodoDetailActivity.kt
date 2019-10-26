package com.longer.creditManager.todo.detail

import android.os.Bundle
import com.longer.creditManager.R
import hxz.www.commonbase.baseui.BaseActivity2
import hxz.www.commonbase.model.todo.TodoItem
import hxz.www.commonbase.util.fragment.FragmentHelper
import hxz.www.commonbase.util.log.LogShow

class TodoDetailActivity : BaseActivity2<Nothing>()
{
    override fun getLayoutId()=R.layout.activity_container

    override fun initEventAndData(savedInstanceState: Bundle?) {
        var params=intent.getBundleExtra("params")
//        var taskId=params.getString("taskId")
//        var procInstId=params.getString("procInstId")
        var item=params.getSerializable("todoItem")
         LogShow.i("TodoDetailActivity.kt  initEventAndData",item.toString(),item is TodoItem)
        loadRootFragment(R.id.fl_container,  FragmentHelper.newInstance(TodoDetailFragment::class.java,item))
    }

    override fun showError(reqCode: Int, msg: String?) {

    }

}