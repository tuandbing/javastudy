package com.study.design.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CreateCglib implements MethodInterceptor {

    private Object object;

    public CreateCglib(Object object) {
        this.object = object;
    }

    public Object getProxy() {

        Enhancer enhancer = new Enhancer();

        // 设置目标对象
        enhancer.setSuperclass(CglibImpl.class);

        // 设置回调函数
        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("开启事务");

        Object invoke = method.invoke(object, objects);

        System.out.println("关闭事务");

        return invoke;
    }
}
