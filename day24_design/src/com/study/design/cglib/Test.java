package com.study.design.cglib;

public class Test {

    public static void main(String[] args) {

        CglibImpl proxy = (CglibImpl)new CreateCglib(new CglibImpl()).getProxy();

        proxy.method();

    }

}
