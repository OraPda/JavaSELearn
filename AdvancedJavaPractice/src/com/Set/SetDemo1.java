package com.Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo1 {
    public static void main(String[] args) {
//        1.创建一个集合对象
//        Set<String> set1 = new HashSet<>();
        Set<String> set1 = new LinkedHashSet<>();
        set1.add("hello");
        set1.add("world");
        set1.add("world");
        set1.add("Java");
        set1.add("world");
        set1.add("鸿蒙");
        System.out.println(set1);
    }
}
