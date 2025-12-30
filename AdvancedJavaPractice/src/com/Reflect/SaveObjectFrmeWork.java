package com.Reflect;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class SaveObjectFrmeWork {
//    保存任意对象的静态方法
    public static void saveObject(Object obj) throws Exception {
        PrintStream out = new PrintStream(new FileOutputStream("AdvancedJavaPractice\\src\\com\\Reflectobject.txt", true));
        //obj可能是任意对象
        //只有反射可以知道对象有多少个字段
        //1.获取obj的Class对象
        Class c1 = obj.getClass();
        String simpleName = c1.getSimpleName();
        out.println(simpleName);
        //2.获取c1的所有属性
        Field[] fields = c1.getDeclaredFields();
        //3.遍历 fields
        for (Field f : fields) {
            //获取属性名
            String fieldName = f.getName();
            //获取属性值
            f.setAccessible(true);
            Object fieldValue = f.get(obj);
            out.println(fieldName + "=" + fieldValue);
        }
        out.close();
    }

}
