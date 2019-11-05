package com.longer.creditManager.buinese.detail

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.longer.creditManager.basemodel.Api
import hxz.www.commonbase.model.todo.TodoItem
import hxz.www.commonbase.model.todo.buinese.BusineseDetailBean
import hxz.www.commonbase.net.BaseResult
import hxz.www.commonbase.net.BaseResultObserver
import hxz.www.commonbase.uibase.mvp.BasePresenterImpl
import hxz.www.commonbase.util.ToastUtil
import hxz.www.commonbase.util.log.LogShow
import substrBefore
import value


class TestPresenter : BasePresenterImpl<TestView>() {

    fun getBusineseDetail(code: String) {

        Api.getApiService().getStatisticsDetail(code).subscribeWith(object : BaseResultObserver<BaseResult<JsonObject>>() {
            override fun onResult(json: BaseResult<JsonObject>) {

                mView.onQuery(processData(json.result.toString()))
            }

            override fun onFailure(e: Throwable, error: String) {
                ToastUtil.show(error)
            }
        })
    }


    fun queryRepay(todoItem: TodoItem?) {
        Api.getApiService().getRepaymentPlan(todoItem?.masterId).subscribeWith(object : BaseResultObserver<BaseResult<JsonArray>>() {
            override fun onResult(json: BaseResult<JsonArray>) {
                var json: String = json.result[0].toString()
                LogShow.i("queryRepay   ", json)

                mView.onQuery(processData(json.substringAfter("\"repaymentPlan\":")), json.substringAfter("{\"name\":\"").substrBefore(",\"repaymentPlan"))
            }

            override fun onFailure(e: Throwable, error: String) {
                ToastUtil.show(error)
            }
        })
    }

    private fun processData(json: String): BusineseDetailBean {
         LogShow.i("TestPresenter.kt  processData",json)
        var bean = BusineseDetailBean()
        var titleOriStr = json.substringAfter("title\":[{")
        var titleStr = titleOriStr.substrBefore("}],\"data")
        var dataStr = json.substringAfter("\"data\":[{\"")
        var dataOriList = dataStr.split("},{")//data每一层集合

        bean.title = titleStr
        var dataList = mutableListOf<String>()//data每一层里面每一个keyvalue集合
        var dataMapList = mutableListOf<MutableMap<String, String>>()//每一层里面data的keyvalue map
        dataOriList.forEach {
            var list = it.split(",")
            LogShow.i("getBusineseDetail  dataList  forEach", it, dataOriList.size, list.size);
            list?.let {
                var dataMap = mutableMapOf<String, String>()
                it.forEach {
                    var key = it.substringBefore(":").value()
                    var value = it.substringAfter(":").value()
                    LogShow.i("getBusineseDetail map  ", key + ":::" + value);
                    if (value.contains("}]}")) {
                        value = value.substringBefore("}]}")
                    }
                    dataMap.put(key, value)
                }
                dataMapList.add(dataMap)
            }
        }

        LogShow.i("getBusineseDetail   dataList", dataMapList.size, dataMapList[0].size);


        LogShow.i("getBusineseDetail   json", dataList.size);
        bean.data = dataMapList
        return bean;
    }
}