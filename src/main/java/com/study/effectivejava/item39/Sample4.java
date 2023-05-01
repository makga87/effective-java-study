package com.study.effectivejava.item39;

import java.util.ArrayList;
import java.util.List;

public class Sample4 {

    @ExceptionRepeatableTest(IndexOutOfBoundsException.class)
    @ExceptionRepeatableTest(NullPointerException.class)
    public static void doublyBad() { // 성공해야한다
        List<String> list = new ArrayList<>();

        // NullPointerException을 던질 수 있다.
        list.addAll(5, null);
    }

}
