package com.sunld.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//可以通过@Value("${属性值}")获取配置文件中的属性
@Component
@PropertySource(value = "classpath:/myconfig.properties" ,encoding = "UTF-8")
public class CourseLearningMyConfig {
	
	@Value("${com.sunld.application.chapter}")
	private String chapter;
	
	@Value("${com.sunld.application.course}")
	private String course;
	
	@Value("${com.sunld.application.learning}")
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
		return "CourseLearningMyConfig [chapter=" + chapter + ", course=" + course + ", learning=" + learning + "]";
	}
}
