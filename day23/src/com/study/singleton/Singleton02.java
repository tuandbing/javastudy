package com.study.singleton;

/*懒汉式*/
public class Singleton02 {

    private volatile static Singleton02 singleton;

    private Singleton02() {
    }

    /**
     * synchronized 添加锁，保证线程安全
     * @return
     */
    public static Singleton02 getSingleton(){

        if (singleton == null){
            synchronized (Singleton02.class){
                if (singleton == null){
                    singleton = new Singleton02();
                }
            }
        }

        return singleton;
    }
}
