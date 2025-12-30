package com.ExecutorService;

import java.util.concurrent.Callable;

public class MyCallableDemo implements Callable<String> {
    private int n;
    public MyCallableDemo(int n) {
        this.n = n;
    }

    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += i;
        }
        return Thread.currentThread().getName()+"线程计算1-" + n + "的结果：" + sum;
    }
}
