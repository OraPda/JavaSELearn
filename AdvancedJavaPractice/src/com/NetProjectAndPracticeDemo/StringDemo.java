package com.NetProjectAndPracticeDemo;

public class StringDemo {
    public static void main(String[] args) {
//        高效拼接字符串
        String s1 = "hello";
        String s2 = "world";
        String s3 = s1 + s2;
        System.out.println(s3);

        StringBuilder sb = new StringBuilder();
        sb.append(s1).append(s2);
        System.out.println(sb);

    }
}
