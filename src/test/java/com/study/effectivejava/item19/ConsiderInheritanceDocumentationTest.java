package com.study.effectivejava.item19;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsiderInheritanceDocumentationTest {

    @DisplayName("부모 객체 생성자에 재정의가능 메서드를 호출하는 경우, 자식 객체에서 재정의 후, 호출 시 동작을 확인한다.")
    @Test
    void inheritanceConstructorTest(){
        System.out.println("==== 자식객체에서 재정의메서드 호출 ====");
        Sub sub = new Sub();
        sub.overrideMe();

        System.out.println("==== 자식객체를 생성해 부모객체로 받는 경우 ====");
        Super sup = new Sub();

    }
}