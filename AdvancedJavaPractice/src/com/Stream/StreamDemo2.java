package com.Stream;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
//        获取Stream流
//        1.获取集合的Stream流，调用stream()方法
        Collection<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

//        2.Map的Stream流，调用stream()方法
        Map<String, String> map = new HashMap<>();
        Stream<String> stream1 = map.values().stream();
        Stream<String> stream2 = map.keySet().stream();
        Stream<Map.Entry<String, String>> stream3 = map.entrySet().stream();

//        3.数组获取Stream流，调用Arrays.stream()方法
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        IntStream stream4 = Arrays.stream(arr);

//        public static <T> Stream<T> of(T... values)
        Stream<String> stream5 = Stream.of("张三", "张三丰", "张无忌", "张三", "张强");

    }
}
