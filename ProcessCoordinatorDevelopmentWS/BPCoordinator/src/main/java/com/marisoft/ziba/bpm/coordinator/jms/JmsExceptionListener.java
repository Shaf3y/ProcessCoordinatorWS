package com.marisoft.ziba.bpm.coordinator.jms;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;


public class JmsExceptionListener implements ExceptionListener {

	public void onException(JMSException ex) {
		ex.printStackTrace();
	}


}
