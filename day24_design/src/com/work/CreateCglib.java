package com.work;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Scanner;

public class CreateCglib implements MethodInterceptor {

    private Object object;

    public CreateCglib(Object object) {
        this.object = object;
    }

    public Object getProxy() {

        Enhancer enhancer = new Enhancer();

        // 设置目标对象
        enhancer.setSuperclass(Consumer.class);

        // 设置回调函数
        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return method.invoke(object, objects);
    }
}
