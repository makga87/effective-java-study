package com.study.effectivejava.item43;

public interface G extends G1, G2 {
	<E extends Exception> String m() throws E;

}
