package com.Net.HTTPClient;

import java.net.ServerSocket;
import java.net.Socket;

public class HTTPClientDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("服务器启动了");
        ServerSocket socket = new ServerSocket(8080);
        while (true) {
            Socket client = socket.accept();
            System.out.println("一个客户端上线了"+client.getInetAddress().getHostAddress());
//            将这个客户端管道交给一个线程处理
            new ServerReader(client).start();
        }
    }
}
