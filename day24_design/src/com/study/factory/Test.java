package com.study.factory;

public class Test {

    public static void main(String[] args) {

        PhoneFactory phoneFactory = new PhoneFactory();

        Phone phone = phoneFactory.make("com.study.factory.iPhone");

        phone.make();

    }

}
