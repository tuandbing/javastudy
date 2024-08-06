package com.study.thread;

public class DaemonTest extends Thread{

    // 创建线程对象
    public static void main(String[] args) {
        DaemonTest daemonTest = new DaemonTest();

        // 设置线程名称
        daemonTest.setName("t1");

        daemonTest.setDaemon(true);

        daemonTest.start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "==>" + i);
        }


    }


    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "守护");
        }

    }
}
