package com.longer.creditManager.clientdetail

import android.os.Bundle
import android.view.View
import com.longer.creditManager.R
import com.longer.creditManager.notice.ClientDetailView
import hxz.www.commonbase.baseui.BaseActivity2
import hxz.www.commonbase.model.client.ClientDetail
import hxz.www.commonbase.model.client.ClientModel
import hxz.www.commonbase.util.log.LogShow
import kotlinx.android.synthetic.main.activity_customerinformation.*
import kotlinx.android.synthetic.main.fragment_noticelist.toolbar
import value

class ClientDetailActivity: BaseActivity2<ClientDetailPresenter>(),ClientDetailView
{
    var model: ClientModel?=null
    override fun onQueryClient(mode: ClientDetail?) {
         mode?.let {
             updateClient(it)
         }
    }

    override fun showError(reqCode: Int, msg: String?) {

    }

    override fun getLayoutId()= R.layout.activity_customerinformation

    override fun initEventAndData(savedInstanceState: Bundle?) {
        model = intent.extras.getBundle("params").getSerializable("client") as ClientModel
         LogShow.i("ClientDetailActivity   ",model.toString());
        toolbar.setLeftClick(View.OnClickListener
        {
            finish()
        })
        mPresenter.getClientPerson(model?.id.value())
    }

    private fun updateClient(detailModel:ClientDetail)
    {
        tv_phoneNumber.text=model?.mobile?:"-"
        tv_name.text=detailModel.name?:"-"
          tv_idNumber.text=""+detailModel.idCard?:"-"
        tv_name.text=detailModel.name?:"-"
        tv_sex.text=detailModel.gender?:"-"
        tv_location.text=detailModel.address?:"-"
        tv_marry.text=detailModel.marriageStatus?:"-"
        tv_manager.text=detailModel.manager?:"-"
    }
}