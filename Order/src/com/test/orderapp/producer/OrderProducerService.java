package com.test.orderapp.producer;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.test.orderapp.domain.Order;

@Service
public class OrderProducerService {

	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(OrderProducerService.class);

	@Autowired JmsTemplate jmsTemplate;
	
	static int orderSequence = 1;
	
	public void send(int customerId, double price) {
		final Order order = new Order(orderSequence, 2, price, "ordercd" + orderSequence++);
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				MapMessage mapMessage = session.createMapMessage();
				mapMessage.setInt("orderId", order.getOrderId());
				mapMessage.setInt("customerId", order.getCustomerId());
				mapMessage.setDouble("price", order.getPrice());
				mapMessage.setString("orderCode", order.getOrderCode());
				return mapMessage;
			}
		});
		if (logger.isInfoEnabled()) {
			logger.info("Order sent - id = " + order.getOrderId()); //$NON-NLS-1$
		}
	}
}