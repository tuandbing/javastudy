package com.study.run02;

public class Animal extends Thread{

    protected double speed;

    protected final double allMeter = 20.0;

    protected double currentMeter = 0;

    protected int timer;

    public Animal(String name, double speed) {
        super(name);
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "speed=" + speed +
                ", allMeter=" + allMeter +
                ", currentMeter=" + currentMeter +
                ", timer=" + timer +
                '}';
    }
}
