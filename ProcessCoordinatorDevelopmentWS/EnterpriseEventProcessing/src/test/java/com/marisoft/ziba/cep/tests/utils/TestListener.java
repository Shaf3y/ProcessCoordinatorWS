package com.marisoft.ziba.cep.tests.utils;

import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

public class TestListener implements MessageListener {

	private List<Message> receivedMessages;
	
	public TestListener() {
		receivedMessages = new ArrayList<Message>();
	}
	
	public void onMessage(Message msg) {
		receivedMessages.add(msg);
		MapMessage mapMessage = (MapMessage) msg;
		try {
			System.out.println("Message Received { command (" + mapMessage.getStringProperty("command") + "), ProcessId (" + mapMessage.getIntProperty("processId") + ")");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Received Messages Count [" + receivedMessages.size() + "]");
	}
	
	public List<Message> getReceivedMessages() {
		return this.receivedMessages;
	}
	
}
