package com.ProjectAndDemo;

public class ParamDemo {
    public static void main(String[] args) {
//        可变参数：
        show();
        show(1,2,3,4,5,6,7,8,9,10);
        show(new int[]{1,2,3,4,5,6,7,8,9,10});
    }
//    可变参数只能有一个，而且只能是参数列表的最后一个参数
    public static void show(int... a) {
//        内部怎么拿数据
//        可变参数对内其实就是一个数组，a就是数组
        for (int i : a) {
            System.out.println(i);
        }
    }
}
