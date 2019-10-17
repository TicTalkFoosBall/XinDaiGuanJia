package hxz.www.commonbase.util;

import android.Manifest;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.xingxiu.frame.cache.Cache;
import com.xingxiu.frame.cache.CacheUtil;

import java.util.UUID;

/**
 * Created by Circle on 2018/11/1
 */
public class DeviceUtil {

    /**
     * 网络类型（wifi，3G）
     */
    public static String getNetWorkName(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        int type = tm.getNetworkType();
        String typeName;
        switch (type) {
            /** Network type is unknown */
            case TelephonyManager.NETWORK_TYPE_UNKNOWN:
                typeName = "";
                break;
            /** Current network is GPRS */
            case TelephonyManager.NETWORK_TYPE_GPRS:
                typeName = "GPRS";
                break;
            /** Current network is EDGE */
            case TelephonyManager.NETWORK_TYPE_EDGE:
                typeName = "EDGE";
                break;
            /** Current network is UMTS */
            case TelephonyManager.NETWORK_TYPE_UMTS:
                typeName = "UMTS";
                break;
            /** Current network is CDMA: Either IS95A or IS95B*/
            case TelephonyManager.NETWORK_TYPE_CDMA:
                typeName = "CDMA";
                break;
            /** Current network is EVDO revision 0*/
            case TelephonyManager.NETWORK_TYPE_EVDO_0:
                typeName = "EVDO_0";
                break;
            /** Current network is EVDO revision A*/
            case TelephonyManager.NETWORK_TYPE_EVDO_A:
                typeName = "EVDO_A";
                break;
            /** Current network is 1xRTT*/
            case TelephonyManager.NETWORK_TYPE_1xRTT:
                typeName = "1xRTT";
                break;
            /** Current network is HSDPA */
            case TelephonyManager.NETWORK_TYPE_HSDPA:
                typeName = "HSDPA";
                break;
            /** Current network is HSUPA */
            case TelephonyManager.NETWORK_TYPE_HSUPA:
                typeName = "HSUPA";
                break;
            /** Current network is HSPA */
            case TelephonyManager.NETWORK_TYPE_HSPA:
                typeName = "HSPA";
                break;
            /** Current network is iDen */
            case TelephonyManager.NETWORK_TYPE_IDEN:
                typeName = "iDen";
                break;
            /** Current network is EVDO revision B*/
            case TelephonyManager.NETWORK_TYPE_EVDO_B:
                typeName = "EVDO_B";
                break;
            /** Current network is LTE */
            case TelephonyManager.NETWORK_TYPE_LTE:
                typeName = "LTE";
                break;
            /** Current network is eHRPD */
            case TelephonyManager.NETWORK_TYPE_EHRPD:
                typeName = "eHRPD";
                break;
            /** Current network is HSPA+ */
            case TelephonyManager.NETWORK_TYPE_HSPAP:
                typeName = "HSPA+";
                break;
            default:
                typeName = "type:" + type;
                break;
        }

        return typeName;
    }

    /**
     * 返回版本名字
     * 对应build.gradle中的versionName
     *
     * @return
     */
    public static String getVersionName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packInfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "1.0";
    }


    /**
     * 返回版本号
     * 对应build.gradle中的versionCode
     *
     * @param context
     * @return
     */
    public static int getVersionCode(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packInfo.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    private static String DEVICE_ID = "";

    /**
     * 获取设备的唯一标识，deviceId
     *
     * @return
     */
    public static String getDeviceId(Context context) {
        if (!TextUtils.isEmpty(DEVICE_ID)) {
            return DEVICE_ID;
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                return DEVICE_ID = getCustomDeviceId();
            }
        }
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        DEVICE_ID = tm.getDeviceId();
        if (TextUtils.isEmpty(DEVICE_ID)) {
            return DEVICE_ID = getCustomDeviceId();
        }

        return DEVICE_ID;
    }


    /**
     * 随机生成设备号
     *
     * @return
     */
    private static String getCustomDeviceId() {
        String deviceId = CacheUtil.getCache("custom_deviceId");
        if (TextUtils.isEmpty(deviceId)) {
            DEVICE_ID = EncryptUtil.MD5(System.nanoTime() + "@kela");
            if (TextUtils.isEmpty(DEVICE_ID)) {
                DEVICE_ID = UUID.randomUUID() + "";
                if (DEVICE_ID.contains("-")) {
                    DEVICE_ID = DEVICE_ID.replace("-", "");
                }

            }
            CacheUtil.saveCache("tag_deviceid", DEVICE_ID);
        }
        return DEVICE_ID;
    }

    /**
     * 获取手机号
     *
     * @return
     */
    public static String getPhoneNumber(Context context) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                return "";
            }
        }
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getLine1Number();
    }

    /**
     * 获取手机号
     *
     * @return
     */
    public static String getNetworkOperatorName(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getNetworkOperatorName();
    }

    /**
     * 获取手机品牌
     *
     * @return
     */
    public static String getPhoneBrand() {
        return android.os.Build.BRAND;
    }

    /**
     * 获取手机型号
     *
     * @return
     */
    public static String getPhoneModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取手机Android API等级（22、23 ...）
     *
     * @return
     */
    public static int getBuildLevel() {
        return android.os.Build.VERSION.SDK_INT;
    }

    /**
     * 获取手机Android 版本（4.4、5.0、5.1 ...）
     *
     * @return
     */
    public static String getBuildVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 获取当前App进程的id
     *
     * @return
     */
    public static int getAppProcessId() {
        return android.os.Process.myPid();
    }

    /**
     * 获取AndroidManifest.xml里 的值
     *
     * @param name
     * @return
     */
    public static String getMetaData(Context context, String name) {
        String value = null;
        try {
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            value = appInfo.metaData.getString(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public static boolean isRunningForeground(Context context) {
        try {
            ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
            String currentPackageName = cn.getPackageName();
            if (!TextUtils.isEmpty(currentPackageName) && currentPackageName.equals(context.getPackageName())) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }

    }
}
