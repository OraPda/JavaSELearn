package com.Thread;

public class CreateTest {
//    main方法本身是由一条主线程执行的。

    public static void main(String[] args) {
//       掌握创建线程的方式一：继承Thread类
//        定义一个字类继承Thread类，成为线程类
        MyThread myThread = new MyThread();
//       调用线程类的start方法启动线程
        myThread.start();

        for (int i = 0; i < 5; i++){
            System.out.println("主线程启动了" + i);
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            System.out.println("子线程启动了" + i);
        }
    }
}
