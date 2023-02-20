package com.study.effectivejava.item4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrivateConstructorTest {

    @DisplayName("private 생성자 뚫어보기")
    @Test
    void reflectionCreate() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<PrivateConstructor> constructor =  PrivateConstructor.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        PrivateConstructor privateConstructor = constructor.newInstance();

        Assertions.assertNotNull(privateConstructor);
    }
}