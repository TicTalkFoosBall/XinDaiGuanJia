package com.longer.creditManager.notice
import hxz.www.commonbase.baseui.mvp.BaseView2
import hxz.www.commonbase.model.NoticeListModel

class NoticeListContract {
    interface View : BaseView2 {
        fun onQueryBlackList(list: NoticeListModel?)
    }


}