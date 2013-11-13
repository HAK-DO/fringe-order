package com.test.orderapp.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.orderapp.domain.Order;

@Service("orderService")
public class OrderService {

	static int orderSequence = 1;

	@Autowired OrderSender orderSender;

	public void sendOrder(int customerId, double price) {
		Order order = new Order(orderSequence, 2, price, "ordercd" + orderSequence++);
		orderSender.sendOrder(order);
	}
}