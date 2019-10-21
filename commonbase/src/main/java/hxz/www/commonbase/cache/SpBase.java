package hxz.www.commonbase.cache;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import hxz.www.commonbase.app.BaseApplication;




public class SpBase {


    // SharedPreferences
    private static SharedPreferences getSharedPrefs() {
        return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getInstance());
    }

    public static String getString(String key, final String defaultValue) {
        return getSharedPrefs().getString(key, defaultValue);
    }

    public static void setString(final String key, final String value) {
        getSharedPrefs().edit().putString(key, value).apply();
    }

    protected static boolean getBoolean(final String key, final boolean defaultValue) {
        return getSharedPrefs().getBoolean(key, defaultValue);
    }

    protected static void setBoolean(final String key, final boolean value) {
        getSharedPrefs().edit().putBoolean(key, value).apply();
    }

    protected static void setInt(final String key, final int value) {
        getSharedPrefs().edit().putInt(key, value).apply();
    }

    protected static int getInt(final String key, final int defaultValue) {
        return getSharedPrefs().getInt(key, defaultValue);
    }

    protected static void setFloat(final String key, final float value) {
        getSharedPrefs().edit().putFloat(key, value).apply();
    }

    protected static float getFloat(final String key, final float defaultValue) {
        return getSharedPrefs().getFloat(key, defaultValue);
    }

    protected static void setLong(final String key, final long value) {
        getSharedPrefs().edit().putLong(key, value).apply();
    }

    protected static long getLong(final String key, final long defaultValue) {
        return getSharedPrefs().getLong(key, defaultValue);
    }

    /**
     * 移除某个key值已经对应的值
     *
     * @param key
     */
    protected static void remove(String key) {
        getSharedPrefs().edit().remove(key).apply();
    }

    /**
     * 清除所有数据
     */
    protected static void clear() {
        getSharedPrefs().edit().clear().apply();
    }

    /**
     * 查询某个key是否已经存在
     *
     * @param key
     * @return
     */
    protected static boolean contains(String key) {
        return getSharedPrefs().contains(key);
    }

}
