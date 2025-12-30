package com.Reflect;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo1 {
    @Test
    public void getClassInfo(){
//        获取类的信息
//        1.获取Class对象
        Class c1 = studentDemo.class;
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());
    }

    @Test
    public void getConstructor() throws Exception {
//        2.获取构造方法
        Class c1 = studentDemo.class;
        System.out.println(c1.getConstructors());   //获取共有的构造方法
        System.out.println(c1.getDeclaredConstructors());  //获取所有构造方法
        System.out.println(c1.getConstructor(String.class, int.class));   //获取指定共有的构造方法
        System.out.println(c1.getDeclaredConstructor(String.class));  //获取指定的构造方法

//        5.获取构造器的作用：依然是创建对象
//        私有构造器,方法,属性可以暴力反射,直接访问
        Constructor constructor = c1.getConstructor();//获取无参构造方法
        constructor.setAccessible(true); //暴力反射
        Object obj = constructor.newInstance();
        studentDemo s = (studentDemo) constructor.newInstance();  //创建对象
    }

    @Test
    public void getField() throws Exception {
        //3.获取成员变量
        Class c1 = studentDemo.class;
        Field[] files = c1.getDeclaredFields();
        for (Field f : files){
            System.out.println(f.getName() + "(" + f.getType().getName() + ")");
        }
        //获取指定成员变量
        Field f = c1.getDeclaredField("name");
        System.out.println(f.getName() + "(" + f.getType().getName() + ")");

//        6.获取成员变量的目的：获取成员变量的值，修改成员变量的值
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true);   //绕过访问权限修饰符,暴力反射
        studentDemo s = new studentDemo();
        name.set(s,"张三");
        System.out.println(name.get(s));
        System.out.println(s.getName());
    }

    @Test
    public void getMethod() throws Exception {
        //4.获取成员方法
        Class c1 = studentDemo.class;
        Method[] methods = c1.getDeclaredMethods();
        for (Method m : methods){
            System.out.print(m.getName() + "(");
            Class[] params = m.getParameterTypes();
            for (Class c : params){
                System.out.print(c.getName() + ",");
            }
            System.out.println(")");
        }
        //获取指定成员方法
        Method m = c1.getDeclaredMethod("getAge");
        System.out.print(m.getName() + "(");
        Class[] params = m.getParameterTypes();
        for (Class c : params){
            System.out.print(c.getName() + ",");
        }
        System.out.println(")");

        //获取成员方法的作用：获取方法值，调用方法
        Method m1 = c1.getDeclaredMethod("getAge");
        m1.setAccessible(true);
        studentDemo s = new studentDemo();
        int age = (int) m1.invoke(s);  //唤醒s对象的getAge方法 ,相当于调用s.getAge()
        System.out.println(age);
    }
}
