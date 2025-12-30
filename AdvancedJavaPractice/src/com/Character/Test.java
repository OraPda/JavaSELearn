package com.Character;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        字符集的编解码
        String name = "我爱你中国";
        byte[] bytes = name.getBytes("GBK"); //指定GBK进行编码
        byte[] bytes1 = name.getBytes("UTF-32");
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes));

//        2.解码
        String name2 = new String(bytes,"GBK");
        System.out.println(name2);
    }
}
