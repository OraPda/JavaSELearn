package com.File;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
//        1.创建File对象代表文件（文件/目录），搞清楚其提供的对文件进行操作的方法
        File file = new File("C:\\Users\\杨\\Pictures\\1561.jpg");
        System.out.println(file.getName());
        System.out.println(file.length());
//        2.可以使用相对路径定位文件对象
//        只要带盘符的都称之为绝对路径
//        相对路径：不带盘符的。默认是到idea工程下直接寻找文件的。一般用来找工程下的项目文件。
        File file1 = new File("1561.jpg");
        File file2 = new File("java练习\\JavaStudy.md");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.length());
//        3.创建对象代表不存在的文件路径
//        File file3 = new File("D:\\java练习\\JavaStudy\\1561.txt");
//        System.out.println(file3.exists());
//        System.out.println(file3.createNewFile());

//        4.创建对象代表不存在的目录路径
        File file4 = new File("D:\\java练习\\JavaStudy\\File");
        System.out.println(file4.exists());
        System.out.println(file4.mkdir());
//        5.创建对象代表存在的文件或目录  只能删除空文件夹，并不会进回收站
        File file5 = new File("D:\\java练习\\JavaStudy\\File\\1561.txt");
        System.out.println(file5.exists());
//        System.out.println(file5.delete());

//        可以获取某个目录下的全部一级文件名称
        File file6 = new File("D:\\java练习");
        String[] list = file6.list();
        for (String s : list) {
            System.out.println(s);
        }
        File[] listFiles = file6.listFiles();
        for (File files : listFiles) {
            System.out.println(files.getAbsoluteFile());
        }

    }
}
