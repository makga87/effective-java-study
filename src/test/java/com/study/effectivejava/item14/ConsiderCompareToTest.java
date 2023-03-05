package com.study.effectivejava.item14;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class ConsiderCompareToTest {

    @DisplayName("hashSet compareTo 테스트, equals로 비교하므로, add된 갯수만큼 size")
    @Test
    void hashSetTest(){
        /*
        내부적으로 해시맵
        add된 값이, 바로 해시함수가 적용되어 키로 인식됨
         */
        HashSet<BigDecimal> hashSet = new HashSet();
        hashSet.add(new BigDecimal("1.0"));
        hashSet.add(new BigDecimal("1.00"));

        System.out.println(hashSet.size());
    }

    @DisplayName("treeSet compareTo 테스트, equals로 비교하므로, add된 갯수만큼 size")
    @Test
    void treeSetTest(){
        /*
        내부적으로 Navigable Map이 SortedMap을 확장하는 부분이 있고, 해당 맵은 Comparable이 있다.
        treeSet 내부에서 BigDecimal이 확장한 함수를 호출함으로, 값 비교를 한다. 이 때, 문자열 값을 숫자로 변환하여 비교
        */
        TreeSet<BigDecimal> treeSet = new TreeSet<>();
        treeSet.add(new BigDecimal("1.0"));
        treeSet.add(new BigDecimal("1.00"));

        System.out.println(treeSet.size());
    }

}