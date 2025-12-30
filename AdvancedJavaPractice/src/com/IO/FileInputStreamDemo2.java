package com.IO;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamDemo2 {
    public static void main(String[] args) throws Exception {
//    掌握文件字节输入流读取文件中的字节数组到内存中
//        1.创建文件字节输入流管道与源文件接通
        InputStream is = new FileInputStream("D:\\java练习\\AdvancedJavaPractice\\src\\Study1.txt");
//        2.开始读取文件中的字节并输出
        byte[] bytes = is.readAllBytes();
        System.out.println(new String(bytes));
        is.close();
    }
}
