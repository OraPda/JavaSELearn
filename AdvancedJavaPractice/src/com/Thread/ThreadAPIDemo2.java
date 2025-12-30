package com.Thread;

public class ThreadAPIDemo2 {
    public static void main(String[] args) {
//        线程休眠
        Thread m2 = Thread.currentThread();
        System.out.println(m2.getName());
        for (int i = 0; i < 5; i++){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"主线程启动了" + i);
        }
    }
}
