package com.study.run;

public class Rabbit extends Thread{


    private final double speed;

    public Rabbit(String name, double speed) {
        super(name);
        this.speed = speed;
    }

    @Override
    public void run() {


        for (int i = 0; i < 100; i += speed) {

            if(i == 80){
                System.out.println(getName() + "开始睡觉");
                Thread.currentThread().suspend();
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(getName() + "跑了" + (i + speed) + "米");



        }

        System.out.println(getName() + "跑完了全程");
    }
}
