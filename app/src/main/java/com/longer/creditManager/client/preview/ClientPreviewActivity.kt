package com.longer.creditManager.client.preview

import android.os.Bundle
import com.longer.creditManager.R
import com.longer.creditManager.notice.ClientPreviewFragment
import com.longer.creditManager.notice.NoticeListFragment
import hxz.www.commonbase.baseui.BaseActivity2
import hxz.www.commonbase.util.fragment.FragmentHelper

class ClientPreviewActivity : BaseActivity2<Nothing>()
{
    override fun getLayoutId()=R.layout.activity_container

    override fun initEventAndData(savedInstanceState: Bundle?) {

        loadRootFragment(R.id.fl_container,  FragmentHelper.newInstance(ClientPreviewFragment::class.java,intent.getStringExtra("params")))

    }

    override fun showError(reqCode: Int, msg: String?) {

    }

}