package com.marisoft.ziba.jms;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.espertech.esper.adapter.InputAdapter;

@Component
public class MessageProducer {

	@Autowired
	private JmsTemplate template;

	@PostConstruct
	public void generateMessages() throws Exception {
		for (int i = 0; i < 100; ++i) {
			final String text = "Message Number is ( " + i + " )";
			final int index = i;
			
			template.send(new MessageCreator() {
				
				public Message createMessage(Session session) throws JMSException {
					MapMessage message = session.createMapMessage();
					
					message.setObject(InputAdapter.ESPERIO_MAP_EVENT_TYPE, "MyInputEvent");
					message.setStringProperty("text", text);
					message.setIntProperty("count", index);
					
					return message;
				}
			});
			
			System.out.println("Sending Message : " + text);
		}
	}
}
