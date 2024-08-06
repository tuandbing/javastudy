package com.work;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Consumer implements Customer {
    @Override
    public Order orderGoods(int id, int num, double price) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(System.currentTimeMillis());
        Random random = new Random();
        int number = random.nextInt(8999) + 1000;

        return new Order(id, num, price, formatter.format(date) + number);
    }

    @Override
    public boolean pay(Order order, double money) {

        System.out.println(money > order.getPrice() * order.getNum() ? "支付成功" : "金额不足,支付失败");
        if (money > order.getPrice() * order.getNum()) {
            order.setPay(true);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean getGoods(Order order) {

        if (!order.isPay()) {
            System.out.println("订单未支付,取货失败");
        } else {
            System.out.println("取货成功");
        }

        return order.isPay();
    }

    @Override
    public boolean evaluate(Order order, String str) {

        if (order.getEvaluate() == null || order.getEvaluate().equals("")) {
            order.setEvaluate(str);
            System.out.println("评价成功");
            return true;
        } else {
            System.out.println("您已经评价过了,评价失败");
            return false;
        }


    }
}
