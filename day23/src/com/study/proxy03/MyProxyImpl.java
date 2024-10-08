package com.study.proxy03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxyImpl implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return method.invoke(new MyClassProxy(), args);
    }
}
