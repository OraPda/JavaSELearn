package com.IO;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamDemo1 {
    public static void main(String[] args) throws Exception {
//    掌握文件字节输入流读取文件中的字节数组到内存中
//        1.创建文件字节输入流管道与源文件接通
        InputStream is = new FileInputStream("D:\\java练习\\NumberHuaRongDao\\src\\NumberHuaRongDao.java");
//        2.开始读取文件中的字节并输出
//        定义字节数组用于每次读取字节
        byte[] buffer = new byte[8192];
//        定义变量记住每次读取了多少个字节，
        int b;
        while ((b = is.read(buffer)) != -1) {
            System.out.print(new String(buffer, 0, b));
//            System.out.print(buffer);
        }
        is.close();
//        每次读取多个字节，性能提升，因为每次读取多个字节，可以减少硬盘和内存的交互，提高效率
//        依然无法避免读取汉字输出乱码问题，存在截断汉字字节的问题。
    }
}
