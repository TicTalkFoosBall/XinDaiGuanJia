
package com.longer.creditManager.basemodel;


import hxz.www.commonbase.net.constant.ApiService;
import hxz.www.commonbase.net.HttpManger;

import hxz.www.commonbase.base.mvp.IBaseModel;

public abstract class Api implements IBaseModel{

  private   volatile static ApiService apiService;

    public static  ApiService getApiService(){
        if (apiService == null){
            apiService = HttpManger.getInstance().getApiService(ApiService.class);
        }
        return apiService;
    }




}
