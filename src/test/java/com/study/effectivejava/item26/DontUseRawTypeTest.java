package com.study.effectivejava.item26;

import java.util.ArrayList;
import java.util.List;

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

        List rawTypeList = new ArrayList();
        rawTypeList = strList;
//        objList = strList;
    }

    @Test
    void unboundedWildcardTypeTest(){
        List<?> unboundedWildcardTypeList = new ArrayList<>();
        unboundedWildcardTypeList.add(null);
        unboundedWildcardTypeList.add(null);

		System.out.println(unboundedWildcardTypeList.size());
//        unboundedWildcardTypeList.add("test");
    }
}