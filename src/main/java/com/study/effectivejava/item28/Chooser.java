package com.study.effectivejava.item28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser {
    private final Object[] choiceArray;

    public Chooser(Collection choices){
        choiceArray = choices.toArray();
    }

    /**
     * 호출 시마다 반환된 Object를 원하는 타입으로 형변환 해야함
     * @return
     */
    public Object choose(){
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}
