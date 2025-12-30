package com.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class MapDemo1 {
    public static void main(String[] args) {
//        1.创建Map集合对象
        Map<String,Integer> map = new HashMap<>();
//        2.添加元素
        map.put("Li",1561);
        map.put("张三",4561);
        map.put("张三",4561);
        map.put("王五",4575);
        map.put("赵六",4544);
        System.out.println(map);

        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
