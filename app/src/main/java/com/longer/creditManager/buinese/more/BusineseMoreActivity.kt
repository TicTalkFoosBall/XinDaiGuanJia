package com.longer.creditManager.buinese.more

import android.os.Bundle
import com.longer.creditManager.R
import hxz.www.commonbase.baseui.BaseActivity2
import hxz.www.commonbase.model.todo.buinese.OtherListBeanSeri
import hxz.www.commonbase.util.fragment.FragmentHelper
import hxz.www.commonbase.util.log.LogShow


class BusineseMoreActivity : BaseActivity2<Nothing>()
{
    override fun getLayoutId()=R.layout.activity_container

    override fun initEventAndData(savedInstanceState: Bundle?) {
        var otherBeans:OtherListBeanSeri= intent.getSerializableExtra("otherList") as OtherListBeanSeri

         LogShow.i("BusineseMoreActivity.kt  initEventAndData",otherBeans.otherListBeans.size)
        loadRootFragment(R.id.fl_container,  FragmentHelper.newInstance(BusineseMoreFragment::class.java,otherBeans))

    }

    override fun showError(reqCode: Int, msg: String?) {

    }

}