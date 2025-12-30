package com.Thread.Lock;

import com.ThreadSafetyDemo.Account;

public class DrawThread1 extends  Thread{
    private Account1 account1; //记住线程对象要用的账户对象

    public DrawThread1(String name, Account1 account1) {
        super(name);
        this.account1 = account1;
    }

    @Override
    public void run() {
//        取钱
        account1.drawMoney(100000);
    }
}
