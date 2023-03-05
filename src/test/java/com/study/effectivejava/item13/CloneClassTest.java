package com.study.effectivejava.item13;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CloneClassTest {

    @DisplayName("배열의 clone 코드 확인용")
    @Test
    void arrayClone(){
        String[] args = {"a", "b", "c"};
        args.clone();
    }
}