package com.marisoft.ziba.bpe.activiti;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;

/**
 * 
 * @author shaf3y
 *	
 */
public class ActivitiEngineEventListener implements ActivitiEventListener {
	
	

	public void onEvent(ActivitiEvent event) {
		System.out.println(event);
	}

	public boolean isFailOnException() {
		// TODO Auto-generated method stub
		return false;
	}

}
