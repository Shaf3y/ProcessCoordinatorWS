package com.marisoft.ziba.bpm.coordinator.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import com.marisoft.ziba.bpm.coordinator.IBPCoordinator;


public class JmsBPCoordinator implements IBPCoordinator, MessageListener {

	
	
	public void onMessage(Message message) {
		try {
			String command = message.getStringProperty("command");
		
		} catch (JMSException e) {			
			e.printStackTrace();
		}
		
	}
	
	private void execute(String command) {
		
	}
	
	public void startProcess() {
		// TODO Auto-generated method stub
		
	}

	public void completeTask() {
		// TODO Auto-generated method stub
		
	}

	public void assertVariable() {
		// TODO Auto-generated method stub
		
	}

	public void signalProcess() {
		// TODO Auto-generated method stub
		
	}

	public void claimTask() {
		// TODO Auto-generated method stub
		
	}

	public void delegateTask() {
		// TODO Auto-generated method stub
		
	}

	public void assignTask() {
		// TODO Auto-generated method stub
		
	}

	public void ownTask() {
		// TODO Auto-generated method stub
		
	}

	public void resolveTask() {
		// TODO Auto-generated method stub
		
	}

	

}
