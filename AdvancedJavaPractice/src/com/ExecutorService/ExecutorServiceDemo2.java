package com.ExecutorService;

import java.util.concurrent.*;

public class ExecutorServiceDemo2 {
    public static void main(String[] args) {
//        创建线程池对象
//        1.使用工具类Executor来创建线程池对象
        ExecutorService threadPoolDemo = Executors.newFixedThreadPool(5);

        Future<String> f1 = threadPoolDemo.submit(new MyCallableDemo(100));
        Future<String> f2 = threadPoolDemo.submit(new MyCallableDemo(200));
        Future<String> f3 = threadPoolDemo.submit(new MyCallableDemo(300));
        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
