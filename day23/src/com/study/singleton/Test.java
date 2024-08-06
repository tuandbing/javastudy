package com.study.singleton;

public class Test {

    public static void main(String[] args) {
        System.out.println(Singleton01.getSingleton() == Singleton01.getSingleton());
        System.out.println(Singleton02.getSingleton() == Singleton02.getSingleton());
        System.out.println(Singleton03.getSingleton() == Singleton03.getSingleton());
    }

}
