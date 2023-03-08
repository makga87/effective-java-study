package com.study.effectivejava.common.model;

public class Member {

    public static class GeneralMember {
        public void order(){
            System.out.println("일반 회원 주문");
        }
    }

    public static final class VipMember {
        public void order(){
            System.out.println("VIP 고객 주문");
        }
    }

    public static class BlackMember {
        public final void order(){
            System.out.println("일반 회원 주문 불가");
        }
    }

	public Member newMember() {
		return new Member();
	}
}
