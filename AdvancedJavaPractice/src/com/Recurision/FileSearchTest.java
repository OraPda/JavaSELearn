package com.Recurision;

import java.io.File;
import java.io.IOException;

public class FileSearchTest {
    public static void main(String[] args) throws IOException {
//        搜索D盘下文件
        File file = new File("D:\\");
        SearchFile(file, "JavaStudy.md");
    }

    /**
     * 递归搜索文件
     * @param file
     * @param fileName
     */
    public static void SearchFile(File file, String fileName) throws IOException {
//        1.判断极端情况
        if (file ==  null || !file.exists() || file.isFile()){
            return;  //不搜索
        }
//        2.获取文件下所有一级文件对象或文件夹
        File[] files = file.listFiles();
//         3.判断当前目录下是否存在一级文件对象,存在则进行遍历
        if (files != null && files.length > 0){
            for (File f : files){
                if (f.isFile() && f.getName().contains(fileName)){
                    System.out.println(f.getAbsoluteFile());
                    Runtime.getRuntime().exec("notepad.exe " + f.getAbsolutePath());
                }
                if (f.isDirectory()){
                    SearchFile(f,fileName);
                }
            }
        }
    }
}
