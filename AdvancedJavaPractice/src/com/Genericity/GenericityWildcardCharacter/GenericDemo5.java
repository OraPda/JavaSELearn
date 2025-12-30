package com.Genericity.GenericityWildcardCharacter;

import java.util.ArrayList;

public class GenericDemo5 {
    public static void main(String[] args) {
/*         目标： 理解通配符和上下限
           通配符 就是“？” 可以在使用泛型的时候代表一切类型；ETKV 是在定义泛型的时候使用的
           上下限：
                1. <?> 表示任意类型
                2. <? extends E> 表示E或者E的子类
                3. <? super E> 表示E或者E的父类
*/
        ArrayList<Xiaomi> xiaomis = new ArrayList<>();
        xiaomis.add(new Xiaomi());
        xiaomis.add(new Xiaomi());
        xiaomis.add(new Xiaomi());
        play(xiaomis);
        ArrayList<BYD> byds = new ArrayList<>();
        byds.add(new BYD());
        byds.add(new BYD());
        byds.add(new BYD());
        play(byds);

    }
//    需求 ： 做一个极品飞车的模拟游戏
//    虽然Xiaomi和BYD都继承Car，但是ArrayList<Xiaomi>、ArrayList<BYD>与ArrayList<Car> 是不同的

    public static void play(ArrayList<? extends Car>  cars){

    }
}
