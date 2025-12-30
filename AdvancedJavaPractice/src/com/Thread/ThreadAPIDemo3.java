package com.Thread;

public class ThreadAPIDemo3 {
    public static void main(String[] args) {
//        线程的join方法，线程插队，插队线程会等待插队线程执行完毕，再执行自己
        Thread myThreadAPIDemo1 = new MyThreadAPIDemo1("线程1");
        myThreadAPIDemo1.start();

        for (int i = 1; i < 5; i++){
            System.out.println(Thread.currentThread().getName()+"主线程启动了" + i);
            if (i == 2){
                try{
                    myThreadAPIDemo1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class MyThreadAPIDemo1 extends Thread{
    public MyThreadAPIDemo1(String  name){
        super(name);    // public Thread(String name)
    }
    @Override
    public void run() {
        for (int i = 1; i < 5; i++){
            System.out.println(Thread.currentThread().getName()+"线程启动了" + i);
        }
    }
}