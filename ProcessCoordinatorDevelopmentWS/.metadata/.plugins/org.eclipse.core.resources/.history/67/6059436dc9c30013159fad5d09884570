package com.marisoft.ziba.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProducerApp {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/producer-context.xml");
		MessageProducer messageProducer = applicationContext.getBean(MessageProducer.class);
		
		Thread.sleep(4000);
	}

}
