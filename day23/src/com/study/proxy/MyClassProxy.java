package com.study.proxy;

/**
 * 代理类 : 中介
 */
public class MyClassProxy implements MyInterface{

    MyInterface myInterface;

    public MyClassProxy(MyInterface myInterface) {
        this.myInterface = myInterface;
    }

    @Override
    public void findHouse() {
        System.out.println("1. 看房");
        myInterface.findHouse();
        System.out.println("3. 收钱");
        System.out.println("4. 售后");
    }
}
