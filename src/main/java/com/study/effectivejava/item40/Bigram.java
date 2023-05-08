package com.study.effectivejava.item40;

public class Bigram {

    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

//    public boolean equals(Bigram b) {
//        return b.first == first && b.second == second;
//    }

//    @Override
//    public boolean equals(Bigram b) {
//        return b.first == first && b.second == second;
//    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Bigram)) return false;
        Bigram bigram = (Bigram) o;
        return first == bigram.first && second == bigram.second;
    }

    public int hashCode() {
        return 31 * first + second;
    }
}
