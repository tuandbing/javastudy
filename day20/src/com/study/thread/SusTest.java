package com.study.thread;

public class SusTest extends Thread{

    public static void main(String[] args) {

        // 创建线程对象
        SusTest threadTest01 = new SusTest();
        SusTest threadTest02 = new SusTest();

        // 设置线程名称
        threadTest01.setName("t1");
        threadTest02.setName("t2");

        // 开启线程
        threadTest01.start();
        threadTest02.start();
        for (int i = 0; i <= 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(i == 20){
                threadTest01.resume();
            }
            System.out.println(Thread.currentThread().getName() + "==>" + i);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "==>" + i);
            if(i == 10 && Thread.currentThread().getName().equals("t1")){
                Thread.currentThread().suspend();
            }
        }
    }
}
