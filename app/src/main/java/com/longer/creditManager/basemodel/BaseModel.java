
package com.longer.creditManager.basemodel;





import com.longer.creditManager.constant.ApiService;
import com.longer.creditManager.net.HttpManger;

import hxz.www.commonbase.base.mvp.IBaseModel;

public abstract class BaseModel implements IBaseModel{

    ApiService apiService;

    protected ApiService getApiService(){
        if (apiService == null){
            apiService = HttpManger.getInstance().getApiService(ApiService.class);
        }
        return apiService;
    }




}
