package com.study.factory;

public class HuaWei implements Phone{
    @Override
    public void make() {
        System.out.println("生产了一部华为手机");
    }
}
