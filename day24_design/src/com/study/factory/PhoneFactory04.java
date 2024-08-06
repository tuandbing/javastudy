package com.study.factory;

public class PhoneFactory04 {
   public Phone getPhone(String phoneName){

       if(phoneName.equals("mi")){
           return new Mi();
       } else if (phoneName.equals("huawei")) {
           return new HuaWei();
       } else if (phoneName.equals("iphone")) {
           return new iPhone();
       }

        return null;
   }
}
