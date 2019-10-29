package com.longer.creditManager.buinese.detail

import android.os.Bundle
import com.longer.creditManager.R
import hxz.www.commonbase.baseui.BaseActivity2
import hxz.www.commonbase.util.fragment.FragmentHelper
import hxz.www.commonbase.util.log.LogShow


class BusineseDetailActivity : BaseActivity2<Nothing>()
{
    override fun getLayoutId()=R.layout.activity_container

    override fun initEventAndData(savedInstanceState: Bundle?) {
        var code=intent.getStringExtra("code")
         LogShow.i("BusineseDetailActivity.kt  initEventAndData",code)
        loadRootFragment(R.id.fl_container,  FragmentHelper.newInstance(BusinessDetailFragment::class.java,code))

    }

    override fun showError(reqCode: Int, msg: String?) {

    }

}