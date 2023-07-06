package com.study.effectivejava.item26;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

class DontUseRawTypeTest {

    @Test
    void rawTypeTest() {
        List list = new ArrayList<String>();
        list.add(1);
        list.add("test");

    }

    @Test
    void objectGenericTest() {
        List<Object> objList = new ArrayList<>();
        objList.add(1);
        objList.add("test");

        List<String> strList = new ArrayList<>();
        strList.add("test");
        strList.add("test2");

        /**
         * 아무 타입의 제네릭이든 할당 가능
         */
        List rawTypeList = new ArrayList();
        rawTypeList = strList;

        /**
         * 타입이 맞지 않으므로 에러 발생
         */
//        objList = strList;
    }

    @Test
    void unboundedWildcardTypeTest() {
        List<String> unboundedWildcardTypeList = new ArrayList<>();
        unboundedWildcardTypeList.add(null);
        unboundedWildcardTypeList.add(null);

        /**
         * null 이외에는 넣을 수 없으므로
         */
        // unboundedWildcardTypeList.add("string");

        System.out.println(unboundedWildcardTypeList.size());
//        unboundedWildcardTypeList.add("test");
    }

    @Test
    void allowedRawType(){
        Set set = new HashSet<String>();
        set.add("test1");
        set.add("test2");

        Object o = set;
        if(o instanceof Set) {
            Set<?> s = (Set<?>) o;
            System.out.println(s);
        }

    }

}