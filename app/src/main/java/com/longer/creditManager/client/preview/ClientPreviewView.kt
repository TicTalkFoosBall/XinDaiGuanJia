package com.longer.creditManager.client.preview

import hxz.www.commonbase.baseui.mvp.BaseView2
import hxz.www.commonbase.model.ClientPreviewModel

/**
@Author  :rickBei
@Date    :2019/10/31 9:55
@Descripe: From bug to bugs
 **/
interface ClientPreviewView :BaseView2{
fun  onQueryPreview(list: MutableList<ClientPreviewModel>?)
}