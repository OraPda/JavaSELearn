package com.ThreadSafetyDemo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private double money;
    private String cardId;

//    两人都在这里取钱
    public void drawMoney(double d) {
        synchronized (this) {
            if (d <= money) {
                System.out.println(Thread.currentThread().getName() + "取钱成功，取钱金额：" + d);
                money -= d;
                System.out.println("余额为：" + money);
            } else {
                System.out.println(Thread.currentThread().getName() + "取钱失败，余额不足");
            }
        }
    }
}
