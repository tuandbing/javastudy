package com.work;

public class Order {

    private int id;

    private int num;

    private double price;

    private String identifier;

    private boolean isPay = false;

    private String evaluate = "";

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", num=" + num +
                ", price=" + price +
                ", identifier='" + identifier + '\'' +
                ", isPay=" + isPay +
                ", evaluate='" + evaluate + '\'' +
                '}';
    }

    public Order(int id, int num, double price) {
        this.id = id;
        this.num = num;
        this.price = price;
    }

    public boolean isPay() {
        return isPay;
    }

    public void setPay(boolean pay) {
        isPay = pay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Order(int id, int num, double price, String identifier) {
        this.id = id;
        this.num = num;
        this.price = price;
        this.identifier = identifier;
    }

    public Order() {
    }
}
