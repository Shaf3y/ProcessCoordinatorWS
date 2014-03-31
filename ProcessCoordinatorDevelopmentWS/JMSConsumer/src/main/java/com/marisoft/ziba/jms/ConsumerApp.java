package com.marisoft.ziba.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerApp {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/consumer-context.xml");
		JmsMessageListener listener = applicationContext.getBean(JmsMessageListener.class);
		Thread.sleep(30000);

	}

}
