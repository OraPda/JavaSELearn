package com.Net.UDPClient;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServerDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("服务器启动了");
        //    创建一个UDP服务器
//       1.创建接受数据的Socket对象
        DatagramSocket socket = new DatagramSocket(8080);
//        创建一个数据包对象负责接收数据
        byte[] bytes = new byte[1024 * 64] ;
        while (true) {
//        接收数据
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            socket.receive(packet);
//        看看接收到数据
            System.out.println(new String(packet.getData(), 0, packet.getLength()));
            System.out.println(packet.getAddress().getHostAddress());
            System.out.println(packet.getPort());
            System.out.println("=======================");
        }
    }
}
