package com.marisoft.ziba.jms;

import java.util.Map;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class MyInputEventListener implements UpdateListener {

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		 Map<String, Object> event = (Map<String, Object>)newEvents[0].getUnderlying();
		 System.out.println(event);
	}

}
