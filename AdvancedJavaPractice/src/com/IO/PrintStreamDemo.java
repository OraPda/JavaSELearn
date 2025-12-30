package com.IO;

import java.io.*;

public class PrintStreamDemo {
    public static void main(String[] args) {
        try(
//                PrintStream ps = new PrintStream("AdvancedJavaPractice\\src\\Study.txt");
//                追加写
                PrintStream ps = new PrintStream(new FileOutputStream("AdvancedJavaPractice\\src\\Study.txt", true));
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("AdvancedJavaPractice\\src\\Study.txt"), "GBK"));
                ){
            ps.println("hello world");
            ps.println(123);
            ps.println(true);
            while (br.ready()){
                System.out.println(br.readLine());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
