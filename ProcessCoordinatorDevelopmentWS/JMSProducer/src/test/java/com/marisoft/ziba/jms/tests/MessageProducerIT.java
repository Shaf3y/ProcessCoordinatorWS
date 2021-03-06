package com.marisoft.ziba.jms.tests;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.Assert.*;

import com.marisoft.ziba.jms.MessageProducer;
import com.marisoft.ziba.jms.tests.utils.TestListener;

/**
 * 
 * @author shaf3y
 * Integration Test for MessageProducer class
 */

public class MessageProducerIT {
	private ApplicationContext applicationContext;
	
	@Before
	public void setUp() {
		applicationContext = new ClassPathXmlApplicationContext("META-INF/spring-test/producer-it-context.xml");
	}
	
	@Test
	public void testGeneratingMessagesAndCosumingThem(){	
		
		MessageProducer producer = applicationContext.getBean("messageProducer", MessageProducer.class);
		
		boolean producingFailure = false;
		
		try {
			producer.generateMessages();
		} catch (Exception e) {
			e.printStackTrace();
			producingFailure = true;
		}
		assertFalse(producingFailure);
		
		TestListener listener = applicationContext.getBean("testListener", TestListener.class);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int receivedMessagesCount = listener.getReceivedMessages().size();
		assertEquals(receivedMessagesCount, 100);
		
		System.out.println("Done Successfully");			
	}
}
