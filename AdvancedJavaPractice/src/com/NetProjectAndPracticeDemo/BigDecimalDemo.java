package com.NetProjectAndPracticeDemo;

import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {
        System.out.println(0.05+0.01);
//       为什么会失真？ 浮点数存储的时候，会进行四舍五入
//        使用BigDecimal  BigDecimal(String val)
        BigDecimal bd1 = new BigDecimal("0.05");
        BigDecimal bd2 = new BigDecimal("0.01");
        //优化
        BigDecimal a1 = BigDecimal.valueOf(0.05);
        BigDecimal a2 = BigDecimal.valueOf(0.01);
        System.out.println( (a1.add(a2)).doubleValue());
//        除法
        System.out.println(bd1.divide(bd2,2,BigDecimal.ROUND_HALF_UP));

    }
}
