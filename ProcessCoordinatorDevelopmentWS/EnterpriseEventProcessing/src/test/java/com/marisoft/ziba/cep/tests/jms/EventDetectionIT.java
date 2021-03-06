package com.marisoft.ziba.cep.tests.jms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.URI;

import javax.jms.JMSException;
import javax.jms.Message;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.TransportConnector;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.marisoft.ziba.cep.jms.EsperEventProcessingAgent;
import com.marisoft.ziba.cep.tests.utils.EventProducer;
import com.marisoft.ziba.cep.tests.utils.TestListener;


public class EventDetectionIT {

	private ApplicationContext applicationContext;
	private BrokerService broker;
	
	private void startBroker() throws Exception {
		broker = new BrokerService();
		
		TransportConnector connector = new TransportConnector();
		connector.setUri(new URI("tcp://localhost:1547"));
		broker.addConnector(connector);
		broker.start();
	}
	
	@Before
	public void setUp() throws Exception {
		startBroker();		
		applicationContext = new ClassPathXmlApplicationContext("META-INF/spring-test/test-context.xml");
	}
	
	@Test
	public void testsubmitEventAndDetectionOfIt() {
		String[] beansNames = applicationContext.getBeanDefinitionNames();
					
		EsperEventProcessingAgent agent = applicationContext.getBean(EsperEventProcessingAgent.class);
		EventProducer producer = applicationContext.getBean(EventProducer.class);
		TestListener listener = applicationContext.getBean(TestListener.class);		
		
		boolean startSuccessfully = true;
		try {
			agent.start();
		} catch (Exception e) {
			e.printStackTrace();
			startSuccessfully = false;
		}		
		assertTrue(startSuccessfully);
		
		int eventsCount = 100;
		producer.generateEvents(eventsCount);
		
		//Sleeping for allowing TestListener to take a breath after 
		try {
			Thread.sleep(eventsCount * 10);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		assertEquals(eventsCount, listener.getReceivedMessages().size());
		
		for(Message message : listener.getReceivedMessages()){
			boolean corruptedMessage = false;
			
			try {
				String command = message.getStringProperty("command");
				assertEquals("startProcess", command);
			} catch (JMSException e) {
				corruptedMessage = true;
				e.printStackTrace();
			}
			
			assertFalse(corruptedMessage);
		}
	}
}
