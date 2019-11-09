package hxz.www.commonbase.net;

import android.text.TextUtils;

import java.io.IOException;
import java.util.List;

import hxz.www.commonbase.cache.Cache;
import hxz.www.commonbase.util.log.LogShow;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class BaseUrlInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        //获取request
        Request request = chain.request();
        //从request中获取原有的HttpUrl实例oldHttpUrl
        HttpUrl oldHttpUrl = request.url();
        //获取request的创建者builder
        Request.Builder builder = request.newBuilder();
        //从request中获取headers，通过给定的键url_name
        List<String> headerValues = request.headers("urlname");
        String serviceUrl=Cache.getBAseUrl().getServiceUrl();
        if (!TextUtils.isEmpty(serviceUrl)) {
            //如果有这个header，先将配置的header删除，因此header仅用作app和okhttp之间使用
            builder.removeHeader("urlname");
            //匹配获得新的BaseUrl
            String headerValue = headerValues.get(0);
            HttpUrl newBaseUrl = null;
            newBaseUrl = HttpUrl.parse(serviceUrl);
            //重建新的HttpUrl，修改需要修改的url部分
            HttpUrl newFullUrl = oldHttpUrl
                    .newBuilder()
                    .host(newBaseUrl.host())//更换主机名
                    .removePathSegment(0)//移除第一个参数
                    .build();
            //重建这个request，通过builder.url(newFullUrl).build()；
            // 然后返回一个response至此结束修改
            LogShow.i("BaseUrlInterceptor  intercept",newFullUrl.toString());
            return chain.proceed(builder.url(newFullUrl).build());
        }
        return chain.proceed(request);
    }
}
