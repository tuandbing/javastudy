package com.study.factory;

public class iPhone implements Phone{
    @Override
    public void make() {
        System.out.println("生产了一部苹果手机");
    }
}
