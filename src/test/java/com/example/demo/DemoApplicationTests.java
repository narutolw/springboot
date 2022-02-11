package com.example.demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void test1() {
		Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);
		logger.info("slf4j test");
		System.out.println("你好");
	}

}
