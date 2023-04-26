package com.study.effectivejava.item36;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



class UseEnumSetBeHalfOfBitCalculationTest {

	@DisplayName("비트 연산 예제")
	@Test
	 void bitSetTest(){
		int A = 0b1101; // 13
		int B = 0b1011; // 11

		int union = A | B; // 합집합
		int intersection = A & B; // 교집합

		System.out.println("A: " + Integer.toBinaryString(A) + " (" + A + ")");
		System.out.println("B: " + Integer.toBinaryString(B) + " (" + B + ")");
		System.out.println("Union: " + Integer.toBinaryString(union) + " (" + union + ")");
		System.out.println("Intersection: " + Integer.toBinaryString(intersection) + " (" + intersection + ")");
	}
}