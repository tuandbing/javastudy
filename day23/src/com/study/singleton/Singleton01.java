package com.study.singleton;

/*饿汉式*/
public class Singleton01 {

    private static final Singleton01 singleton = new Singleton01();

    private Singleton01() {
    }

    public static Singleton01 getSingleton(){
        return singleton;
    }
}
