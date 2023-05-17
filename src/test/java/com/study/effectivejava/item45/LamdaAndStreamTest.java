package com.study.effectivejava.item45;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

class LamdaAndStreamTest {

    String instanceVariable = "defaultInstanceVar";
    static String classVariable = "defaultClassVar";

    /**
     * 스레드는 람다라고 해서 달라지는 것이 아니다.
     * 스레드가 다른경우를 상정해서, final 혹은 effectively final 로 지역변수를 지정해야 하는 것일 뿐
     */
    @Test
    void lamdaAndThread() {

        System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId());
        AnonymousTemp anonymousTemp1 = () -> {
            System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId());
        };
        anonymousTemp1.run();

        AnonymousTemp anonymousTemp2 = new AnonymousTemp() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId());
            }
        };
        anonymousTemp2.run();
    }

    @Test
    void lamdaAndAccessLevelTest1() {

        String localVariable = "defaultLocalVar";

        System.out.printf("ThreadId: %s, ThreadName: %s, String addr: %s, String : %s \n", Thread.currentThread().getId(), Thread.currentThread().getName(), System.identityHashCode(classVariable), classVariable);
        System.out.printf("ThreadId: %s, ThreadName: %s, String addr: %s, String : %s \n", Thread.currentThread().getId(), Thread.currentThread().getName(), System.identityHashCode(instanceVariable), instanceVariable);
        System.out.printf("ThreadId: %s, ThreadName: %s, String addr: %s, String : %s \n", Thread.currentThread().getId(), Thread.currentThread().getName(), System.identityHashCode(localVariable), localVariable);

        System.out.println("Before Stream =====================================================");
        Stream.of(classVariable, instanceVariable, localVariable)
                .forEach(str -> {
                    System.out.printf("ThreadId: %s, ThreadName: %s, String addr: %s, String : %s \n", Thread.currentThread().getId(), Thread.currentThread().getName(), System.identityHashCode(str), str);
                    str = str.replace("default", "changed");
                    System.out.printf("ThreadId: %s, ThreadName: %s, String addr: %s, String : %s \n", Thread.currentThread().getId(), Thread.currentThread().getName(), System.identityHashCode(str), str);
                });
        System.out.println("After Stream =====================================================");

        System.out.printf("ThreadId: %s, ThreadName: %s, String addr: %s, String : %s \n", Thread.currentThread().getId(), Thread.currentThread().getName(), System.identityHashCode(classVariable), classVariable);
        System.out.printf("ThreadId: %s, ThreadName: %s, String addr: %s, String : %s \n", Thread.currentThread().getId(), Thread.currentThread().getName(), System.identityHashCode(instanceVariable), instanceVariable);
        System.out.printf("ThreadId: %s, ThreadName: %s, String addr: %s, String : %s \n", Thread.currentThread().getId(), Thread.currentThread().getName(), System.identityHashCode(localVariable), localVariable);

    }



    /**
     * Variable used in lambda expression should be final or effectively final
     */
//    @Test
//    void lamdaAndAccessLevelTest2() {
//
//        String localVariable = "defaultLocalVar";
//
//        AnonymousTemp anonymousTemp1 = () -> {
//            classVariable = classVariable.replace("default", "changed");
//            instanceVariable = instanceVariable.replace("default", "changed");
//            localVariable = localVariable.replace("default", "changed");
//        };
//
//        AnonymousTemp anonymousTemp2 = new AnonymousTemp() {
//            @Override
//            public void run() {
//                classVariable = classVariable.replace("default", "changed");
//                instanceVariable = instanceVariable.replace("default", "changed");
//                localVariable = localVariable.replace("default", "changed");
//            }
//        };
//    }

    /**
     * Variable used in lambda expression should be final or effectively final
     */
//    @Test
//    void lamdaAndAccessLevelTest3() {
//
//        String effectivelyFinal = "defaultLocalVar";
//
//        AnonymousTemp anonymousTemp1 = () -> {
//            System.out.println(effectivelyFinal);
//        };
//
//        effectivelyFinal = effectivelyFinal.replace("default", "changed");
//    }

    /**
     * Cannot assign a value to final variable 'effectivelyFinal'
     */
//    @Test
//    void lamdaAndAccessLevelTest4() {
//
//        final String effectivelyFinal = "defaultLocalVar";
//
//        AnonymousTemp anonymousTemp1 = () -> {
//            System.out.println(effectivelyFinal);
//        };
//
//        effectivelyFinal = effectivelyFinal.replace("default", "changed");
//    }

}