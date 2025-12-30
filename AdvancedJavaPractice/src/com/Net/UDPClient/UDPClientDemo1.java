package com.Net.UDPClient;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPClientDemo1 {
    public static void main(String[] args) throws Exception {
//        多发多收
        System.out.println("客户端启动了");
        DatagramSocket socket = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请说：");
            String msg = sc.nextLine();
            byte[] bytes = msg.getBytes();
            if ("exit".equals(msg)) {
                System.out.println("客户端退出");
                socket.close();
                break;
            }
            try {
                DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(),8080);
    //            让发送端对象发送数据包的数据
                socket.send(packet);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }

}
