package com.marisoft.ziba.bpm.coordinator.jms;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;

import com.marisoft.ziba.bpe.api.BusinessProcessEngineDelegate;
import com.marisoft.ziba.bpm.coordinator.IBPCoordinator;


public class JmsBPCoordinator implements IBPCoordinator, MessageListener {

	@Autowired
	private BusinessProcessEngineDelegate engineDelegate;
	
	public void onMessage(Message message) {
		try {
			String command = message.getStringProperty("command");
			System.out.println("Received Command : " + command);
		} catch (JMSException e) {			
			e.printStackTrace();
		}
		
	}
	
	public void executeCommand() {
		
	}

	public Map<String, Object> startProcess(String key, Map<String, Object> vars) {
		// TODO Auto-generated method stub
		return null;
	}

	public void completeTask(String taskId, Map<String, Object> vars) {
		// TODO Auto-generated method stub
		
	}

	public void completeTask(Map<String, Object> taksMap,
			Map<String, Object> vars) {
		// TODO Auto-generated method stub
		
	}

	public void completeTask(String desc, String userId,
			Map<String, Object> vars) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void completeTask(String desc, String userId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void delegateTaskWithReview(String taskId, String userId) {
		// TODO Auto-generated method stub
		
	}

	public void delegateTaskFullControl(String taskId, String userId) {
		// TODO Auto-generated method stub
		
	}

	public void resolveTask(String taskId) {
		// TODO Auto-generated method stub
		
	}

	public void assignTask(String taskId, String userId) {
		// TODO Auto-generated method stub
		
	}

	public void assertVariable() {
		// TODO Auto-generated method stub
		
	}

	public void signalProcess(String procInstId, String signalKey) {
		// TODO Auto-generated method stub
		
	}

	public boolean claimTask(String taskId, String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	public void terminateProcessWith(String ProcessName, String varName,
			Object varValue, String reason) {
		// TODO Auto-generated method stub
		
	}
		

}
