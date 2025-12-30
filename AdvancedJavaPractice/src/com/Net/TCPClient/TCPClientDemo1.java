package com.Net.TCPClient;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientDemo1 {
    public static void main(String[] args) {
//        使用TCP协议通信实现一收一发的客户端
//        1.常见的Socket管道对象，创建Socket对象，请求与服务器的Socket链接，可靠连接
        try {
            Socket socket = new Socket("127.0.0.1", 9999);
//        2.获取一个输出流，发送数据
            OutputStream os = socket.getOutputStream();
            //包装流
            DataOutputStream dos = new DataOutputStream(os);
            Scanner sc = new Scanner(System.in);
            while ( true){
                System.out.println("请输入：");
                String msg = sc.next();
                if ("exit".equals(msg)){
                    System.out.println("退出成功");
                    socket.close();
                    dos.close();
                    break;
                }
                dos.writeUTF(msg);
                dos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
