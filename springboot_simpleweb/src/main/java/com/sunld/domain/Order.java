package com.sunld.domain;

public class Order {

	/**
	 * 订单id
	 */
	private Integer id;
	/**
	 * 订单名称
	 */
	private String orderName;
	/**
	 * 订单类型
	 */
	private String orderType;
	
	/**
	 * get、set方法
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderName=" + orderName + ", orderType=" + orderType + "]";
	}
}
