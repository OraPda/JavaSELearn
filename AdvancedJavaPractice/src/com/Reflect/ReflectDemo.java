package com.Reflect;

public class ReflectDemo {
    public static void main(String[] args) throws Exception {
//        反射第一步：获取Class对象
//        1.获取类本身，类名.class
        Class c1 = studentDemo.class;
//        2.获取类本身，class.forName("类名")
        Class c2 = Class.forName("com.Reflect.studentDemo");
        //3.获取对象，对象.getClass()
        studentDemo s = new studentDemo();
        Class c3 = s.getClass();

    }
}
