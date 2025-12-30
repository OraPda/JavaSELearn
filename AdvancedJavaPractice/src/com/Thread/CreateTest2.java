package com.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateTest2 {
    public static void main(String[] args) throws Exception{
//        掌握线程的创建方式三：实现Callable接口，
//        2.创建一个Callable接口实现类对象
        MyCallable myCallable = new MyCallable(100);
//        3。将对象包装成一个FutureTask对象
        /*
        未来任务对象的作用：
                a.本质是一个Runnable线程任务对象，可以交给Thread线程对象处理
                b.可以获取线程执行结果
         */
        FutureTask<String> futureTask = new FutureTask<>(myCallable);    // public FutureTask(Callable<V> callable)
        new Thread(futureTask).start();

        try {
//            如果主线程发现第一个线程还没有执行完毕，会让出cpu，等第一个线程执行完毕，再获取结果
            System.out.println(futureTask.get());
        }catch (Exception e){
            e.printStackTrace();
        }

//        Runnable futureTask1 = new FutureTask<>(myCallable);    // public FutureTask(Callable<V> callable)
//        new Thread(futureTask1).start();
//        System.out.println(((FutureTask<String>) futureTask1).get());


    }
}

//1.定义一个类实现Callable接口
class  MyCallable implements Callable<String> {
    private int n;
    public MyCallable(int n){
        this.n = n;
    }
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += i;
        }
        return "子线程计算出的结果：" + sum;
    }
}
