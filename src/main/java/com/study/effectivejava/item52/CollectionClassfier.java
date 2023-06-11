package com.study.effectivejava.item52;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CollectionClassfier {

//    public static String classfiy(Set<?> s) {
//        return "집합";
//    }

//    public static String classfiy(List<?> list) {
//        return "리스트";
//    }

//    public static String classfiy(Collection<?> c) {
//        return "그 외";
//    }

    public static String classfiy(Collection<?> c) {
        return c instanceof Set ? "집합" :
                c instanceof List ? "리스트" : "그 외";
    }
}
