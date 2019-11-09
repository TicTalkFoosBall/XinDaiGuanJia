
package com.longer.creditManager.basemodel;


import hxz.www.commonbase.net.constant.ApiService;
import hxz.www.commonbase.net.HttpManger;

import hxz.www.commonbase.base.mvp.IBaseModel;

public abstract class Api implements IBaseModel {

    private volatile static ApiService apiService;
    private volatile static ApiService oriApiService;

    public static ApiService getApiService() {
        if (apiService == null) {
            apiService = HttpManger.getInstance().getApiService(ApiService.class);
        }
        return apiService;
    }

    public static ApiService getOriApiService() {
        if (oriApiService == null) {
            oriApiService = HttpManger.getInstance().getoriApiService(ApiService.class);
        }
        return oriApiService;
    }


}
