package com.study.proxy02;




public class MyClassProxy implements MyInterface {



    @Override
    public void method01() {
        System.out.println("It's OK 01");
    }

    @Override
    public void method02() {
        System.out.println("It's OK 02");

    }

    @Override
    public void method03() {
        System.out.println("It's OK 03");

    }

    @Override
    public String test(String data) {
        System.out.println(data);
        return data;
    }
}
