package com.sunld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sunld.conf.CourseLearningApplicationProperties;
import com.sunld.conf.CourseLearningApplicationYml;
import com.sunld.conf.CourseLearningMyConfig;
import com.sunld.conf.CourseLearningMyConfigAuto;

@RunWith(SpringRunner.class)
@SpringBootTest
//@EnableConfigurationProperties({CourseLearningMyConfigAuto.class})

public class ApplicationdemoApplicationTests {
	
	

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private CourseLearningApplicationProperties courseLearningApplicationProperties;
	//测试自定义属性的获取
	@Test
	public void testCourseLearningApplicationProperties() {
		System.out.println("courseLearningApplicationProperties章节：" + courseLearningApplicationProperties.getChapter());
		System.out.println("courseLearningApplicationProperties课程：" + courseLearningApplicationProperties.getCourse());
		System.out.println("courseLearningApplicationProperties学习：" + courseLearningApplicationProperties.getLearning());
	}
	
	@Autowired
	private CourseLearningMyConfig courseLearningMyConfig;
	//测试自定义属性的获取
	@Test
	public void testCourseLearningMyConfig() {
		System.out.println("courseLearningMyConfig章节：" + courseLearningMyConfig.getChapter());
		System.out.println("courseLearningMyConfig课程：" + courseLearningMyConfig.getCourse());
		System.out.println("courseLearningMyConfig学习：" + courseLearningMyConfig.getLearning());
	}
	
	@Autowired
	private CourseLearningApplicationYml courseLearningApplicationYml;
	//测试自定义属性的获取
	@Test
	public void testCourseLearningApplicationYml() {
		System.out.println("testCourseLearningApplicationYml章节：" + courseLearningApplicationYml.getChapter());
		System.out.println("testCourseLearningApplicationYml课程：" + courseLearningApplicationYml.getCourse());
		System.out.println("testCourseLearningApplicationYml学习：" + courseLearningApplicationYml.getLearning());
	}
	
	@Autowired
	private CourseLearningMyConfigAuto courseLearningMyConfigAuto;
	//测试自定义属性的获取
	@Test
	public void testCourseLearningMyConfigAuto() {
		System.out.println("testCourseLearningMyConfigAuto章节：" + courseLearningMyConfigAuto.getChapter());
		System.out.println("testCourseLearningMyConfigAuto课程：" + courseLearningMyConfigAuto.getCourse());
		System.out.println("testCourseLearningMyConfigAuto学习：" + courseLearningMyConfigAuto.getLearning());
	}

}
