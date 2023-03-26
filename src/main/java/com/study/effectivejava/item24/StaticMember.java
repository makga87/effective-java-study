package com.study.effectivejava.item24;

public class StaticMember {

    private int outerNonStatic;
    private static int outerStatic;
    private Inner accessInner;
    private PrivateInner accessPrivateInner;

    public static class Inner{
        private int inner1 = outerStatic;
//        private int inner2 = outerNonStatic;
//
//        public StaticMember getOuter(){
//            return StaticMember.this;
//        }
    }

    private static class PrivateInner{
        private int inner1;
    }

    public Inner getInner(){
        return this.accessInner;
    }

    public PrivateInner getPrivateInner(){
        return this.accessPrivateInner;
    }
}
