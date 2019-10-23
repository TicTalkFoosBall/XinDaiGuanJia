package com.longer.creditManager.notice
import com.longer.creditManager.systemmsg.SystemMsgModel
import hxz.www.commonbase.baseui.mvp.BaseView2


/**
@Author  :rickBei
@Date    :2019/8/9 16:10
@Descripe: From bug to bugs
 **/
class SystemMsgContract {
    interface View : BaseView2 {
        fun onQueryBlackList(list: SystemMsgModel?)
    }


}