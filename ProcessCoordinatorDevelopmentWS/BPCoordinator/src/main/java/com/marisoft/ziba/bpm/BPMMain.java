package com.marisoft.ziba.bpm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.marisoft.ziba.bpm.coordinator.IBPCoordinator;

public class BPMMain {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/bpcoordinator-context.xml");
		IBPCoordinator coordinator = (IBPCoordinator) applicationContext.getBean("eventBasedBPCoordinator");
		Thread.sleep(30000);
		
	}

}
