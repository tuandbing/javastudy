package com.work;

public interface Customer {
    Order orderGoods(int id,int num,double price);

    boolean pay(Order order,double money);

    boolean getGoods(Order order);

    boolean evaluate(Order order,String str);
}
