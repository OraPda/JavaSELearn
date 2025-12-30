package com.Genericity.GenericityDemo;

public class GenericDemo6 {
    public static void main(String[] args) {
/*
        目标: 泛型和集合不支持基本数据类型，只能支持对象类型（引用数据类型）
        泛型擦除：泛型在编译期间会被擦除掉，只保留类型变量，类型参数，所有类型会被替换成Object
        可用包装类来解决
        Byte === byte
        Integer === int
        Short === short
        Long === long
        Float === float
        Double === double
        Character === char
        Boolean === boolean
*/
        Integer i = Integer.valueOf(100);
        Integer j = Integer.valueOf(100);
        Integer k = Integer.valueOf(200);
        System.out.println(i == j);
        System.out.println(i == k);
//                自动装箱：基本数据类型的数据可以直接转换成对应的包装类对象
        Integer m = 100;
        Integer n = 130;
        System.out.println(m == n);
//        自动拆箱：包装类对象可以直接转换成对应的基本数据类型
        int x = m;
        System.out.println(x);

        System.out.println("==================================================================================");

//        包装类新增的功能
//        1.把基本类型数据转换成字符串
        int a = 100;
        String s1 = Integer.toString( a);
        String s = String.valueOf(100);
        System.out.println(s1);
        System.out.println(s);

        System.out.println("==================================================================================");

//        2.把字符串转换成基本数据类型
        String s2 = "123";
        int b = Integer.parseInt(s2);
        int c = Integer.valueOf(s2);
        System.out.println(b);
    }
}
