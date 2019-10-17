package hxz.www.commonbase.util;

/**
 * 转换
 * Created by Circle on 2019-07-03
 */
public class ConvertUtil {
    private ConvertUtil(){}

    public static int stringToInt(String str){
        try{
            return Integer.parseInt(str);
        }catch (Exception e){
            return 0;
        }
    }

    public static long stringToLong(String str){
        try{
            return Long.parseLong(str);
        }catch (Exception e){
            return 0;
        }
    }
}
