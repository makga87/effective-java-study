package com.study.effectivejava.item24;

public class NonStaticMember {

    private int outerNonStatic;
    private static int outerStatic;
    private Inner accessInner;

    public class Inner {
        private int inner1 = outerStatic;
        private int inner2 = outerNonStatic;

        public NonStaticMember getOuter(){
            return NonStaticMember.this;
        }
    }

    private Inner getInner(){
        return this.accessInner;
    }
}
