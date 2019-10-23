package com.longer.creditManager.notice

import android.os.Bundle
import com.longer.creditManager.R
import hxz.www.commonbase.baseui.BaseActivity2
import hxz.www.commonbase.util.fragment.FragmentHelper
import hxz.www.commonbase.util.log.LogShow

class SystemMsgActivity : BaseActivity2<Nothing>()
{
    override fun getLayoutId()=R.layout.activity_container

    override fun initEventAndData(savedInstanceState: Bundle?) {
        loadRootFragment(R.id.fl_container,  FragmentHelper.newInstance(SystemMsgFragment::class.java))
    }

    override fun showError(reqCode: Int, msg: String?) {

    }

}