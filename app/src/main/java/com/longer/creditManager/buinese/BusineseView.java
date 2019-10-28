package com.longer.creditManager.buinese;

import hxz.www.commonbase.base.mvp.IBaseView;
import hxz.www.commonbase.model.todo.buinese.BusineseTab;

/**
 * @Author :rickBei
 * @Date :2019/10/28 20:07
 * @Descripe: From bug to bugs
 **/
public interface BusineseView extends IBaseView {
    void onQueryBusineseTab(BusineseTab tab);
}
