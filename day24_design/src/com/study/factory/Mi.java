package com.study.factory;

public class Mi implements Phone{
    @Override
    public void make() {
        System.out.println("生产了一部小米手机");
    }
}
