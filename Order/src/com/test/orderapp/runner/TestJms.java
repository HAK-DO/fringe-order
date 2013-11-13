package com.test.orderapp.runner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.orderapp.producer.OrderService;

/**
 * @author hdlee
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class TestJms {

	@Autowired OrderService orderService;
	
	@Test
	public void sendReceive() {
		for(int i =1; i<=5; i++){
			orderService.sendOrder(1+i, 10.0D+i);
		}
	}
}
