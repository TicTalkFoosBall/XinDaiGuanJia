
package com.longer.creditManager.basemodel;




import com.longer.creditManager.constant.ApiService;


import hxz.www.commonbase.base.mvp.IBaseModel;
import hxz.www.commonbase.net.HttpManger;

public abstract class BaseModel implements IBaseModel{

  private   volatile static ApiService apiService;

    protected static  ApiService getApiService(){
        if (apiService == null){
            apiService = HttpManger.getInstance().getApiService(ApiService.class);
        }
        return apiService;
    }




}
