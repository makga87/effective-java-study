package com.study.effectivejava.item24;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.*;

class UseStaticClassTest {

    @DisplayName("맵 내부 구현확인 용")
    @Test
    void mapInnerSearchTest(){
        Map hashMap = new HashMap();
        Map treeMap = new TreeMap();
        Map linkeddHashMap = new LinkedHashMap();
        Map cocurrentHashMap = new ConcurrentHashMap();
    }

    @DisplayName("private 정적 멤버 클래스를 접근해보자")
    @Test
    void privateStaticMemberClassTest(){
        StaticMember staticMember = new StaticMember();
        StaticMember.Inner staticMemberInner = new StaticMember.Inner();

        // getter로는 접근 가능
        staticMember.getPrivateInner();

        // 바깥 인스턴스 통해서도 PrivateInner클래스는 접근 불가
    }
}