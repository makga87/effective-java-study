package com.study.effectivejava.item52;

import org.junit.jupiter.api.Test;

import java.util.List;

public class OverrideTest {

    @Test
    void overrideTest(){
        List<Wine> wines = List.of(new Wine(), new SparklingWine(), new Champagne());

        for (Wine wine : wines) {
            System.out.println(wine.name());
        }
    }
}
