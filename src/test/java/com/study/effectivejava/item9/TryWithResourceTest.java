package com.study.effectivejava.item9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.junit.jupiter.api.Test;

class TryWithResourceTest {


	@Test
	void tryWithResourceTest() throws Exception {

		URL targetUrl = new URL("http://www.google.com");

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(targetUrl.openStream()))) {
			StringBuffer html = new StringBuffer();
			String tmp;

			while ((tmp = reader.readLine()) != null) {
				html.append(tmp);
			}
		}
	}

}