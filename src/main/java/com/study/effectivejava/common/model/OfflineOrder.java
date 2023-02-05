package com.study.effectivejava.common.model;

public class OfflineOrder extends Order {

    private OfflineOrder(Product product){
        super(product);
    }

    public static OfflineOrder from(Product product) {
        return new OfflineOrder(product);
    }

    @Override
    public int getPayment() {
        return product.getPrice();
    }
}
