package com.Thread.Lock;

import com.ThreadSafetyDemo.Account;
import com.ThreadSafetyDemo.DrawThread;

public class ThreadSafetyDemo2 {
    public static void main(String[] args) {
//        1.设计一个账户类，存入10万元。
        Account1 account1 = new Account1(100000, "ICBC-110");
//        设计线程类，创建2个线程，模拟两人同时在同一个账户中取钱
        new DrawThread1("小明", account1).start();
        new DrawThread1("小红", account1).start();
    }
}
