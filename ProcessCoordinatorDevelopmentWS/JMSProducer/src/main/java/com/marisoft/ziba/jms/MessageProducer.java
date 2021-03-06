package com.marisoft.ziba.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.marisoft.ziba.cep.jms.MyInputEvent;

@Component
public class MessageProducer {

	@Autowired
	private JmsTemplate template;
	
	public void setJmsTemplate(JmsTemplate template) {
		this.template = template;
	}
	
	public void generateMessages() throws Exception {
		for (int i = 0; i < 100; ++i) {
			final String text = "Message Number is ( " + i + " )";
			final int index = i;
			
			template.send(new MessageCreator() {
				
				public Message createMessage(Session session) throws JMSException {
					MyInputEvent inputEvent = new MyInputEvent(index, text);
					
					ObjectMessage message = session.createObjectMessage();
					message.setObject(inputEvent);
					
					message.acknowledge();
										
					return message;
				}
			});
			
			System.out.println("Sending Message : " + text);			
		}
	}
}
