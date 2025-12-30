package com.Annotation;


public class AnnotationDemo1 {
    @MyTest
    private int a = 10;

    @MyTest
    public void show(){
        System.out.println("show()方法被调用");
    }


}
