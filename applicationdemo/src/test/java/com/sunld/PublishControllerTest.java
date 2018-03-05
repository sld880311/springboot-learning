package com.sunld;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sunld.controller.PublishController;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("com.sunld")
/**
 * 
 * @author sunliaodong
 * 使用mockmvc进行，利用MockMvcResultHandlers.print()打印出执行结果。
 * 使用MockServletContext来构建一个空的WebApplicationContext，
 * 这样我们创建的HelloController就可以在@Before函数中创建并传递到MockMvcBuilders.standaloneSetup（）函数中。
 */
public class PublishControllerTest {
	private MockMvc mvc;
	
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new PublishController()).build();
    }
    
    @Test
    public void publishMyConfig() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/publishmyconfig").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("HelloWorld ...."))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
