package com.IO;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) throws IOException {
//       使用字节流完成文件的复制操作
//        源文件： D:\\java练习\\AdvancedJavaPractice\\src\\Study.txt
//        目标路径： E:\\Study.txt
        copyFile("D:\\java练习\\AdvancedJavaPractice\\src\\Study.txt", "E:\\Study.txt");

    }
//    public static void copyFile(String srcPath, String destPath) throws IOException {
//        InputStream is = null;
//        OutputStream os = null;
//        try {
//            is = new FileInputStream(srcPath);
//            os = new FileOutputStream(destPath);
//            byte[] buffer = new byte[1024];
//            int b;
//            while ((b = is.read(buffer)) != -1) {
//                os.write(buffer, 0, b);
//            }
//        }
//        finally {
//            try {
//                if (os != null) os.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                if (is != null) is.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    public static void copyFile(String srcPath, String destPath) throws IOException {
        try (InputStream is = new FileInputStream(srcPath);
             OutputStream os = new FileOutputStream(destPath)
        ) {
            byte[] buffer = new byte[1024];
            int b;
            while ((b = is.read(buffer)) != -1) {
                os.write(buffer, 0, b);
            }
        }
    }
}
