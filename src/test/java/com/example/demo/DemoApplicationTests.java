package com.example.demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.util.concurrent.*;

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
	void testThreadLocal() {

//		ThreadLocal<Integer> a = new ThreadLocal<>();
//		a.set(0);
//		System.out.println(a.get());
//		AtomicInteger b = new AtomicInteger();
//		b.addAndGet(1);
//		AtomicStampedReference c = new AtomicStampedReference(b, 1);
//		Executors.newFixedThreadPool();
		Vector a = new Vector();
		Collections.synchronizedList(new ArrayList<>());
		final ExecutorService executorService =
				new ThreadPoolExecutor(
						2,
						3,
						4,
						TimeUnit.MINUTES,
						new ArrayBlockingQueue<>(1),
						new ThreadPoolExecutor.AbortPolicy());
		final Future<?> submit = executorService.submit(() -> {
			try {
				Thread.sleep(10000000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		final Future<?> submit2 = executorService.submit(() -> {
			try {
				Thread.sleep(10000000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		final Future<?> submit3 = executorService.submit(() -> {
			try {
				Thread.sleep(10000000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		final Future<?> submit4 = executorService.submit(() -> {
			try {
				Thread.sleep(10000000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		final Future<?> submit5 = executorService.submit(() -> {
			try {
				Thread.sleep(10000000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		try {
			submit.get();
			submit2.get();
			submit3.get();
			submit4.get();
			submit5.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}


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
