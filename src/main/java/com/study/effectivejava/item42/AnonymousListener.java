package com.study.effectivejava.item42;

public class AnonymousListener implements Listener {
    @Override
    public void handle() {
        System.out.println(this.getClass().getName());
    }
}
