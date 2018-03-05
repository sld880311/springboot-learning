package com.sunld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunld.conf.CourseLearningMyConfigAuto;

//@RestController的意思就是controller里面的方法都以json格式输出，不用再写什么jackjson配置的了！
@RestController
//这个属性也是必须的
//@EnableConfigurationProperties({CourseLearningMyConfigAuto.class})
public class PublishController {
	
	@Value(value = "${server.port}")
	private String port;
	
	@Autowired
	private CourseLearningMyConfigAuto courseLearningMyConfigAuto;
	
	@RequestMapping("/publishmyconfig")
    public String publishMyConfig() {
		
		System.out.println(port+"===========");
		
		System.out.println(courseLearningMyConfigAuto + "=========");
		System.out.println("章节：" + courseLearningMyConfigAuto.getChapter());
		System.out.println("课程：" + courseLearningMyConfigAuto.getCourse());
		System.out.println("学习：" + courseLearningMyConfigAuto.getLearning());
        return courseLearningMyConfigAuto.toString();
    }
	
}
