package com.marisoft.ziba.cep.jms;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class MyInputEventListener implements UpdateListener {

	private JmsTemplate jmsTemplate;
	private ActiveMQDestination bpCoordinatorDest;

	public MyInputEventListener(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
		bpCoordinatorDest = new ActiveMQQueue("BPCoordinator-QUEUE");
	}

	public synchronized void update(EventBean[] newEvents, EventBean[] oldEvents) {

		final MyInputEvent event = (MyInputEvent) newEvents[0].getUnderlying();

		jmsTemplate.send(bpCoordinatorDest, new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {
				MapMessage message = session.createMapMessage();
				message.setStringProperty("command", "startProcess");
				message.setIntProperty("processId", event.getCount());
				return message;
			}
		});

		System.out.println("Event Detected (" + event.getCount() + ")");
	}

}
