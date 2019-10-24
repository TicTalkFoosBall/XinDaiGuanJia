package com.longer.creditManager.todo.list

import android.os.Bundle
import com.longer.creditManager.R
import hxz.www.commonbase.baseui.BaseActivity2
import hxz.www.commonbase.util.fragment.FragmentHelper

class TodoActivity : BaseActivity2<Nothing>()
{
    override fun getLayoutId()=R.layout.activity_container

    override fun initEventAndData(savedInstanceState: Bundle?) {
        loadRootFragment(R.id.fl_container,  FragmentHelper.newInstance(TodoListFragment::class.java))
    }

    override fun showError(reqCode: Int, msg: String?) {

    }

}