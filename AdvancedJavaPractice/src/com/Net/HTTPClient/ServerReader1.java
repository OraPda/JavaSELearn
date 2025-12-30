package com.Net.HTTPClient;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ServerReader1 extends  Thread{
    private Socket socket;

    public ServerReader1(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html;charset=utf-8");
            ps.println();
            ps.println("<html>");
            ps.println("<head>");
            ps.println("<title>");
            ps.println("XiaoRui_CodeSpace");
            ps.println("</title>");
            ps.println("<body>");
            ps.println("<h1>欢迎来到我的服务器</h1>");
            ps.println("</body>");
            ps.println("</html>");
            ps.flush();
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("客户端断开"+socket.getInetAddress().getHostAddress());
        }
    }
}
