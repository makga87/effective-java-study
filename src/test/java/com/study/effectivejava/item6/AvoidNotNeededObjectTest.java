package com.study.effectivejava.item6;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AvoidNotNeededObjectTest {

    @Test
    void booleanTest() {
        /*
        이미 생성된 객체를 반환한다
        new WrapperClass(value) 방식은 java 9버전에 deprecated됨
         */
        boolean is = Boolean.valueOf("true");
    }

    @Test
    void stringMathcesTest() {
        /*
        아래의 코드의 matche를 따라가다보면, Pattern을 매번 new한다
        자주 호출 시, 아래 방법은 좋지 않다
        차라리 Pattern인스턴스를 클래스 초기화 과정에서 직접 생성해 캐싱하는 방식이 낫다
         */
        boolean matches = "test".matches("");
    }

    @Test
    void mapKeySetTest() {
        /*
        keySet 메서드 호출시 Set은 1번만 생성되도록, 되어 있음
         */
        HashMap map = new HashMap();
        map.keySet();
    }
}