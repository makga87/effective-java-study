package com.study.effectivejava.item7;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.WeakHashMap;

import org.junit.jupiter.api.Test;

class ReleaseObjectReferenceTest {

	@Test
	void selfManageMemory() {
		Stack stack = new Stack();

		/**
		 * ChatGPT로 확인해봤으나, null로 메모리 초기화 하는건 잘 안나오고, 바이터 버퍼가 나왔다
		 * 그런데, 실제로 힙메모리관련 파라메터나, clear등으로 메모리에서 할당 정보를 해제 하는데, null로 초기화 하는 내용과는 조금 달라 보인다.
		 */
		ByteBuffer buffer = ByteBuffer.allocate(1024);
	}

	@Test
	void weakHashMap() throws InterruptedException {

		String hashMapKey1 = new String("1");
		String hashMapKey2 = new String("2");

		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put(hashMapKey1, "hashMap test1");
		hashMap.put(hashMapKey2, "hashMap test2");

		hashMapKey1 = null;

		String weakHashMapKey1 = new String("3");
		String weakHashMapKey2 = new String("4");

		WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();
		weakHashMap.put(weakHashMapKey1, "weakHashMap test1");
		weakHashMap.put(weakHashMapKey2, "weakHashMap test2");

		//		weakHashMapKey1 = null;

		System.out.println("Before gc");
		System.gc();
		System.out.println("After gc");


		print(hashMap);
		print(weakHashMap);

		end();
	}

	private static void print(Map<String, String> map) {
		map.entrySet()
		   .stream()
		   .forEach(entry -> {
			   System.out.println(entry.getKey() + "=" + entry.getValue());
		   });
	}

	private void end() {
	}

}