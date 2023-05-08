package com.study.effectivejava.item42;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListenerTest {


    @DisplayName("익명 클래스와 람다식이 가리키는 this의 위치를 파악해본다")
    @Test
    void classNameTest(){
        listener(new AnonymousListener());
        listener(()-> System.out.println(this.getClass().getName()));
    }


    public void listener(Listener listener){
        listener.handle();
    }
}