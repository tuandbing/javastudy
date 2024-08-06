package com.study.factory;

public class PhoneFactory implements Factory{
    @Override
    public Phone make(String className) {

        try {
            Class aClass = Class.forName(className);
            Object instance = aClass.newInstance();

            if(instance instanceof Phone){
                return (Phone) instance;
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
