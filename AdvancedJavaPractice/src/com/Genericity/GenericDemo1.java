package com.Genericity;

import java.util.ArrayList;

public class GenericDemo1 {
    public static void main(String[] args) {
//        泛型是将具体的数据类型作为参数传给类型变量，从而实现对数据类型的约束
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        System.out.println(list);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
