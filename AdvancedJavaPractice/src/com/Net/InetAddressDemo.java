package com.Net;

import java.net.InetAddress;

public class InetAddressDemo {
    public static void main(String[] args) {
//        通过InetAddress类获取IP地址
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address);
            System.out.println(address.getHostName());
            System.out.println(address.getHostAddress());
            System.out.println(address.isLoopbackAddress());

            InetAddress[] addresses = InetAddress.getAllByName("www.baidu.com");
            for (InetAddress address1 : addresses) {
                System.out.println(address1);
                System.out.println(address1.getHostName());
                System.out.println(address1.getHostAddress());
                System.out.println(address1.isLoopbackAddress());
            }

            System.out.println(addresses[0].isReachable(5000));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
