package com.Genericity;

public class GenericDemo2 {
    public static void main(String[] args) {
//        自定义泛型类
//        模拟ArraysList集合自定义一个集合MyArrayList;
        MyArrayList<String> list = new MyArrayList();
        list.add("hello");
        list.add("world");
        list.add("java");
        System.out.println(list);
        list.remove("hello");
        System.out.println(list);

    }
}
