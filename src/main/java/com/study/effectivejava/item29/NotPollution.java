package com.study.effectivejava.item29;

public class NotPollution<E> {

	private Object[] elements;

	public NotPollution() {
		Object[] objArr = new Object[3];
		objArr[0] = 1;
		objArr[1] = "abc";
		objArr[2] = 2.0f;

		/**
		 * elements가 여러 타입의 데이터가 들어가있는 Object 배열을 '참조'하고 있지만, 같은 Object[]이기 때문에, 힙오염이 아니다.
		 */
		elements = objArr;
	}

	public void push(E element, int i) {
		elements[i] = element;
	}

	/**
	 * ClassCastException이 발생할 수 있겠지만, '참조'를 하고 있는 부분이 없다
	 */
	public E pop(int i) {
		E result = (E) elements[i];
		return result;
	}
}
