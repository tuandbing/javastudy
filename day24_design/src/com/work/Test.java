package com.work;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        List<Order> orders = new ArrayList<>();


        Customer proxy = (Consumer) new CreateCglib(new Consumer()).getProxy();
        Scanner scanner = new Scanner(System.in);
        while(true){

            System.out.println("请输入您的操作");
            System.out.println("1- 下单\t2- 支付");
            System.out.println("3- 取货\t4- 评价");
            System.out.println("5- 获取订单信息\t6- 退出");
            int choice = scanner.nextInt();
            int id;
            int num;
            double price;
            Order order = null;
            switch (choice){
                case 1:

                    System.out.println("请输入商品id");
                    id = scanner.nextInt();
                    System.out.println("请输入购买数量");
                    num = scanner.nextInt();
                    System.out.println("请输入商品价格");
                    price = scanner.nextDouble();
                    orders.add(new Order(id,num,price));
                    break;
                case 2:
                    System.out.println("请输入商品id");
                    id = scanner.nextInt();
                    System.out.println("请输入金额");
                    double money = scanner.nextDouble();
                    for (Order order1 : orders) {
                        if (order1.getId() == id){
                            order = order1;
                            break;
                        }
                    }
                    proxy.pay(order,money);
                    break;
                case 3:
                    System.out.println("请输入商品id");
                    id = scanner.nextInt();
                    for (Order order1 : orders) {
                        if (order1.getId() == id){
                            order = order1;
                            break;
                        }
                    }
                    proxy.getGoods(order);
                    break;
                case 4:
                    System.out.println("请输入商品id");
                    id = scanner.nextInt();
                    System.out.println("请输入评价");
                    String str = scanner.next();
                    for (Order order1 : orders) {
                        if (order1.getId() == id){
                            order = order1;
                            break;
                        }
                    }
                    proxy.evaluate(order,str);
                    break;
                case 5:
                    System.out.println("请输入商品id");
                    id = scanner.nextInt();
                    for (Order order1 : orders) {
                        if (order1.getId() == id){
                            System.out.println(order1);
                            break;
                        }
                    }
                case 6:
                    return;
            }


        }

    }

}
