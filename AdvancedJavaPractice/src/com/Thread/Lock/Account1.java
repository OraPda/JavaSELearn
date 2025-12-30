package com.Thread.Lock;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account1 {
    private double money;
    private String cardId;

//    定义锁
    private final Lock lk = new ReentrantLock();   //final 修饰锁对象，保证锁对象不会被修改

//    两人都在这里取钱
    public void drawMoney(double d) {
        lk.lock();
        try {
            if (d <= money) {
                System.out.println(Thread.currentThread().getName() + "取钱成功，取钱金额：" + d);
                money -= d;
                System.out.println("余额为：" + money);
            } else {
                System.out.println(Thread.currentThread().getName() + "取钱失败，余额不足");
            }
        } finally {
            lk.unlock();
        }

    }
}
