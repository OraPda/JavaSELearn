package com.Thread;

public class CreateTest1_1 {
    public static void main(String[] args) {
//        掌握创建线程的第二种方式，通过实现Runnable接口
//        1.定义一个线程任务类实现Runnable接口

        new Thread(() -> {
            for (int i = 0; i < 5; i++){
                System.out.println("子线程启动了" + i);
            }
        }).start();

        for (int i = 0; i < 5; i++){
            System.out.println("主线程启动了" + i);
        }
    }
}
