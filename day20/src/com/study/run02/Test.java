package com.study.run02;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        ArrayList<Animal> animals = new ArrayList<>();
        Animal cock = new Cock("战斗鸡",0.8);
        Animal rabbit = new Rabbit("彼得兔",0.5);
        Animal turtle = new Turtle("忍者神龟",0.1);
        animals.add(cock);
        animals.add(rabbit);
        animals.add(turtle);
        for (Animal animal : animals) {
            animal.start();
        }
        while (true){

            boolean flag = false;

            for (Animal animal : animals) {

                // 判断是否有动物到达终点
                if(!animal.isAlive()){
                    flag = true;
                }

            }

            if(flag){
                // 记录三个动物一共跑了多少米
                double sum = 0;

                // 所有动物停止跑动
                for (Animal animal : animals) {
                    sum += animal.currentMeter;
                    animal.suspend();

                }

                System.out.println("三只动物一共跑了" + String.format("%.1f", sum) + "米");
                return;
            }

        }

    }
}
