package com.marisoft.ziba.cep.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.marisoft.ziba.cep.epn.exceptions.DuplicateInputChannel;

public class ConsumerApp {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/application-context.xml");
//		EsperEventProcessingAgent agent = applicationContext.getBean(EsperEventProcessingAgent.class);
//		
//		try {
//			agent.start();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}			
//		
//		Thread.sleep(30000);
		
		DuplicateInputChannel e = new DuplicateInputChannel("xxxx", "yyyyy");
		System.out.println(e.getMessage());
	}

}
