//package hxz.www.commonbase.cache;
//
//import android.text.TextUtils;
//
//import com.xingxiu.frame.model.UserInfoModel;
//
///**
// * Created by Circle on 2019-07-02
// */
//public class Cache {
//    private static final String KEY_USER = "user.ser";//用户信息存数文件名
//    private static final String KEY_RYTOKEN = "imtoken";//融云token
//    private static volatile UserInfoModel mUserInfo;
//    private static volatile String mToken = "";
//    private static volatile String mRYToken = "";
//    private static volatile long mUserId = 0;
//
//
//    public static UserInfoModel getUserInfo() {
//        if (mUserInfo == null) {
//            mUserInfo = CacheUtil.getCache(KEY_USER);
//        }
//        if (mUserInfo == null)
//            return new UserInfoModel();
//        return mUserInfo;
//    }
//
//    public static void setUserInfo(UserInfoModel userInfo) {
//        mUserInfo = userInfo;
//        if (userInfo == null) {
//            mUserId = 0;
//            mToken = "";
//            setRYToken("");
//            CacheUtil.deleteCache(KEY_USER);
//        } else {
//            mUserId = mUserInfo.getMemberId();
//            mToken = mUserInfo.getKelaToken();
//            setRYToken(mUserInfo.getRcToken());
//            CacheUtil.saveCache(KEY_USER, mUserInfo);
//        }
//    }
//
//    /**
//     * 是否已经登录
//     *
//     * @return
//     */
//    public static boolean isLogin() {
//        if (TextUtils.isEmpty(getUserInfo().getKelaToken()) || getUserInfo().getRegistStep() < 3)
//            return false;
//        return true;
//    }
//
//    public static String getToken() {
//        if (TextUtils.isEmpty(mToken)) {
//            mToken = getUserInfo().getKelaToken();
//            if (mToken == null)
//                mToken = "";
//        }
//        return mToken;
//    }
//
//    public static long getUserId() {
//        if (mUserId == 0) {
//            mUserId = getUserInfo().getMemberId();
//        }
//        return mUserId;
//    }
//
//    public static void setRYToken(String ryToken) {
//        if (TextUtils.isEmpty(ryToken)) {
//            mRYToken = "";
//            CacheUtil.deleteCache(KEY_RYTOKEN);
//        } else {
//            mRYToken = ryToken;
//            CacheUtil.saveCache(KEY_RYTOKEN, mRYToken);
//        }
//    }
//
//    public static String getRYToken() {
//        if (TextUtils.isEmpty(mRYToken)) {
//            mRYToken = CacheUtil.getCache(KEY_RYTOKEN);
//            if (mRYToken == null)
//                mRYToken = "";
//        }
//        return mRYToken;
//    }
//
//}
