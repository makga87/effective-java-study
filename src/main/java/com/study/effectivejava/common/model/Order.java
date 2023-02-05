package com.study.effectivejava.common.model;

public abstract class Order {

    protected Product product;

    private Order() {
    }

    protected Order(Product product) {
        this.product = product;
    }

    public static Order of(Product product, OrderType orderType) {
        if (OrderType.OFFLINE == orderType) return OfflineOrder.from(product);
        if (OrderType.ONLINE == orderType) return OnlineOrder.from(product);
        throw new IllegalArgumentException("Not supported order type");
    }

    public abstract int getPayment();

    public static OfflineOrder getOfflineOrder(Product product) {
        return OfflineOrder.from(product);
    }

    public static OnlineOrder getOnlineOrder(Product product) {
        return OnlineOrder.from(product);
    }
}
