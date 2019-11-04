package hxz.www.commonbase.cache;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import hxz.www.commonbase.app.BaseApplication;
import hxz.www.commonbase.util.log.LogShow;


public class CacheUtil {

    public static <T> void saveCache(String key, T t) {

        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
            File file = new File(BaseApplication.getInstance().getFilesDir().getPath() + File.separator + key);
            oos = new ObjectOutputStream(fos = new FileOutputStream(file));
            oos.writeObject(t);
        } catch (Exception e) {
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (oos != null) {
                    oos.close();
                }
            } catch (Exception e) {
               LogShow.i("CacheUtil  saveCache ",e.getMessage());
            }
        }

    }

    public static <T> T getCache(String key) {
        ObjectInputStream ois = null;
        FileInputStream in = null;
        T entity = null;

        try {
            File file = new File(BaseApplication.getInstance().getFilesDir().getPath() + File.separator + key);
            in = new FileInputStream(file);
            ois = new ObjectInputStream(in);
            entity = (T) ois.readObject();
        } catch (Exception e) {
            LogShow.e("获取数据失败=" + e.getMessage(),e.getStackTrace());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (ois != null) {
                    ois.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return entity;
    }

    public static boolean deleteCache(String key) {
         LogShow.i("CacheUtil  deleteCache ",BaseApplication.getInstance() );
        File file = new File(BaseApplication.getInstance().getFilesDir().getPath() + File.separator + key);
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }
}
