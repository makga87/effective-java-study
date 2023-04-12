package com.study.effectivejava.item29;

import org.junit.jupiter.api.Test;

class MakeGenericTypeTest {

	/**
	 * ClassCastException은 발생하고 힙 오염이다
	 * 내부에 잘못된 타입을 가진 데이터를 E[] elements배열이 '참조'하고 있기 때문
	 */
	@Test
	void pollutionTest() {
		Pollution<Integer> pollution = new Pollution<>();
		int a = pollution.pop(0);
		int b = pollution.pop(1);
		int c = pollution.pop(2);
	}

	/**
	 * ClassCastException은 발생하지만 힙 오염은 아니다.
	 * 내부에 데이터를 동일한 타입인 Object[]이'참조'하고 있으며, 뽑아낼 때, 타입 캐스팅 중 발생한 내용이다.
	 * 힙오염의 여부는 다른 객체가 '참조'를 하느냐로 결정된다고 보여진다.
	 */
	@Test
	void notPollutionTest() {
		NotPollution<Integer> notPollution = new NotPollution<>();
		int a = notPollution.pop(0);
		int b = notPollution.pop(1);
		int c = notPollution.pop(2);
	}
}