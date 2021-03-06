package com.marisoft.ziba.cep.tests.utils;

import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.marisoft.ziba.cep.jms.MyInputEvent;

public class EventProducer {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public void generateEvents(int count) {
		final List<Message> sentMessages = new ArrayList<Message>();
		for (int i = 0; i < count; ++i) {
			final String text = "Message Number is ( " + i + " )";
			final int index = i;
			
			jmsTemplate.send(new MessageCreator() {
				
				public Message createMessage(Session session) throws JMSException {
					MyInputEvent inputEvent = new MyInputEvent(index, text);
					
					ObjectMessage message = session.createObjectMessage();
					message.setObject(inputEvent);
					
					sentMessages.add(message);					
					
					return message;
				}
			});
			
			System.out.println("Sending Message : " + text);			
		}
		
		System.out.println("****************************** Sent Events Count (" + sentMessages.size() + ") ***************************");
	}
}
