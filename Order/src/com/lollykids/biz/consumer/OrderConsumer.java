package com.lollykids.biz.consumer;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.lollykids.biz.model.Order;

@Component
public class OrderConsumer {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(OrderConsumer.class);

	public void receive(Map<String, Object> message) throws Exception {
	    Order customer = new Order(message);
		if (logger.isInfoEnabled()) {
			logger.info("orderReceived(Map<String,Object>) - Order customer=" + customer); //$NON-NLS-1$
		}
	}
}
