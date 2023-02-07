package com.study.effectivejava.common.service;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ProductService implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("className")
    private String className;

    public static final ProductService INSTANCE = new ProductService();

    private ProductService(){
        System.out.println("private Constructor");
    }

    public static ProductService getInstance(){
        System.out.println("Create");
        return INSTANCE;
    }

    private Object readResolve() {
        System.out.println("readResolve");
        return INSTANCE;
    }
}
