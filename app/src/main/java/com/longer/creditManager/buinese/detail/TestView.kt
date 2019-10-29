package com.longer.creditManager.buinese.detail
import hxz.www.commonbase.baseui.mvp.BaseView2
import hxz.www.commonbase.model.todo.buinese.BusineseDetailBean

/**
@Author  :rickBei
@Date    :2019/10/29 14:44
@Descripe: From bug to bugs
 **/
interface TestView : BaseView2 {
    fun onQuery(detail: BusineseDetailBean)
}