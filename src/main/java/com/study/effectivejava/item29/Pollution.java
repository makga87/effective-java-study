package com.study.effectivejava.item29;

public class Pollution<E> {

	private E[] elements;

	public Pollution() {

		Object[] objArr = new Object[3];
		objArr[0] = 1;
		objArr[1] = "abc";
		objArr[2] = 2.0f;

		/**
		 * elements가 여러 타입의 데이터가 들어가있는 Object 배열을 '참조'하고 있어, 힙오염이 발생가능성
		 */
		elements = (E[]) objArr;
	}

	public void push(E element, int i) {
		elements[i] = element;
	}

	public E pop(int i) {
		E result = elements[i];
		return result;
	}
}
