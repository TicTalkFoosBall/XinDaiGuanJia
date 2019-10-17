package hxz.www.commonbase.util.time;

import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用来计算显示的时间是多久之前的！
 * Created by Circle on 2018/11/1
 */
public class FormatTimeUtil {
    private FormatTimeUtil() {

    }

    public static SimpleDateFormat hmFormat = new SimpleDateFormat("HH:mm");
    public static SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy/MM/dd");
    public static SimpleDateFormat ymdhmFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static String getConversationListTime(long time) {
        if (DateUtil.isSameDay(time)) {
            return hmFormat.format(time);
        } else {
            return ymdFormat.format(time);
        }
    }

    public static String getConversationTime(long time) {
        if (DateUtil.isSameDay(time)) {
            return hmFormat.format(time);
        } else {
            return ymdhmFormat.format(time);
        }
    }


    public static String getPublishTime(long l) {
        return getPublishTime(l, System.currentTimeMillis());
    }

    public static String getTime(long time, SimpleDateFormat simpleDateFormat){
        return simpleDateFormat.format(time);
    }

    public static String getPublishTime(long l, long current) {
        String msg = "";
        if (DateUtil.isSameDay(l)) {
            long time = (current - l) / 1000;
            if (time / 60 == 0) {
                msg = "1分钟前";
            } else if (time / 60 > 0 && time / 3600 == 0) {
                msg = time / 60 + "分钟前";
            } else if (time / 3600 > 0 && time / (3600 * 24) == 0) {
                msg = time / 3600 + "小时前";
            }
        } else if (DateUtil.isYesterday(l)) {
            msg = "昨天";
        } else {
            msg = formatTimeMillis(l, "MM-dd HH:mm:ss");
        }
        return msg;
    }

    public static String formatTimeMillis(long ms, String format) {
        Date date = new Date(ms);
        if (TextUtils.isEmpty(format)) {
            format = "M月d日";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 格式化友好的时间差显示方式
     *
     * @param millis 开始时间戳
     * @return
     */
    public static String getTimeSpanByNow1(long millis) {
        long now = System.currentTimeMillis();
        long span = now - millis;
        if (span < 1000) {
            return "刚刚";
        } else if (span < DateUtil.MIN) {
            return String.format("%d秒前", span / DateUtil.SEC);
        } else if (span < DateUtil.HOUR) {
            return String.format("%d分钟前", span / DateUtil.MIN);
        } else if (span < DateUtil.DAY) {
            return String.format("%d小时前", span / DateUtil.HOUR);
        } else if (span < DateUtil.WEEK) {
            return String.format("%d天前", span / DateUtil.DAY);
        } else if (span < DateUtil.MONTH) {
            return String.format("%d周前", span / DateUtil.WEEK);
        } else if (span < DateUtil.YEAR) {
            return String.format("%d月前", span / DateUtil.MONTH);
        } else {
            return String.format("%d年前", span / DateUtil.YEAR);
        }
    }

    /**
     * 格式化友好的时间差显示方式
     *
     * @param millis 开始时间戳
     * @return
     */
    public static String getTimeSpanByNow2(long millis) {
        long now = System.currentTimeMillis();
        long span = now - millis;
        long day = span / DateUtil.DAY;
        if (day == 0) {// 今天
            long hour = span / DateUtil.HOUR;
            if (hour <= 4) {
                return String.format("凌晨%tR", millis);
            } else if (hour > 4 && hour <= 6) {
                return String.format("早上%tR", millis);
            } else if (hour > 6 && hour <= 11) {
                return String.format("上午%tR", millis);
            } else if (hour > 11 && hour <= 13) {
                return String.format("中午%tR", millis);
            } else if (hour > 13 && hour <= 18) {
                return String.format("下午%tR", millis);
            } else if (hour > 18 && hour <= 19) {
                return String.format("傍晚%tR", millis);
            } else if (hour > 19 && hour <= 24) {
                return String.format("晚上%tR", millis);
            } else {
                return String.format("今天%tR", millis);
            }
        } else if (day == 1) {// 昨天
            return String.format("昨天%tR", millis);
        } else if (day == 2) {// 前天
            return String.format("前天%tR", millis);
        } else {
            return String.format("%tF", millis);
        }
    }
}
