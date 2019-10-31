package com.longer.creditManager.notice
import hxz.www.commonbase.model.SystemMsgModel
import hxz.www.commonbase.baseui.mvp.BaseView2


class SystemMsgContract {
    interface View : BaseView2 {
        fun onQueryBlackList(list: SystemMsgModel?)
    }


}