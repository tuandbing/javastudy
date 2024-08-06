package com.study.factory;

public class PhoneFactory02{
   public static Mi getMi(){

       return new Mi();

   }
    public static HuaWei getHuaWei(){

        return new HuaWei();

    }
    public static iPhone getiPhone(){

        return new iPhone();

    }
}
