package com.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionTraversal {
    public static void main(String[] args) {
//        目标: Collection集合的三种遍历方法
//        1.迭代器遍历
        Collection<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        // 创建迭代器对象
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }
        System.out.println("===================");
//        2.增强for遍历
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("===================");
//        3.Lambda表达式遍历
        list.forEach(s -> System.out.println(s));
        list.forEach(System.out::println);
        System.out.println("==============================");
    }
}
