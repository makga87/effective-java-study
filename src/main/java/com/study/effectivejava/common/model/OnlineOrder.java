package com.study.effectivejava.common.model;

public class OnlineOrder extends Order {

    protected OnlineOrder(Product product) {
        super(product);
    }

    public static OnlineOrder from(Product product) {
        return new OnlineOrder(product);
    }

    @Override
    public int getPayment() {
        return (int) (product.getPrice() - (product.getPrice() * 0.1));
    }
}
