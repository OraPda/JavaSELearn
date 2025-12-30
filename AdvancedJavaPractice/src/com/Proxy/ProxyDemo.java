package com.Proxy;

import java.lang.reflect.Proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        // 创建代理对象
        //1.准备一个明星对象，设计明星类
        Star star = new Star("章若楠");
        //2.为章若楠创建一个专属于他的代理对象
        StarService proxy = ProxyUtil.getProxyInstance(star);
        proxy.sing("《小苹果》");
        String dance = proxy.dance();
        System.out.println(dance);
    }
}
