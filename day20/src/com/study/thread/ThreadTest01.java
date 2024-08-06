package com.study.thread;

public class ThreadTest01 extends Thread{

    public static void main(String[] args) {

        // 创建线程对象
        ThreadTest01 threadTest01 = new ThreadTest01();
        ThreadTest01 threadTest02 = new ThreadTest01();

        // 设置线程名称
        threadTest01.setName("t1");
        threadTest02.setName("t2");

        // 开启线程
        threadTest01.start();
        threadTest02.start();

    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "==>" + i);
        }
    }
}
