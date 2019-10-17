package hxz.www.commonbase.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;


/**
 * Created by Circle on 2019-06-28
 */
public class AppUtil {

    public static String getCurProcessName(Context context) {
        int pid = Process.myPid();
        ActivityManager mActivityManager = (ActivityManager)context.getSystemService("activity");
        List<RunningAppProcessInfo> runningAppProcessInfos = mActivityManager.getRunningAppProcesses();
        if (runningAppProcessInfos == null) {
            return null;
        } else {
            Iterator var4 = runningAppProcessInfos.iterator();

            RunningAppProcessInfo appProcess;
            do {
                if (!var4.hasNext()) {
                    return null;
                }
                appProcess = (RunningAppProcessInfo)var4.next();
            } while(appProcess.pid != pid);

            return appProcess.processName;
        }
    }


    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    public static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 是否运行在前台，
     *
     * @param context 可以直接用App.getContext();
     * @return false  前台，  true  后台
     */
    public static boolean isBackground(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            List<RunningAppProcessInfo> appProcesses = activityManager
                    .getRunningAppProcesses();
            for (RunningAppProcessInfo appProcess : appProcesses) {
                if (appProcess.processName.equals(context.getPackageName())) {
                    return appProcess.importance != RunningAppProcessInfo.IMPORTANCE_FOREGROUND;
                }
            }
        } catch (Exception e) {

        }
        return false;
    }
}
