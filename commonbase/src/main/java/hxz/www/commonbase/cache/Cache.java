package hxz.www.commonbase.cache;

import android.text.TextUtils;

import hxz.www.commonbase.model.BaseUrlModel;
import hxz.www.commonbase.util.log.LogShow;

public class Cache {
    private static final String KEY_USER = "user.ser";//用户信息存数文件名
    private static final String KEY_BASEURL = "model.baseurl";//用户信息存数文件名
    private static volatile UserInfo mUserInfo;
    private static volatile BaseUrlModel mBaseUrl;
    private static volatile String mToken = "";

    public static UserInfo getUserInfo() {
        if (mUserInfo == null) {
            mUserInfo = CacheUtil.getCache(KEY_USER);
        }
        if (mUserInfo == null)
            return new UserInfo();
        return mUserInfo;
    }

    public static void setUserInfo(UserInfo userInfo) {
        mUserInfo = userInfo;
        if (userInfo == null) {
            mToken = "";
            CacheUtil.deleteCache(KEY_USER);
        } else {
            mToken = mUserInfo.getToken();
            CacheUtil.saveCache(KEY_USER, mUserInfo);
        }
    }

    /**
     * 是否已经登录
     *
     * @return
     */
    public static boolean isLogin() {
        if (TextUtils.isEmpty(getToken()) || TextUtils.isEmpty(getBAseUrl().getServiceUrl()))
            return false;
        return true;
    }

    public static String getToken() {
        if (TextUtils.isEmpty(mToken)) {
            mToken = getUserInfo().getToken();
            if (mToken == null)
                mToken = "";
        }
        LogShow.i("Cache  getToken", mToken);
        return mToken;
    }

    public static BaseUrlModel getBAseUrl() {
        LogShow.i("Cache  getBAseUrl begin", mBaseUrl);
        if (mBaseUrl == null) {
            mBaseUrl = CacheUtil.getCache(KEY_BASEURL);
        }
        if (mBaseUrl == null)
            return new BaseUrlModel();
        LogShow.i("Cache  getBAseUrl", mBaseUrl.toString());
        return mBaseUrl;
    }

    public static void setBaseUrl(BaseUrlModel model) {
        mBaseUrl = model;
        LogShow.i("Cache  setBaseUrl", mBaseUrl, model == null);
        if (model == null) {
            CacheUtil.deleteCache(KEY_BASEURL);
        } else {
            CacheUtil.saveCache(KEY_BASEURL, mBaseUrl);
        }
    }
}
