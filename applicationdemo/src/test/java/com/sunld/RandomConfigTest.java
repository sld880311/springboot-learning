package com.sunld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sunld.conf.RandomConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RandomConfigTest {

	@Autowired
	private RandomConfig randomConfig;
	
	@Test
	public void testGetRandomConfig() {
		System.out.println(randomConfig);
	}
}
