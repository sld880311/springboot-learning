package com.sunld.conf;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//可以通过@Value("${属性值}")获取配置文件中的属性
@Component
@PropertySource(value = "classpath:/myconfig.properties" ,encoding = "UTF-8")
//@ConfigurationProperties注解主要用来把properties配置文件转化为bean来使用的，
//而@EnableConfigurationProperties注解的作用是@ConfigurationProperties注解生效。
@ConfigurationProperties(prefix="com.sunld.application")
public class CourseLearningMyConfigAuto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String chapter;
	
	private String course;
	
	private String learning;

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getLearning() {
		return learning;
	}

	public void setLearning(String learning) {
		this.learning = learning;
	}

	@Override
	public String toString() {
		return "CourseLearningMyConfigAuto [chapter=" + chapter + ", course=" + course + ", learning=" + learning + "]";
	}
	
	
	
	
}
