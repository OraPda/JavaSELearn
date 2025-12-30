package com.Net.TCPClient;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("服务器启动了");
        ServerSocket socket = new ServerSocket(8080);
        while (true) {
            Socket client = socket.accept();
            InputStream inputStream = client.getInputStream();
            DataInputStream dis = new DataInputStream(inputStream);
            int id = dis.readInt();
            String msg = dis.readUTF();
            System.out.println("id" + id + "说：" + msg);
            System.out.println(client.getInetAddress().getHostAddress());
            System.out.println(client.getPort());


        }
    }
}
