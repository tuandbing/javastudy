package com.study.run02;

public class Cock extends Animal{


    public Cock(String name, double speed) {
        super(name,speed);
    }

    @Override
    public void run() {


        while (currentMeter < allMeter) {

            if(timer != 0 && timer % 3 == 0){
                System.out.println(getName() + "开始吃虫子");
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            currentMeter += speed;
            System.out.println(getName() + "跑了" + String.format("%.1f", currentMeter) + "米");

        }

        System.out.println(getName() + "跑完了全程,获得了胜利");
    }
}
