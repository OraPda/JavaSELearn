package com.Net.UDPClient;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClientDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动了");
        DatagramSocket socket = new DatagramSocket();
        byte[] bytes = "我是客户端，约你今晚啤酒龙虾，小烧烤".getBytes();
        /**
         * 参数一：发送的数据，字节数组
         * 参数二：发送的字节长度
         * 参数三：指定发送的目标地址
         * 参数四：指定发送的目标端口
         */
        try {
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(),8080);
//            让发送端对象发送数据包的数据
            socket.send(packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
