package com.study.run;

public class Turtle extends Thread{

    private final Rabbit rabbit;

    private final double speed;

    public Turtle(String name, Rabbit rabbit, double speed) {
        super(name);
        this.rabbit = rabbit;
        this.speed = speed;
    }

    @Override
    public void run() {



        for (int i = 0; i < 100; i+=speed) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(getName() + "跑了" + (i + speed) + "米");

        }

        System.out.println(getName() + "跑完了全程~~");

        System.out.println(getName() + "唤醒了" + rabbit.getName());
        rabbit.resume();
    }
}
