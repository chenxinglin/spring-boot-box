package com.xing.aop;

//import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {

    public Test(){


        ClassLoader c = this.getClass().getClassLoader();
        Class ih = java.lang.reflect.InvocationHandler.class;
        Class p = java.lang.reflect.Proxy.class;
//        InvocationHandler ss = n

        // newProxyInstance(ClassLoader loader, Class[] interfaces, InvocationHandler h) {
//        Proxy.newProxyInstance(c, ih, );


    }

    public static void main(String[] args) {



    }
}
