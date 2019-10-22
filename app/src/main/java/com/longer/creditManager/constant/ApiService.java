package com.longer.creditManager.constant;


import com.longer.creditManager.bean.Ba1;
import com.longer.creditManager.bean.ExamineBean;
import com.longer.creditManager.bean.LoginBeae;
import com.longer.creditManager.bean.body.ListBody;
import com.longer.creditManager.bean.body.LoginBody;
import com.longer.creditManager.blacklist.NoticeListModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    String BASE_URL = "http://120.79.56.152:9010/lfcp-app/";

    @GET("dish_list.php")
    Single<Ba1> getBa1(@Query("stage_id")String stage_id, @Query("limit") String limitm, @Query("page")  String page);


    // 登录
    @POST("auth")
    Single<LoginBeae> getLoginBeae(@Body LoginBody loginBody);

    // 通知公告
    @GET("notice/list")
    Single<List<NoticeListModel>> getNotice(@Query("pageIndex") int pageIndex, @Query("pageCount") int pageCount);

    // 审批待办列表
    // http://192.168.1.121:8089/lfcp-app/task/list

    @GET("lfcp-android.support.v4.app/task/list")
    Single<ExamineBean> getExamineList(@Header("token") String token, @Body ListBody listBody);



}

