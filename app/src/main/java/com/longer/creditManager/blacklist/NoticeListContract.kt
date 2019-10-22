package com.longer.creditManager.blacklist
import hxz.www.commonbase.baseui.mvp.BasePresenter2
import hxz.www.commonbase.baseui.mvp.BaseView2


/**
@Author  :rickBei
@Date    :2019/8/9 16:10
@Descripe: From bug to bugs
 **/
class NoticeListContract {
    interface View : BaseView2 {
        fun onQueryBlackList(list: MutableList<NoticeListModel>?)
    }


}