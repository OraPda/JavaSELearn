package com.ExecutorService;

import java.util.concurrent.*;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
//        创建线程池对象
//        1.使用实现类ThreadPoolExecutor声明七个参数来创建线程池对象
        ThreadPoolExecutor threadPoolDemo = new ThreadPoolExecutor(3,5
        ,10, TimeUnit.SECONDS,new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        Runnable target = new MyRunnableDemo();
        threadPoolDemo.execute(target);
        threadPoolDemo.execute(target);
        threadPoolDemo.execute(target);

        threadPoolDemo.execute(target);
        threadPoolDemo.execute(target);
        threadPoolDemo.execute(target);
        threadPoolDemo.execute(target);   //临时添加的线程，会执行，但是会报异常
        threadPoolDemo.execute(target);   //临时添加的线程，会执行，但是会报异常
        threadPoolDemo.execute(target);   //拒绝，丢弃任务并抛异常

//        关闭线程池，一般不关闭线程池
//        threadPoolDemo.shutdown(); //等所有任务执行完毕，再关闭线程池
//        threadPoolDemo.shutdownNow(); //不等所有任务执行完毕，就关闭线程池
    }
}
