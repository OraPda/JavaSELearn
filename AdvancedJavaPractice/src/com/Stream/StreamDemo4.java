package com.Stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo4 {
    public static void main(String[] args) {
//        Stream的终结方法（统计、收集方法）
        List<Teacher> list = new ArrayList<>();
        list.add(new Teacher("张三", 18, 5000));
        list.add(new Teacher("李四", 28, 6000));
        list.add(new Teacher("王五", 38, 7000));
        list.add(new Teacher("赵六", 48, 8000));
        list.add(new Teacher("田七", 58, 9000));

        list.stream().filter(t -> t.getSalary() > 5000).forEach(System.out::println);

        System.out.println("=============================================================");

        long count = list.stream().filter(t -> t.getSalary() > 5000).count();
        System.out.println(count);

        System.out.println("=============================================================");

        List<Teacher> list2 = list.stream().filter(t -> t.getSalary() > 5000).collect(Collectors.toList());
        System.out.println(list2);

        System.out.println("=============================================================");

//        Optional<T> max(Comparator<? super T> comparator)   Optional可放任何对象包括null
        Optional<Teacher> max = list.stream().max((t1, t2) -> Double.compare(t1.getSalary(), t2.getSalary()));
        Teacher teacher = max.get();   // get()方法可拿到数据
        Teacher max1 = list.stream().max((t1, t2) -> Double.compare(t1.getSalary(), t2.getSalary())).get();
        System.out.println(max1);

        System.out.println("=============================================================");
        Optional<Teacher> min = list.stream().min((t1, t2) -> Double.compare(t1.getSalary(), t2.getSalary()));
        System.out.println(min.get());



        System.out.println("=============================================================");
        List<Teacher> list3 = new ArrayList<>();
        list3.add(new Teacher("张三", 18, 5000));
        list3.add(new Teacher("李四", 28, 6000));
        list3.add(new Teacher("王五", 38, 7000));
        list3.add(new Teacher("赵六", 48, 8000));
        list3.add(new Teacher("田七", 58, 9000));

//       收集到集合或者数组中。
//        流只能收集一次，第二次收集会报错。
        List<String> list4 = list3.stream().map(Teacher::getName).collect(Collectors.toList());
        System.out.println(list4);

    //      收集到Set集合中
        Set<String> set = list3.stream().map(Teacher::getName).collect(Collectors.toSet());
        System.out.println(set);

//        收集到数组中
        String[] arr = list3.stream().map(Teacher::getName).toArray(String[] :: new);
        System.out.println(Arrays.toString(arr));

        System.out.println("============================收集到Map集合=============================");
        Stream<Teacher> s = list.stream().sorted((t1, t2) -> Double.compare(t1.getSalary(), t2.getSalary()));
//        收集到Map集合，键是老师名称，值是老师薪水
        Map<String, Double> map = s.collect(Collectors.toMap(Teacher::getName, Teacher::getSalary));

        Map<String, Double> map1 = s.collect(Collectors.toMap(t -> t.getName(), t -> t.getSalary()));
        System.out.println(map);
    }
}
