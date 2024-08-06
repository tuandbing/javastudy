package com.study.proxy03;


import java.lang.reflect.InvocationHandler;

public class MyClassProxy implements MyInterface {

    @Override
    public void method() {
        System.out.println("核心业务");
        System.out.println("核心业务");
        System.out.println("核心业务");
        System.out.println("核心业务");
    }
}
