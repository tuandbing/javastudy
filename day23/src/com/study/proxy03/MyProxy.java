package com.study.proxy03;

import java.lang.reflect.InvocationHandler;

public class MyProxy implements MyInterface{
    public InvocationHandler invocationHandler;

    public MyProxy(InvocationHandler invocationHandler) {
        this.invocationHandler = invocationHandler;
    }


    @Override
    public void method() {
        try {
            System.out.println("Open");
            Object invoke = invocationHandler.invoke(this, MyInterface.class.getMethod("method"), new Object[]{});
            System.out.println("Close");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
