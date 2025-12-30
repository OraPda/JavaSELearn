package com.Junit;

public class StringUtil {
    public static void printNumber(String n){
        if (n == null || n.equals( "")){
            System.out.println("输入的字符串为空");
            return;
        }
        System.out.println("长度是：" + n.length());
    }

    /**
     * 求字符串的最大索引
     */
    public static int printMaxIndex(String n){
        if (n == null || n.equals( "")){
            return -1;
        }
        return n.length();
    }
}
