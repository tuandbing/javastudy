package com.study.run02;

public class Rabbit extends Animal{

    public Rabbit(String name, double speed) {
        super(name,speed);
    }

    @Override
    public void run() {


        while (currentMeter < allMeter) {

            if(currentMeter != 0 && currentMeter % 2 == 0){
                System.out.println(getName() + "开始休息");
                try {
                    Thread.sleep(10000);
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
