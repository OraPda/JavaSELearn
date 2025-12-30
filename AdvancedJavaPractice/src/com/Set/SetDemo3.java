package com.Set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo3 {
    public static void main(String[] args) {
//        搞清楚TreeSet对自定义对象的排序
        Set<Teacher> teachers = new TreeSet<>(Comparator.comparingInt(Teacher::getAge));
        teachers.add(new Teacher("老陈",20,3122.25));
        teachers.add(new Teacher("老1",25,65680.1212));
        teachers.add(new Teacher("2",59,4522.25));
        teachers.add(new Teacher("老罚",20,6922.25));
        teachers.add(new Teacher("老发",60,8922.25));
        System.out.println(teachers);
//        TreeSet默认不能给自定义对象排序
        /*
        * 解决方案
        * 1. 对象类实现一个Comparable比较接口，重写compare方法，指定大小比较规则
        * 2.public TreeSet（Comparator c） 集合自带比较器Comparator对象，指定比较规则
         */
    }
}
