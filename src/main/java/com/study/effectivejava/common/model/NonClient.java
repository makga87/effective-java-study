package com.study.effectivejava.common.model;

public class NonClient extends Client {

	@Override
	public NonClient newClient() {
		return new NonClient();
	}
}
