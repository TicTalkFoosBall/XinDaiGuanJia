package com.longer.creditManager.constant;


import com.longer.creditManager.bean.Ba1;
import com.longer.creditManager.bean.ExamineBean;
import com.longer.creditManager.bean.LoginBeae;
import com.longer.creditManager.bean.body.ListBody;
import com.longer.creditManager.bean.body.LoginBody;
import com.longer.creditManager.client.ClientModel;
import com.longer.creditManager.home.UnreadBean;
import com.longer.creditManager.net.BaseResult;
import com.longer.creditManager.notice.NoticeListModel;
import com.longer.creditManager.systemmsg.SystemMsgModel;

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
    Single<Ba1> getBa1(@Query("stage_id") String stage_id, @Query("limit") String limitm, @Query("page") String page);


    // 登录
    @POST("auth")
    Single<LoginBeae> getLoginBeae(@Body LoginBody loginBody);

    // 通知公告
    @GET("notice/list")
    Single<BaseResult<NoticeListModel>> getNotice(@Query("pageIndex") int pageIndex, @Query("pageCount") int pageCount);  // 通知公告

    // 系统消息
    @GET("systemMsg/list")
    Single<BaseResult<SystemMsgModel>> getSystemMsg(@Query("pageIndex") int pageIndex, @Query("pageCount") int pageCount);

    //客户列表
    @GET("customer/list")
    Single<BaseResult<List<ClientModel>>> getCustomer(@Query("pageIndex") int pageIndex, @Query("pageCount") int pageCount
            , @Query("keyword") String keyword);

    // 首页未读数
    @GET("return")
    Single<BaseResult<UnreadBean>> getUnreadCount();


    // 审批待办列表
    // http://192.168.1.121:8089/lfcp-app/task/list
//    点击 系统消息界面，调用这个接口http://localhost:8089/lfcp-app/systemMsg/read
//    http://localhost:8089/lfcp-app/return

    @GET("lfcp-android.support.v4.app/task/list")
    Single<ExamineBean> getExamineList(@Header("token") String token, @Body ListBody listBody);


}

