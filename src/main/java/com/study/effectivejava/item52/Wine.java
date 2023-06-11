package com.study.effectivejava.item52;

class Wine {
    String name() {
        return "포도주";
    }
}


class SparklingWine extends Wine {
    String name() {
        return "발포성 포도주";
    }
}

class Champagne extends SparklingWine {
    @Override
    String name() {
        return "샴페인";
    }
}
