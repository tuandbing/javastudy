package com.study.thread;

public class YieldTest extends Thread{

    public static void main(String[] args) {
        // 创建线程对象
        YieldTest threadTest01 = new YieldTest();
        YieldTest threadTest02 = new YieldTest();

        // 设置线程名称
        threadTest01.setName("t1");
        threadTest02.setName("t2");

        // 开启线程
        threadTest01.start();
        threadTest02.start();

    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i % 5 == 0) {
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName() + "==>" + i);
        }
    }
}
