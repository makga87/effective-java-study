package com.study.effectivejava.item39;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTestContainer.class)
public @interface ExceptionRepeatableTest {
    Class<? extends Throwable> value();
}
