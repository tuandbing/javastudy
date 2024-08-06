package com.work;


import com.work.pojo.User;


public class Test {

    public static void main(String[] args) {

        CreateProxy createProxy = new CreateProxy(MyClassProxy.getMyClassProxy());

        MyInterface proxy = (MyInterface)createProxy.getProxy();

//        proxy.insert(new User(5,"佩奇","0816"));

        proxy.update(new User(5,"佩奇","sb"));


    }

}
