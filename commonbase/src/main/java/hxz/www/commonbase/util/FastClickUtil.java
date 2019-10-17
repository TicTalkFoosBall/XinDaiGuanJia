package hxz.www.commonbase.util;

import com.xingxiu.frame.util.log.LogShow;

/**
 * Created by Circle on 2019/1/29
 */
public class FastClickUtil {
    private static long currentMills = 0;

    public static boolean isFastClick() {
        if (System.currentTimeMillis() - currentMills > 500) {
            currentMills = System.currentTimeMillis();
            return false;
        }
        return true;
    }
}
