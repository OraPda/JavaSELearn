package com.IO;

import java.io.*;

public class FileInputStreamDemo {
    public static void main(String[] args) throws Exception {
//    掌握文件字节输入流读取文件中的字节数组到内存中
//        1.创建文件字节输入流管道与源文件接通
        InputStream is = new FileInputStream("D:\\java练习\\AdvancedJavaPractice\\src\\Study.txt");
//        2.开始读取文件中的字节并输出
//        定义变量记住每次读取的一个字节，
        int b;
        while ((b = is.read()) != -1) {
            System.out.print((char) b);
        }
        is.close();
//        每次读取一个字节的问题：性能差，读取汉字输出一定是乱码
    }
}
