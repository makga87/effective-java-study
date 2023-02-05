package com.study.effectivejava.common.model;

public class Product {

    private int price;

    private Product() {
    }

    private Product(int price) {
        this.price = price;
    }

    public static Product valueOf(int price) {
        return new Product(price);
    }

    public int getPrice() {
        return this.price;
    }
}
