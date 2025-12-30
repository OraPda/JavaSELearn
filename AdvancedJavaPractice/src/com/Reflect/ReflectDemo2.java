package com.Reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;

public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
//       反射的基本作用：
//        1.获取类的全部成分
//        2.可以破坏封装性
//        3.可以绕过泛型的约束
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");

        Class c1 = list.getClass();
        Method add = c1.getDeclaredMethod("add", Object.class);
        add.invoke(list,100);   //翻墙加入100
        System.out.println(list);
    }
}
