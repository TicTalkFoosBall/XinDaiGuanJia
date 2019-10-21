package hxz.www.commonbase.util;


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
