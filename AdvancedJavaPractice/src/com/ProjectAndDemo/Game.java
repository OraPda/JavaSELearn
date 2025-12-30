package com.ProjectAndDemo;

public class Game {
    public static void main(String[] args) {
//        开发一个斗地主游戏
//        1.每张牌都是一个对象，定义牌类
//        2.每个游戏房间也是一个对象，定义房间类（54张牌，开始启动）
        Room room = new Room();
        room.start();
    }
}
