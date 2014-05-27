package com.marisoft.ziba.cep;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import com.marisoft.ziba.cep.apis.IEventHandler;

public abstract class EventHandler implements IEventHandler, UpdateListener {

	public abstract void handle() throws Exception;
	
	public void update(EventBean[] newEvents, EventBean[] oldEvents) {		
		handle();
	}
}
