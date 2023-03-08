package com.study.effectivejava.common.model;

public class NonMember extends Member {

	@Override
	public NonMember newMember() {
		return new NonMember();
	}
}
