package com.study.effectivejava.item4;

import org.springframework.util.Assert;

public class PrivateConstructor {

    private PrivateConstructor(){
        throw new AssertionError("허용하지 않는 객체 생성 방식");
    }
}
