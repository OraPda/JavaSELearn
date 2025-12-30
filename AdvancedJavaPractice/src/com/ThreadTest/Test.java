package com.ThreadTest;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        红包雨游戏，某企业有100名员工，
//        要求共计发出200个红包，其中小红包在【1-30】元之间，占比80%，大红包在【31-100】元之间，占比20%
        List<Integer> list = getRedPacket();
//        2.定义线程类，创建100个线程，竞争200个红包
        for (int i = 0; i < 100; i++) {
            new GetRedPacket(list,"人"+i).start();
        }
    }
//    准备200个红包，放到一个集合中
    public static List<Integer> getRedPacket(){
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 200; i++) {
            if (i < 160) {
                list.add((int)(Math.random() * 30 + 1));
            } else {
                list.add((int)(Math.random() * 70 + 31));
            }
        }
        return list;
    }
}
