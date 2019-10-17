package com.longer.creditManager.net;

import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

/**
 * @author 韩湘子
 * Dec:拦截器  2019年7月10日
 */
public class LoggerInterceptor implements Interceptor {

    private static String DEFAULT_TAG = "HXZ";

    private String TAG;

    private boolean showResponse;

    /**
     * 构造方法可以自定义传参
     *
     * @param TAG
     * @param showResponse
     */
    public LoggerInterceptor(String TAG, boolean showResponse) {
        if (TextUtils.isEmpty(TAG)) {
            TAG = DEFAULT_TAG;
        }
        this.showResponse = showResponse;
        this.TAG = TAG;
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        logForRequest(request);
        Response response = chain.proceed(request);
        return logForResponse(response);
    }


    private Response logForResponse(Response response) {
        try {
            Response.Builder builder = response.newBuilder();
            Response clone = builder.build();
            Log.e(TAG, "路径: " + clone.request().url());
            Log.e(TAG, "状态: " + clone.code());
            Log.e(TAG, "协议: " + clone.protocol());
            if (!TextUtils.isEmpty(clone.message())) {
                Log.e(TAG, "message : " + clone.message());
            }
            if (showResponse) {
                ResponseBody body = clone.body();
                if (body != null) {
                    MediaType mediaType = body.contentType();
                    if (mediaType != null) {
                        Log.e(TAG, "内容类型: " + mediaType.toString());
                        if (isText(mediaType)) {
                            String resp = body.string();
                            Log.e(TAG, "请求内容: " + resp);

                            body = ResponseBody.create(mediaType, resp);
                            return response.newBuilder().body(body).build();
                        } else {
                            Log.e(TAG, "请求内容: " + "文件应该太大了,无法打印.......");
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    private void logForRequest(Request request) {
        Log.e(TAG, "-----------------------------------------------------------------------------------------------------------");
        try {
            Headers headers = request.headers();
            Log.e(TAG, "请求方式: " + request.method());
            if (headers != null && headers.size() > 0) {
                Log.e(TAG, "请求头: " + headers.toString());
            }
            RequestBody requestBody = request.body();
            if (requestBody != null) {
                MediaType mediaType = requestBody.contentType();
                if (mediaType != null) {
                    Log.e(TAG, "请求类型:" + mediaType.toString());
                    if (isText(mediaType)) {
                        Log.e(TAG, "请求内容: " + bodyToString(request));
                    } else {
                        Log.e(TAG, "请求内容: " + "文件应该太大了,无法打印.......");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isText(MediaType mediaType) {
        if (mediaType.type() != null && mediaType.type().equals("text")) {
            return true;
        }
        if (mediaType.subtype() != null) {
            if (mediaType.subtype().equals("json") ||
                    mediaType.subtype().equals("xml") ||
                    mediaType.subtype().equals("html") ||
                    mediaType.subtype().equals("webviewhtml")
            )
                return true;
        }
        return false;
    }

    private String bodyToString(final Request request) {
        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "something error when show requestBody.";
        }
    }
}
