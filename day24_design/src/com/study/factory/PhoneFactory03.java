package com.study.factory;

public class PhoneFactory03 {
   public Mi getMi(){

       return new Mi();

   }
    public HuaWei getHuaWei(){

        return new HuaWei();

    }
    public iPhone getiPhone(){

        return new iPhone();

    }
}
