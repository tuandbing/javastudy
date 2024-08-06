package com.study.thread;

public class ThreadTest03{
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "==>" + i);
                }
            }
        });
        thread.setName("t");

        thread.start();
    }
}
