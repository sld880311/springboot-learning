package com.sunld;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sunld.domain.Order;

@RestController
//定义统一的入口，通过这里配置使下面的映射都在/orders下
@RequestMapping("/orders")
public class OrderController {

	//定义线程安全的map用来存储订单信息
	private static final Map<Integer , Order> staticOrderMap = 
			Collections.synchronizedMap(new HashMap<Integer, Order>());
	
	/**
	 * 查询所有订单
	 * url地址：http://127.0.0.1:8080/orders/
	 * 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
	 * @return
	 */
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public List<Order> getOrders(){
		List<Order> orderList = new ArrayList<Order>(staticOrderMap.values());
		return orderList;
	}
	
	/**
	 * 添加订单
	 * url地址：http://127.0.0.1:8080/orders/add
	 * @ModelAttribute：用来接收form中的订单信息
	 * 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
	 * @param order
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addOrder(@ModelAttribute Order order) {
		if(order != null) {
			staticOrderMap.put(order.getId(), order);
			return "success";
		}
		return "failure";
	}
	
	/**
	 * 根据订单id获取订单信息
	 * url地址：http://127.0.0.1:8080/orders/1234
	 * url中的id可通过@PathVariable绑定到函数的参数中
	 * @return
	 */
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public Order getOrderById(@PathVariable Integer id) {
		return staticOrderMap.get(id);
	}
	/**
	 * 根据订单id更新订单信息
	 * url地址：http://127.0.0.1:8080/orders/update/1234
	 * @param id
	 * @param order
	 * @return
	 */
	@RequestMapping(value = "/update/{id}" , method = RequestMethod.POST)
	public String updateOrderById(@PathVariable Integer id, @ModelAttribute Order order) {
		Order o = staticOrderMap.get(id);
		if(o != null && order != null) {
			o.setOrderName(order.getOrderName());
			o.setOrderType(order.getOrderType());
			staticOrderMap.put(id, o);
			return "success";
		}else {
			return "failure";
		}
	}
	/**
	 * 根据订单ID删除订单信息
	 * url地址：http://127.0.0.1:8080/orders/delete/1234
	 * @param id
	 * @return
	 */
    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE) 
    public String deleteOrderById(@PathVariable Integer id) { 
    	staticOrderMap.remove(id); 
        return "success"; 
    } 
}
