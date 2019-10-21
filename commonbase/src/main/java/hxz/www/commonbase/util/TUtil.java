package hxz.www.commonbase.util;

import java.lang.reflect.ParameterizedType;

/**
 * 类转换初始化
 */
public class TUtil {
    public static <T> T getT(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])
                    .newInstance();
        } catch (Exception e) {
        }
        return null;
    }

    public static  <T> Class<T> getClass(Object o, int i) {
        return (Class<T>) ((ParameterizedType) o.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public static Class<?> forName(String className) {
        try {
            return Class.forName(className);
        } catch (Exception e) {
        }
        return null;
    }
}
