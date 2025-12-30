package com.Thread;

public class CreateTest1 {
    public static void main(String[] args) {
//        掌握创建线程的第二种方式，通过实现Runnable接口
//        1.定义一个线程任务类实现Runnable接口
        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();

        for (int i = 0; i < 5; i++){
            System.out.println("主线程启动了" + i);
        }
    }
}
class MyRunnable implements Runnable{
//    重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            System.out.println("子线程启动了" + i);
        }
    }
}
