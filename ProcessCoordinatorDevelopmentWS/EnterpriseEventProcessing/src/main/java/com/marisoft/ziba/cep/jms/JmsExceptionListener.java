package com.marisoft.ziba.cep.jms;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;

public class JmsExceptionListener implements ExceptionListener {

	public void onException(JMSException e) {
		e.printStackTrace();		
	}		
	
}
