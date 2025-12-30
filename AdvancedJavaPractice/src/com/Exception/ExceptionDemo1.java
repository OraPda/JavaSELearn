package com.Exception;

import java.util.Scanner;

public class ExceptionDemo1 {
    public static void main(String[] args) {
//        自定义异常类
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入年龄：");
            int age = scanner.nextInt();
            checkAge(age);
        } catch (AgeException e) {
            throw new RuntimeException(e);
        }

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入年龄：");
            int age = scanner.nextInt();
            checkAge1(age);
        } catch (AgeException1 e) {
           e.printStackTrace();
        }

    }

//    需求：年龄不可以小于0或者大于200岁，否则抛出异常
    public static void checkAge(int age) throws AgeException {
        if(age < 0 || age > 200){
            throw new AgeException("年龄范围不对");
        }
        else System.out.println("年龄范围正确");
    }
    public static void checkAge1(int age) throws AgeException1 {
        if(age < 0 || age > 200){
            throw new AgeException1("年龄范围不对");
        }
        else System.out.println("年龄范围正确");
    }
}
class AgeException extends Exception{
    public AgeException(String message) {
        super(message);
    }
}

class AgeException1 extends RuntimeException{
    public AgeException1(String message) {
        super(message);
    }
}