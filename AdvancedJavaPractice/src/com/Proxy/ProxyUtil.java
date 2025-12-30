package com.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//代理工具类
public class ProxyUtil {
    //创建一个明星对象的代理对象返回
    public static StarService getProxyInstance(Star obj){
        /**
         * 参数一：用于执行用哪个类加载器去加载生成的代理类
         * 参数二：用于指定代理对象实现哪个接口
         * 参数三：用于提供代理对象方法调用的实现
         */
        StarService proxy = (StarService) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(),
                obj.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //用来声明代理要干的活
                        //参数一：代理对象本身
                        //参数二：代理对象要调用的方法
                        //参数三：代理对象要调用的方法的参数
                        if (method.getName().equals("sing")){
                            System.out.println("准备话筒，收钱20w");
                        } else if (method.getName().equals("dance")) {
                            System.out.println("准备场地，收钱100w");
                        }
                        //把明星对象叫过来干过
                        Object invoke = method.invoke(obj, args);
                        return invoke;
                    }
                });
        return proxy;
    }
}
