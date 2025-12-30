package com.ExecutorService;

import java.util.concurrent.*;

public class ExecutorServiceDemo1 {
    public static void main(String[] args) {
//        创建线程池对象
//        1.使用实现类ThreadPoolExecutor声明七个参数来创建线程池对象
        ThreadPoolExecutor threadPoolDemo = new ThreadPoolExecutor(3,5
        ,10, TimeUnit.SECONDS,new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
//        Callable target = new MyCallableDemo(100);
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

//        关闭线程池，一般不关闭线程池
//        threadPoolDemo.shutdown(); //等所有任务执行完毕，再关闭线程池
//        threadPoolDemo.shutdownNow(); //不等所有任务执行完毕，就关闭线程池
    }
}
