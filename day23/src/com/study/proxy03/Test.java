package com.study.proxy03;

public class Test {
    public static void main(String[] args) {
        MyProxy myProxy = new MyProxy(new MyProxyImpl());

        myProxy.method();
    }
}
