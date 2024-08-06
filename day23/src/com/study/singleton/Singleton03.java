package com.study.singleton;

/*饿汉式*/
public class Singleton03 {

    private static final Singleton03 singleton;

    static {
        singleton = new Singleton03();
    }

    private Singleton03() {
    }

    public static Singleton03 getSingleton(){
        return singleton;
    }
}
