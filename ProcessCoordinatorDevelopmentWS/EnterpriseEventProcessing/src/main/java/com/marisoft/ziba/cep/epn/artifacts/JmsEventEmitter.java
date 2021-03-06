package com.marisoft.ziba.cep.epn.artifacts;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.marisoft.ziba.cep.epn.artifacts.apis.IEvent;
import com.marisoft.ziba.cep.epn.artifacts.apis.IEventEmitter;
import com.marisoft.ziba.cep.epn.elements.JmsEventChannel;
import com.marisoft.ziba.cep.epn.elements.MessagingMode;
import com.marisoft.ziba.cep.epn.elements.apis.IEventChannel;

public class JmsEventEmitter implements IEventEmitter {
	
	private JmsEventChannel channel;
	private ConnectionFactory connectionFactory;
	private JmsTemplate jmsTemplate;
	private Destination destination;
	
	private void establishJmsConnection() {
		connectionFactory = new ActiveMQConnectionFactory(channel.getBrokerURL());
		jmsTemplate = new JmsTemplate(connectionFactory);
		
		if (channel.getMessagingMode().equals(MessagingMode.P2P)) {			
			// The destination is a queue
			destination = new ActiveMQQueue(channel.getIdentifier());			
		} else if (channel.getMessagingMode().equals(MessagingMode.PUB_SUB)) {			
			// The destination is a topic
			destination = new ActiveMQTopic(channel.getIdentifier());
		}
	}
	
	public JmsEventEmitter(JmsEventChannel channel) {
		this.channel = channel;		
		establishJmsConnection();
	}

	public void emit(IEvent event) throws Exception {		
		final IEvent msgEvent = event;
		
		jmsTemplate.send(destination, new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage eventMessage = session.createObjectMessage();
				eventMessage.setObject(msgEvent);
				return eventMessage;			
			}
			
		});		
	}

	public IEventChannel getChannel() {
		return this.channel;
	}

}
