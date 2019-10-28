package hxz.www.commonbase.net.constant;


import java.util.List;

import hxz.www.commonbase.cache.UserInfo;
import hxz.www.commonbase.model.Attachment;
import hxz.www.commonbase.model.Ba1;
import hxz.www.commonbase.model.ClientModel;
import hxz.www.commonbase.model.ExamineBean;
import hxz.www.commonbase.model.ListBody;
import hxz.www.commonbase.model.LoginBody;
import hxz.www.commonbase.model.NoticeListModel;
import hxz.www.commonbase.model.SystemMsgModel;
import hxz.www.commonbase.model.UnreadBean;
import hxz.www.commonbase.model.todo.TodoBean;
import hxz.www.commonbase.model.todo.buinese.BusineseTab;
import hxz.www.commonbase.model.todo.detail.Approval;
import hxz.www.commonbase.model.todo.detail.TodoDetailItem;
import hxz.www.commonbase.net.BaseResult;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
      String BASE_URL = "http://120.79.56.152:9010/lfcp-app/";
      String FILE_URL = "http://120.79.56.152:8010";

    @GET("dish_list.php")
    Single<Ba1> getBa1(@Query("stage_id") String stage_id, @Query("limit") String limitm, @Query("page") String page);


    // 登录
    @POST("auth")
    Single<BaseResult<UserInfo>> getLoginBeae(@Body LoginBody loginBody);

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

    // 系统消息已读
    @PUT("systemMsg/read")
    Single<BaseResult> readSystemMSg();

    // 代办审批
    @GET("task/list")
    Single<BaseResult<TodoBean>> getTodoList(@Query("pageIndex") int pageIndex, @Query("pageCount") int pageCount);

    // 代办详情
    @GET("task/detailHistoryApproval")
    Single<BaseResult<TodoDetailItem>> getTodoDetail(@Query("taskId") String taskId, @Query("procInstId") String procInstId);

    //附件列表
    @GET("{formGroup}/{formGroupCode}/attachment/{masterId}")
    Single<BaseResult<List<Attachment>>> getAttachments(@Path("formGroup") String formGroup,@Path("formGroupCode") String formGroupCode,@Path("masterId") String masterId);

    //公告附件列表
    @GET("file/files/{noticeId}")
    Single<BaseResult<List<Attachment>>> getNoticeAttachments(@Path("noticeId") String noticeId);

    //
    @GET(" formGroup/tabs/{formGroupCode}")
    Single<BaseResult<TodoDetailItem>> getMoreMenu(@Path("formGroupCode") String formGroupCode);


    //提交审核
    @POST("task/handler")
    Single<BaseResult<TodoDetailItem>> commitApproval(@Body Approval loginBody);


    //统计菜单
    @GET("statistics/list")
    Single<BaseResult<BusineseTab>> getStatisticsTab();


    @GET("lfcp-android.support.v4.app/task/list")
    Single<ExamineBean> getExamineList(@Header("token") String token, @Body ListBody listBody);


}

