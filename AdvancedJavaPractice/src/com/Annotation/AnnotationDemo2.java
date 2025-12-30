package com.Annotation;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationDemo2 {
//    解析注解
    @Test
    public void test1(){
        //1.获取类对象
        Class c1 = Demo.class;
        //2.判断这个类上是否有@MyTest1注解
        if (c1.isAnnotationPresent(MyTest1.class)){
            //3.获取注解对象
            MyTest1 annotation = (MyTest1) c1.getDeclaredAnnotation(MyTest1.class);
            //4.获取注解的属性值
            String[] address = annotation.address();
            double height = annotation.height();
            String name = annotation.value();
            System.out.println(name);
            System.out.println(height);
            System.out.println(Arrays.toString( address));
        }
    }

    @Test
    public void test2() throws Exception {
        //1.获取类对象
        Class c1 = Demo.class;
        //2.获取方法对象
        Method methods = c1.getDeclaredMethod("go");
        //3.判断这个方法上是否有@MyTest1注解
        if (methods.isAnnotationPresent(MyTest1.class)){
            //4.获取注解对象
            MyTest1 annotation = methods.getDeclaredAnnotation(MyTest1.class);
            //5.获取注解的属性值
            String[] address = annotation.address();
            double height = annotation.height();
            String name = annotation.value();
            System.out.println(name);
            System.out.println(height);
            System.out.println(Arrays.toString( address));
        }
    }
}
