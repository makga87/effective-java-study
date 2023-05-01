package com.study.effectivejava.item39;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class SampleTest {

    @Test
    void runTest() throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName("com.study.effectivejava.item39.Sample");

        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(com.study.effectivejava.item39.Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExec) {

                    Throwable exec = wrappedExec.getCause();
                    System.out.println(m + " 실패 : " + exec);

                } catch (Exception exception) {
                    System.out.println("잘못 사용한 @Test: " + m);
                }
            }
        }

        System.out.printf("성공 : %d, 실패 : %d%n", passed, tests - passed);
    }


   /*
   예제 1)

   @Test
    void runExceptionTest() throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName("com.study.effectivejava.item39.Sample2");

        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("테스트 %s 실패 : 예외를 던지지 않음 %n", m);
                } catch (InvocationTargetException wrappedExec) {
                    Throwable exc = wrappedExec.getCause();
                    Class<? extends Throwable> excType = m.getAnnotation(ExceptionTest.class).value();
                    if (excType.isInstance(exc)) {
                        passed++;
                    } else {
                        System.out.printf("테스트 %s 실패 : 기대한 예외 %s, 발생한 예외 %s%n", m, excType.getName(), exc);
                    }
                } catch (Exception exception) {
                    System.out.println("잘못 사용한 @ExceptionTest: " + m);
                }
            }
        }

        System.out.printf("성공 : %d, 실패 : %d%n", passed, tests - passed);
    }*/

    @Test
    void runExceptionTest() throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName("com.study.effectivejava.item39.Sample3");

        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("테스트 %s 실패 : 예외를 던지지 않음 %n", m);
                } catch (InvocationTargetException wrappedExec) {

                    Throwable exc = wrappedExec.getCause();
                    int oldPassed = passed;

                    Class<? extends Throwable>[] excTypes = m.getAnnotation(ExceptionTest.class).value();

                    for (Class<? extends Throwable> excType : excTypes) {
                        if (excType.isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }

                    if (passed == oldPassed) {
                        System.out.printf("테스트 %s 실패: %s, %n", m, exc);
                    }


                } catch (Exception exception) {
                    System.out.println("잘못 사용한 @ExceptionTest: " + m);
                }
            }
        }

        System.out.printf("성공 : %d, 실패 : %d%n", passed, tests - passed);
    }


    @Test
    void runExceptionRepeatableTest() throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName("com.study.effectivejava.item39.Sample4");

        for (Method m : testClass.getDeclaredMethods()) {
            if (/*
            없어도 동일한 동작을 하는데, 왜 굳이 예제에 넣었는지?
            m.isAnnotationPresent(ExceptionRepeatableTest.class) ||
            */
                    m.isAnnotationPresent(ExceptionTestContainer.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("테스트 %s 실패 : 예외를 던지지 않음 %n", m);
                } catch (InvocationTargetException wrappedExec) {

                    Throwable exc = wrappedExec.getCause();
                    int oldPassed = passed;

                    ExceptionRepeatableTest[] excTests = m.getAnnotationsByType(ExceptionRepeatableTest.class);
                    for (ExceptionRepeatableTest excTest : excTests) {
                        if (excTest.value().isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }
                    if (passed == oldPassed) {
                        System.out.printf("테스트 %s 실패: %s, %n", m, exc);
                    }
                } catch (Exception exception) {
                    System.out.println("잘못 사용한 @ExceptionTest: " + m);
                }
            }
        }

        System.out.printf("성공 : %d, 실패 : %d%n", passed, tests - passed);
    }
}