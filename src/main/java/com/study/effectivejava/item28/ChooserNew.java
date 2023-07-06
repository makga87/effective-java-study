package com.study.effectivejava.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserNew<T> {
    private final List<T> choiceList;
//    private final T[] choiceArray;

    public ChooserNew(Collection<T> choices) {
        /**
         * Object[] cannot be converted to T[] error 발생
         */
//        choiceArray = choices.toArray();

        /**
         * ChooserNew.java:15: warning: [unchecked] unchecked cast
         *         choiceArray = (T[]) choices.toArray();
         *                                            ^
         *   required: T[]
         *   found:    Object[]
         *   where T is a type-variable:
         *     T extends Object declared in class ChooserNew
         * 1 warning
         */
//        choiceArray = (T[]) choices.toArray();

        /**
         * 조금 더 느리겠지만, 런타임에 ClassCastException을 만날일이 없다.
         */
        choiceList = new ArrayList<>(choices);
    }

    /**
     * 호출 시마다 반환된 Object를 원하는 타입으로 형변환 해야함
     *
     * @return
     */
    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
//        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}
