package com.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo1 {
    public static void main(String[] args) {
//       体验Stream流
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张翠山");
        list.add("郭靖");

//        先用传统方案找出姓张的人，名字为三个字的，存入一个新的集合中
        List<String> list2 = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith("张")) {
                if (s.length() == 3) {
                    list2.add(s);
                }
            }
        }
        System.out.println(list2);


//        2.使用Stream流
//        list.stream()
//                .filter(s -> s.startsWith("张"))
//                .filter(s -> s.length() == 3)
//                .forEach(System.out::println);
        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(System.out::println);
        List<String> list3 = list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).collect(Collectors.toList());
        System.out.println(list3);
    }
}
