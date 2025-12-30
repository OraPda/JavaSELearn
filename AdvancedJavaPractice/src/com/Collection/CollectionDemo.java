package com.Collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionDemo {
    public static void main(String[] args) {
//        目标:搞清楚Collection集合的整体特点  单列集合
//        1.List家族的集合：有序、可重复、有索引
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("world");
        System.out.println( list);
        System.out.println(list.get(0));

//        2.Set家族的集合：无序、不可重复、无索引
        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("world");
        set.add("world");
        System.out.println(set);
    }
}
