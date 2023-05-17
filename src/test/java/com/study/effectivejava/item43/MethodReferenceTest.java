package com.study.effectivejava.item43;


import autovalue.shaded.com.google.common.base.Function;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class MethodReferenceTest {

    @Test
    void methodReferenceTest() {
        Instant instant1 = Instant.now();
        Instant instant2 = Instant.now();
        Instant instant3 = Instant.now();
        Stream.of(instant1, instant2, instant3)
                .map(Instant.now()::isAfter)
                .forEach(instant -> {

                });

    }

    @Test
    void genericFucntionTypeTest1() {

        G1 g1 = new G1() {
            @Override
            public <E extends Exception> Object m() throws E {
                List list = new ArrayList<>();
                return list;
            }
        };


        G2 g2 = new G2() {
            @Override
            public <F extends Exception> String m() throws Exception {
                return "test";
            }
        };

        G g = new G() {
            @Override
            public <F extends Exception> String m() throws F {
                return null;
            }
        };
    }

//  /*  @Test
//    void genericFunctionTypeTest2() {
//        G g = String::new;
//        G _g = () -> new String();
//    }
//
//    @Test
//    void genericFunctionTypeTest3() {
//        G g = Object::new;
//        G _g = () -> new Object();
//    }*/
}