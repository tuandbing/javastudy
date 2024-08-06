package com.study.proxy02;

public class Test {

    public static void main(String[] args) {

        CreateProxy createProxy = new CreateProxy(new MyClassProxy());

        MyInterface proxy = (MyInterface) createProxy.getProxy();

        proxy.method01();
        proxy.method02();
        proxy.method03();
        proxy.test("卷狗佩奇");

    }

}
