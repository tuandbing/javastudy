package com.study.thread;

public class JoinTest extends Thread{

    public static void main(String[] args) throws Exception {

        // 创建线程对象
        JoinTest threadTest01 = new JoinTest();
        JoinTest threadTest02 = new JoinTest();

        // 设置线程名称
        threadTest01.setName("t1");
        threadTest02.setName("t2");

        threadTest01.join();
        threadTest02.join();

        // 开启线程
        threadTest01.start();
        threadTest02.start();

        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "==>" + i);
        }

    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "==>" + i);
        }
    }
}
