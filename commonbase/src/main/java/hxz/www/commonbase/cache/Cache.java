package hxz.www.commonbase.cache;

import android.text.TextUtils;

public class Cache {
    private static final String KEY_USER = "user.ser";//用户信息存数文件名
    private static volatile UserInfo mUserInfo;
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
        if (TextUtils.isEmpty(getToken() ) )
            return false;
        return true;
    }

    public static String getToken() {
        if (TextUtils.isEmpty(mToken)) {
            mToken = getUserInfo().getToken();
            if (mToken == null)
                mToken = "";
        }
        return mToken;
    }


}
