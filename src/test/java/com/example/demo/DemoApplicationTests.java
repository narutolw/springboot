package com.example.demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void test1() {
		Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);
		logger.info("slf4j test");
		System.out.println("你好");
	}

	@Test
	void testMysql() throws SQLException {

		System.out.println("默认数据源为：" + dataSource.getClass());
		System.out.println("数据库连接实例：" + dataSource.getConnection());
		//访问数据库
		Integer i = jdbcTemplate.queryForObject("SELECT count(*) from `testtable`", Integer.class);
		System.out.println("user 表中共有" + i + "条数据。");
	}

}
