package com.study.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest implements Callable {

    public static void main(String[] args) {

        FutureTask futureTask = new FutureTask(new CallableTest());
        Thread thread = new Thread(futureTask);
        thread.start();


        try {
            // 获取线程返回的结果
            Object o = futureTask.get();
            System.out.println("获取线程返回的结果为: " + o);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object call() throws Exception {

        int num = 0;

        for (int i = 1; i <= 20; i++) {
            num+=i;
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() + "==>" + i);
        }

        return num;
    }
}
