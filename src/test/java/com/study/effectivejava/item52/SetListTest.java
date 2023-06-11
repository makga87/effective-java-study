package com.study.effectivejava.item52;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class SetListTest {

    @Test
    void setListTest1(){
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = -3; i < 3; i++){
            set.add(i);
            list.add(i);
        }

        for (int i = 0; i < 3; i++){
            set.remove(i);
            list.remove(i);
        }

        System.out.println(set + " " + list);
    }

    @Test
    void setListTest2(){
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = -3; i < 3; i++){
            set.add(i);
            list.add(i);
        }

        for (int i = 0; i < 3; i++){
            set.remove(i);
            list.remove(Integer.valueOf(i));
        }

        System.out.println(set + " " + list);
    }

    @Test
    void executorServiceTest(){

        new Thread(System.out::println).start();

        ExecutorService exec = Executors.newCachedThreadPool();

        /**
         * submit은 다중정의때문에 컴파일 에러 발생
         */
//        exec.submit(System.out::println);
    }
}