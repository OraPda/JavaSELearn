package com.Net.UDPClient;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServerDemo {

    public static void main(String[] args) throws Exception {
        System.out.println("服务器启动了");
        //    创建一个UDP服务器
//       1.创建接受数据的Socket对象
        DatagramSocket socket = new DatagramSocket(8080);
//        创建一个数据包对象负责接收数据
        byte[] bytes = new byte[1024 * 64];
//        接收数据
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        socket.receive(packet);
//        看看接收到的数据
//        获取当前收到的数据长度
        int length = packet.getLength();
        System.out.println(new String(packet.getData(), 0, length));

//        获取对方的IP
        InetAddress address = packet.getAddress();
        System.out.println(address.getHostAddress());
        System.out.println(packet.getPort());
        socket.close();
    }
}
