package com.Thread;

public class ThreadAPIDemo1 {
    public static void main(String[] args) {
        Thread myThreadAPIDemo = new MyThreadAPIDemo("线程0");
        myThreadAPIDemo.start();
       // 默认名称:Thread-索引
        System.out.println(myThreadAPIDemo.getName());

        Thread myThreadAPIDemo1 = new MyThreadAPIDemo("线程1");
        myThreadAPIDemo1.start();


        Thread m2 = Thread.currentThread();
        System.out.println(m2.getName());

        for (int i = 0; i < 5; i++){
            System.out.println("主线程启动了" + i);

        }
    }
}
class MyThreadAPIDemo extends Thread{
    public MyThreadAPIDemo(String  name){
        super(name);    // public Thread(String name)
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            System.out.println(Thread.currentThread().getName()+"线程启动了" + i);
        }
    }
}
