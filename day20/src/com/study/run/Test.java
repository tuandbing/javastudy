package com.study.run;

public class Test {
    public static void main(String[] args) {

        Rabbit rabbit = new Rabbit("佩奇兔",10);

        Turtle turtle = new Turtle("忍者龟",rabbit,5);

        rabbit.start();

        turtle.start();

    }
}
