package com.Net.TCPClient;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientDemo {
    public static void main(String[] args) {
//        使用TCP协议通信实现一收一发的客户端
//        1.常见的Socket管道对象，创建Socket对象，请求与服务器的Socket链接，可靠连接
        try {
            Socket socket = new Socket("127.0.0.1", 8080);
//        2.获取一个输出流，发送数据
            OutputStream os = socket.getOutputStream();
            //包装流
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeInt(1);
            dos.writeUTF("hello,server");
//        3.关闭流
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
