package com.study.effectivejava.common.model;

public final class Product implements Cloneable {

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

    @Override
    public Product clone() {
        try{
            return (Product) super.clone();
        } catch (CloneNotSupportedException e){
            throw  new AssertionError();
        }
    }

}
