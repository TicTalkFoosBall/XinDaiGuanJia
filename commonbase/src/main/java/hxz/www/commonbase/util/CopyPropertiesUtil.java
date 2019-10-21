package hxz.www.commonbase.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class CopyPropertiesUtil {

    public static Object depthClone(Object srcObj) throws IOException, ClassNotFoundException {
        Object cloneObj;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(out);
        oo.writeObject(srcObj);

        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(in);
        cloneObj = oi.readObject();

        return cloneObj;
    }

}