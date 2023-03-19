package com.study.effectivejava.item20;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PriorInterfaceTest {

    @DisplayName("Comparable은 믹스인 인터페이스 검색용")
    @Test
    void mixinInterfaceTest() {
        Comparable comparable = new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }

    @DisplayName("추상 골격 구현 검색용")
    @Test
    void skeletalImplementationTest(){

        List list = new AbstractList() {
            @Override
            public Object get(int index) {
                return null;
            }
            @Override
            public int size() {
                return 0;
            }
        };
    }

    @DisplayName("단순 구현 검색용")
    @Test
    void simpleImplementationTest() {

        Map map = new AbstractMap() {
            @Override
            public Set<Entry> entrySet() {
                return null;
            }
        };
    }
}