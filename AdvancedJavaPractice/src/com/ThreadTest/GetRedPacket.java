package com.ThreadTest;

import java.util.List;

public class GetRedPacket extends  Thread{
    private List<Integer> list;
    public GetRedPacket(List<Integer> list, String s) {
        super(s);
        this.list = list;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        while (true) {
            synchronized (list){
                if (list.size() == 0) {
                    break;
                }
    //            随机一个索引取钱
                int index = (int)(Math.random() * list.size());
                Integer money = list.remove(index);
                System.out.println(name + "抢到红包：" + money + "元");
                if (list.size() == 0){
                    System.out.println("活动结束了");
                    break;
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
