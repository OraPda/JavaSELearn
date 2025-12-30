package com.ThreadSafetyDemo;

public class ThreadSafetyDemo1 {
    public static void main(String[] args) {
//        1.设计一个账户类，存入10万元。
        Account account = new Account(100000, "ICBC-110");
//        设计线程类，创建2个线程，模拟两人同时在同一个账户中取钱
        new DrawThread("小明", account).start();
        new DrawThread("小红", account).start();
    }
}
