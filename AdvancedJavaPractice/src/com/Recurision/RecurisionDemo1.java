package com.Recurision;

public class RecurisionDemo1 {
    public static void main(String[] args) {
//        认识递归
        System.out.println(print(5));
        System.out.println(Monkey(1));
    }
    public static Long print(int n){
        if(n == 1){
            return 1L;
        }
        return print(n-1) + n;
    }
/*
    n 个
    第一天 n / 2 -1 个
    第二天 第一天 / 2 -1 个
    。。。10天   1个  终结点
    公式:  Monkey()
*/

    public static int Monkey(int day){
//        int count = 0;
        if(day == 10){
            return 1;
        }
        return 2 * Monkey(day + 1) +2;
    }
}