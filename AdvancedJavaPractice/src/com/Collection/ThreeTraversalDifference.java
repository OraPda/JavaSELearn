package com.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ThreeTraversalDifference {
//    目标:认识并发修改异常问题.三种遍历方式的区别
//    解决并发修改异常： 1.倒着遍历删除 2.回退一位在删除 3.使用迭代器删除
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("JAVA入门");
        list.add("宁夏枸杞");
        list.add("黑枸杞");
        list.add("人字拖");
        list.add("特级枸杞");
        list.add("枸杞子");
        list.add("西洋参");
/*
        删除枸杞相关内容
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.contains("枸杞")) {
                list.remove(s);
            }
        }
*/
        for (int i = list.size() - 1; i >= 0; i--) {
            String s = list.get(i);
            if (s.contains("枸杞")) {
                list.remove(s);
            }
        }
        System.out.println(list);
//        迭代器删除
//        使用迭代器本身方法删除 iterator.remove();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.contains("枸杞")) {
                  iterator.remove();
//                list.remove(s);
            }
        }
        System.out.println(list);
    }

}
