package com.longer.creditManager.constant;


import com.longer.creditManager.bean.Ba1;
import com.longer.creditManager.bean.ExamineBean;
import com.longer.creditManager.bean.LoginBeae;
import com.longer.creditManager.bean.body.ListBody;
import com.longer.creditManager.bean.body.LoginBody;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    //// http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1
    String BASE_URL = "http://192.168.1.121:8089/";

    @GET("dish_list.php")
    Single<Ba1> getBa1(@Query("stage_id")String stage_id, @Query("limit") String limitm, @Query("page")  String page);


    // 登录

    // http://192.168.1.121:8089/lfcp-app/auth
    @POST("lfcp-android.support.v4.app/auth")
    Single<LoginBeae> getLoginBeae(@Body LoginBody loginBody);

    // 审批待办列表
    // http://192.168.1.121:8089/lfcp-app/task/list

    @GET("lfcp-android.support.v4.app/task/list")
    Single<ExamineBean> getExamineList(@Header("token") String token, @Body ListBody listBody);



}

