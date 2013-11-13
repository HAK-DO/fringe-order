package com.lollykids.biz.model;

import java.util.Map;

import lombok.Data;

@Data
public class Order {

	private int orderId;
	private int customerId;
	private double price;
	private String orderCode;
	
	public Order() {
		super();
	}

	public Order(int orderId, int customerId, double price, String orderCode) {
		this();
		this.orderId = orderId;
		this.customerId = customerId;
		this.price = price;
		this.orderCode = orderCode;
	}


	public Order(Map<String, Object> message) {
		this();
	    this.orderId = (Integer) message.get("orderId");
	    this.customerId = (Integer) message.get("customerId");
	    this.price = (Double) message.get("price");
	    this.orderCode = (String) message.get("orderCode");
	}

	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", price=" + price + ", orderCode=" + orderCode + "]";
	}
	
}
