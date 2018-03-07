package com.sunld.controller;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sunld.OrderController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderControllerTest {
	private MockMvc mvc; 
	 
	@Before 
	public void setUp() throws Exception { 
		mvc = MockMvcBuilders.standaloneSetup(new OrderController()).build(); 
	} 
	
	@Test
	public void testOrderController() throws Exception {
		//1.创建查询所有订单，结果返回为空
		System.out.println("=====================初次查询所有订单信息start=====================");
        getOrders()
           .andExpect(MockMvcResultMatchers.content().string(equalTo("[]")))
           .andReturn();
        System.out.println("=====================初次查询所有订单信息end=======================");
        System.out.println("=====================第一次添加订单start=========================");
		// 2、post提交一个订单
		mvc.perform(MockMvcRequestBuilders.post("/orders/add")
						.param("id", "1234")
						.param("orderName", "购买平板电脑")
						.param("orderType", "在线付款")
						.accept(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.content().string(equalTo("success")))
			.andReturn();
		//2.1、查询所有订单
		/**
		 * 结果应该为"[{\"id\":1234,\"orderName\":\"购买平板电脑\",\"orderType\":\"在线付款\"}]"
		 */
		getOrders()
           .andExpect(MockMvcResultMatchers.content().string(equalTo("[{\"id\":1234,\"orderName\":\"购买平板电脑\",\"orderType\":\"在线付款\"}]")))
           .andReturn();
		System.out.println("=====================第一次添加订单end===========================");
		System.out.println("=====================再次添加订单start===========================");
		//3、再添加一个订单
		mvc.perform(MockMvcRequestBuilders.post("/orders/add")
				.param("id", "3456")
				.param("orderName", "购买奶粉")
				.param("orderType", "货到付款")
				.accept(MediaType.APPLICATION_JSON))
		   .andExpect(MockMvcResultMatchers.status().isOk())
		   .andDo(MockMvcResultHandlers.print())
		   .andExpect(MockMvcResultMatchers.content().string(equalTo("success")))
		   .andReturn();
		//3.1、查看所有订单信息
		/**
		 * 订单信息：
		 * [{"id":3456,"orderName":"购买奶粉","orderType":"货到付款"},{"id":1234,"orderName":"购买平板电脑","orderType":"在线付款"}]
		 */
		getOrders();
		System.out.println("=====================再次添加订单end=============================");
		System.out.println("=====================修改存在编号的订单start============================");
		//4、修改编号为1234的订单：该订单存在
		mvc.perform(MockMvcRequestBuilders.post("/orders/update/1234")
				.param("orderName", "订单名称由【购买平板电脑】修改为【再次购买平板电脑】")
				.param("orderType", "在线付款")
				.accept(MediaType.APPLICATION_JSON))
		   .andExpect(MockMvcResultMatchers.status().isOk())
		   .andDo(MockMvcResultHandlers.print())
		   .andReturn();
		//4.1查询订单1234
		getOrdersById("1234");
		System.out.println("=====================修改存在编号的订单end==============================");
		System.out.println("=====================修改订单编号不存在的订单start==============================");
		//5、修改编号为1的订单、该订单不存在,直接返回failure
		mvc.perform(MockMvcRequestBuilders.post("/orders/update/1")
				.param("orderName", "订单名称由【购买平板电脑】修改为【再次购买平板电脑】")
				.param("orderType", "在线付款")
				.accept(MediaType.APPLICATION_JSON))
		   .andExpect(MockMvcResultMatchers.status().isOk())
		   .andDo(MockMvcResultHandlers.print())
		   .andExpect(MockMvcResultMatchers.content().string(equalTo("failure")))
		   .andReturn();
		System.out.println("=====================修改订单编号不存在的订单end==============================");
		//6、删除订单1234
		mvc.perform(MockMvcRequestBuilders.delete("/orders/delete/1234").accept(MediaType.APPLICATION_JSON))
		   .andExpect(MockMvcResultMatchers.status().isOk())
		   .andDo(MockMvcResultHandlers.print())
		   .andExpect(MockMvcResultMatchers.content().string(equalTo("success")))
		   .andReturn();
		//6、1查看所有订单
		getOrders();
	}
	
	private ResultActions getOrders() throws Exception {
		return mvc.perform(MockMvcRequestBuilders.get("/orders/").accept(MediaType.APPLICATION_JSON))
				  .andExpect(MockMvcResultMatchers.status().isOk())
				  .andDo(MockMvcResultHandlers.print());
//				  .andReturn();
	}
	
	private ResultActions getOrdersById(String id) throws Exception {
		return mvc.perform(MockMvcRequestBuilders.get("/orders/" + id).accept(MediaType.APPLICATION_JSON))
				  .andExpect(MockMvcResultMatchers.status().isOk())
				  .andDo(MockMvcResultHandlers.print());
//				  .andReturn();
	}
}
