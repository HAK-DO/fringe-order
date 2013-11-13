package com.test.orderapp.listener;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.test.orderapp.domain.Order;

@Component
public class OrderConsumerService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(OrderConsumerService.class);

//	public void orderReceived(Map<String, Object> message) throws Exception {
//	    Order customer = new Order(message);
//		if (logger.isInfoEnabled()) {
//			logger.info("orderReceived(Map<String,Object>) - Order customer=" + customer); //$NON-NLS-1$
//		}
//	  }
	public void received(Map<String, Object> message) throws Exception {
	    Order customer = new Order(message);
		if (logger.isInfoEnabled()) {
			logger.info("orderReceived(Map<String,Object>) - Order customer=" + customer); //$NON-NLS-1$
		}
	  }
	
}
