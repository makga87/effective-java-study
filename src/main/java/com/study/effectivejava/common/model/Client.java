package com.study.effectivejava.common.model;

public class Client {

    public static class GeneralClient {
        public void order(){
            System.out.println("일반 회원 주문");
        }
    }

    public static final class VipClient {
        public void order(){
            System.out.println("VIP 고객 주문");
        }
    }

    public static class BlackClient {
        public final void order(){
            System.out.println("일반 회원 주문 불가");
        }
    }

	public Client newClient() {
		return new Client();
	}
}
