package com.study.proxy;

/**
 * 目标类 : 房东
 */
public class MyClassProxy02 implements MyInterface{

    @Override
    public void findHouse() {
        System.out.println("2. 签合同");
    }
}
