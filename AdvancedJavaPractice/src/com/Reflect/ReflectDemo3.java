package com.Reflect;

public class ReflectDemo3 {
    public static void main(String[] args) throws Exception {
//        反射的应用:做框架
        studentDemo s = new studentDemo("小明", 10);
        SaveObjectFrmeWork.saveObject(s);

        Teacher t = new Teacher("小红", 20, "java",9000,"3,4",'女',"1234356");
        SaveObjectFrmeWork.saveObject(t);

    }
}
