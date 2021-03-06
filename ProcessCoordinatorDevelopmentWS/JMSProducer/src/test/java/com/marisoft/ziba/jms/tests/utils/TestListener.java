package com.marisoft.ziba.jms.tests.utils;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Message;
import javax.jms.MessageListener;

public class TestListener implements MessageListener {

	private List<Message> receivedMessages;
	
	public TestListener() {
		receivedMessages = new ArrayList<Message>();
	}
	
	public void onMessage(Message msg) {
		System.out.println("Message Received : " + msg);
		receivedMessages.add(msg);
	}
	
	public List<Message> getReceivedMessages() {
		return this.receivedMessages;
	}
}
