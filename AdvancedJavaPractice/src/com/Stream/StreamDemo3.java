package com.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class StreamDemo3 {
    public static void main(String[] args) {
//        掌握Stream流中的常用中间方法，对流上的数据进行处理（返回新流，支持链式编程）
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张翠山");
        list.add("郭靖");

        list.stream().filter(s -> s.startsWith("张")).map(s -> s.toUpperCase()).forEach(System.out::println);

        List<Double> list2 = new ArrayList<>();
        list2.add(64.9);
        list2.add(51.9);
        list2.add(554.9);
        list2.add(93.9);
        list2.add(762.9);
        list2.add(176.9);

        list2.stream().sorted().forEach(System.out::println);  // 升序
        list2.stream().sorted((o1, o2) -> o2.compareTo(o1)).limit(2).forEach(System.out::println); // 降序 并取前两个
        list2.stream().sorted((o1, o2) -> o2.compareTo(o1)).skip(2).forEach(System.out::println);  // 降序 并跳过前两个
//        如果自定义对象要去重复，则需要重写equals和hashCode方法
        list2.stream().sorted((o1, o2) -> o2.compareTo(o1)).distinct().forEach(System.out::println);  // 去重
//        加工方法（映射方法） 将流上原来的数据拿出来，进行加工，返回加工后的数据
        list2.stream().map(s -> "加10分后" + (s + 10)).forEach(System.out::println);
//        合并流
        Stream<String> s1 = Stream.of("张无忌", "周芷若", "赵敏");
        Stream<String> s2 = Stream.of("张强", "张三丰", "张翠山");
        Stream<Integer> s3 = Stream.of(1, 2, 3);
        Stream<Object> s4 = Stream.concat(s2, s3);
        s4.forEach(System.out::println);
    }
}
