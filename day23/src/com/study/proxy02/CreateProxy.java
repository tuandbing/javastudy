package com.study.proxy02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CreateProxy {

    private Object obj;

    public CreateProxy(Object obj) {
        this.obj = obj;
    }

    public Object getProxy(){

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invoke = null;
                if(method.getName().equals("test")){
                    invoke = method.invoke(obj,args);
                }else{
                    System.out.println("Open");
                    invoke = method.invoke(obj,args);
                    System.out.println("Close");
                }

                return invoke;

            }
        });

    }
}
