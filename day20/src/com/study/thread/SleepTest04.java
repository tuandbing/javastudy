package com.study.thread;

public class SleepTest04 extends Thread{

    public static void main(String[] args) {

        // 创建线程对象
        SleepTest04 threadTest01 = new SleepTest04();

        // 设置线程名称
        threadTest01.setName("t1");

        // 开启线程
        threadTest01.start();

    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + "==>" + i);
        }
    }
}
