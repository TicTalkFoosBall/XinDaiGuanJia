package hxz.www.commonbase.util;


public class ObjectUtil {
    private ObjectUtil() {
    }

    /**
     * compare two object
     *
     * @param actual
     * @param expected
     * @return <ul>
     * <li>if both are null, return true</li>
     * <li>return actual.{@link Object#equals(Object)}</li>
     * </ul>
     */
    public static boolean isEquals(Object actual, Object expected) {
        return actual == expected || (actual == null ? expected == null : actual.equals(expected));
    }
}
