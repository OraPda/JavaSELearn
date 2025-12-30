package com.Net.HTTPClient;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class HTTPClientDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("服务器启动了");
        ServerSocket socket = new ServerSocket(8080);
//        创建线程池
        ExecutorService executorService = new ThreadPoolExecutor(3,10,10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        while (true) {
            Socket client = socket.accept();
            System.out.println("一个客户端上线了"+client.getInetAddress().getHostAddress());
//            将这个客户端管道包装成任务，交给线程池 处理
            executorService.submit(new ServerReader1(client));
        }
    }
}
