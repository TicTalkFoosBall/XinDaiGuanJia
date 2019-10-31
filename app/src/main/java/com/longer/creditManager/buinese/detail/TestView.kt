package com.longer.creditManager.buinese.detail
import hxz.www.commonbase.baseui.mvp.BaseView2
import hxz.www.commonbase.model.todo.buinese.BusineseDetailBean


interface TestView : BaseView2 {
    fun onQuery(detail: BusineseDetailBean)
}