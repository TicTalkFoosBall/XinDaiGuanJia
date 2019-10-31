package com.longer.creditManager.notice
import hxz.www.commonbase.model.client.ClientModel
import hxz.www.commonbase.baseui.mvp.BaseView2


/**
@Author  :rickBei
@Date    :2019/8/9 16:10
@Descripe: From bug to bugs
 **/
class ClientContract {
    interface View : BaseView2 {
        fun queryClient(list: MutableList<ClientModel>?)
    }

}