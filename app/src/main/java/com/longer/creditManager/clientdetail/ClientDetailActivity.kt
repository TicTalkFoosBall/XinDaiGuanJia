package com.longer.creditManager.clientdetail

import android.os.Bundle
import com.longer.creditManager.R
import com.longer.creditManager.notice.ClientDetailView
import hxz.www.commonbase.baseui.BaseActivity2

class ClientDetailActivity: BaseActivity2<ClientDetailPresenter>(),ClientDetailView
{
    override fun showError(reqCode: Int, msg: String?) {

    }

    override fun getLayoutId()= R.layout.activity_customerinformation

    override fun initEventAndData(savedInstanceState: Bundle?) {
    }

}