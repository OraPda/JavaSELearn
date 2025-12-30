package com.Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo2 {
    public static void main(String[] args) {
//        目标: 掌握HashSet集合的去重操作
        Student s1 = new Student("小王", 18, "北京", "12345678900");
        Student s2 = new Student("老张", 88, "上海", "456456");
        Student s3 = new Student("小李", 59, "杭州", "45689478965");
        Student s4 = new Student("小王", 18, "北京", "12345678900");

        Set<Student> set = new HashSet<>();     //未去重
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        System.out.println(set);

        Set<Student> set13 = new LinkedHashSet<>();
    }
}
