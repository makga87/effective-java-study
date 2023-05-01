package com.study.effectivejava.item38;

import org.junit.jupiter.api.Test;

import java.nio.file.CopyOption;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ExtendedOperationTest {

    @Test
    void test() {
        double x = 10;
        double y = 3;
        testApply1(ExtendedOperation.class, x, y);

        List<Operation> extendedOp = Arrays.asList(ExtendedOperation.values());
        List<Operation> basicOp = Arrays.asList(BasicOperation.values());
        testApply2(Stream.concat(extendedOp.stream(), basicOp.stream()).collect(Collectors.toList()), x, y);
    }

    /**
     * 자바 라이브러리에서도 사용한 이번 예제
     * java.nio.file.LinkOption, CopyOption, OpenOption
     */
    @Test
    void testExample(){
        LinkOption linkOption;
        CopyOption copyOption;
        OpenOption openOption;
    }


    /**
     * 한정적 타입 토큰
     */
    private static <T extends Enum<T> & Operation> void testApply1(Class<T> opEnumType, double x, double y) {
        for (Operation op : opEnumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

    /**
     * 한정적 와일드 카드 타입으로 변경 버전
     * 가독성도 유연함도 더 나아보인다
     * 반면, 특정연산에서 EnumSet과 EnumMap을 사용하지 못한다
     * Operation으로만 받으면, Enum인지 판단하지 못해서인가?
     */
    private static void testApply2(Collection<? extends Operation> opSet, double x, double y) {
        for (Operation op : opSet) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

}