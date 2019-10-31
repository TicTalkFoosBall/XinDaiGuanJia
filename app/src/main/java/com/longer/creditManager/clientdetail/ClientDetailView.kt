package com.longer.creditManager.notice
import hxz.www.commonbase.baseui.mvp.BaseView2
import hxz.www.commonbase.model.client.ClientDetail


/**
@Author  :rickBei
@Date    :2019/8/9 16:10
@Descripe: From bug to bugs
 **/
interface ClientDetailView  : BaseView2 {

fun onQueryClient(mode: ClientDetail?)
}