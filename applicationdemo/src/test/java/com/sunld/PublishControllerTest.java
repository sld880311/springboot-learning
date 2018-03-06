package com.sunld;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sunld.conf.CourseLearningMyConfigAuto;
import com.sunld.controller.PublishController;

@RunWith(SpringRunner.class)
//@ComponentScan("com.sunld")
//@ContextConfiguration(initializers = ConfigFileApplicationContextInitializer.class)
//@SpringBootTest(classes=WebAppConfiguration.class)// 指定spring-boot的启动类    
@SpringBootTest
//@SpringApplicationConfiguration(classes = WebAppConfig.class)// 1.4.0 前版本  注意启动类不要搞错了 
/**
 * 
 * @author sunliaodong
 * 使用mockmvc进行，利用MockMvcResultHandlers.print()打印出执行结果。
 * 使用MockServletContext来构建一个空的WebApplicationContext，
 * 这样我们创建的HelloController就可以在@Before函数中创建并传递到MockMvcBuilders.standaloneSetup（）函数中。
 */
public class PublishControllerTest {
	
	@Value(value = "${server.port}")
	private String port;
	@Value("${com.sunld.applicationp.chapter}")
	private String chapter;
	
	@Value("${spring.http.encoding.force}")
	private String springforce;
	
	private MockMvc mvc;
	
    @Before
    public void setUp() throws Exception {
    	
    	System.out.println("获取配置文件中的port：" + port);
    	System.out.println("获取配置文件中的chapter：" + chapter);
    	System.out.println("获取配置文件中的springforce：" + springforce);
    	//使用new的方式会导致参数获取不到
        //mvc = MockMvcBuilders.standaloneSetup(new PublishController()).build();
    	mvc = MockMvcBuilders.standaloneSetup(publishController).build();
    }
    
    @Test
    public void publishMyConfig() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/publishmyconfig").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("HelloWorld ...."))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
    
    @Autowired
	private CourseLearningMyConfigAuto courseLearningMyConfigAuto;
	
    @Test
    public void testGetConfig() {
		
		System.out.println(courseLearningMyConfigAuto + "=========");
		System.out.println("章节：" + courseLearningMyConfigAuto.getChapter());
		System.out.println("课程：" + courseLearningMyConfigAuto.getCourse());
		System.out.println("学习：" + courseLearningMyConfigAuto.getLearning());
    }
    
    @Autowired
	private PublishController publishController;
	
    @Test
    public void testPublishMyConfigByController() {
    	publishController.publishMyConfig();
    }
    
    
}
