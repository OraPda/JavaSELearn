package com.Net.TCPClient;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class ServerReader extends  Thread{
    private Socket socket;

    public ServerReader(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            DataInputStream dis = new DataInputStream(inputStream);
            while (true) {
                String msg = dis.readUTF();
                System.out.println(msg);
                System.out.println(socket.getInetAddress().getHostAddress());
                System.out.println(socket.getPort());
                System.out.println("------------------------------------");
            }
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("客户端断开"+socket.getInetAddress().getHostAddress());
        }
    }
}
