package com.lollykids.biz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lollykids.biz.producer.OrderProducer;

/**
 * @author hdlee
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProducerAndConsumerTest {

	@Autowired OrderProducer orderProducer;
	
	@Test public void send() {
		for(int i =1; i<=5; i++){
			orderProducer.send(1+i, 10.0D+i);
		}
	}
}
