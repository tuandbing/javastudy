package com.study.proxy;

public class Test {
    public static void main(String[] args) {

        MyClassProxy02 myClassProxy02 = new MyClassProxy02();

        MyClassProxy myClassProxy = new MyClassProxy(myClassProxy02);

        myClassProxy.findHouse();

    }
}
