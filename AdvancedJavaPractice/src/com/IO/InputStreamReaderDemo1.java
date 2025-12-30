package com.IO;

import java.io.*;

public class InputStreamReaderDemo1 {
    public static void main(String[] args) throws IOException {
//        不同编码读取乱码的问题
        try(
//                1.先提取文件的原始字节流
//                InputStream is = new FileInputStream("AdvancedJavaPractice\\src\\Study.txt");
//                Reader isr = new InputStreamReader(new FileInputStream("AdvancedJavaPractice\\src\\Study.txt"), "GBK");
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("AdvancedJavaPractice\\src\\Study.txt"), "GBK"));
                ){
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
