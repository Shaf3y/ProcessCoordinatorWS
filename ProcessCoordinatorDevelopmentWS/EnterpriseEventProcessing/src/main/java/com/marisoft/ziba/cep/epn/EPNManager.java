package com.marisoft.ziba.cep.epn;

import java.util.HashMap;
import java.util.Map;

import com.marisoft.ziba.cep.epn.elements.apis.IEventChannel;
import com.marisoft.ziba.cep.epn.elements.apis.IEventConsumer;
import com.marisoft.ziba.cep.epn.elements.apis.IEventProcessingAgent;
import com.marisoft.ziba.cep.epn.elements.apis.IEventProducer;
import com.marisoft.ziba.cep.epn.elements.apis.IEventType;

public class EPNManager {

	private static EPNManager manager = null;
	
	
	/** Network Elements */
	private Map<String, IEventType> eventTypes;
	private Map<String, IEventChannel> channels;
	private Map<String, IEventProducer> producers;	
	private Map<String, IEventConsumer> consumers;
	private Map<String, IEventProcessingAgent> agents;	
	
	protected EPNManager() {
		eventTypes = new HashMap<String, IEventType>();
		channels = new HashMap<String, IEventChannel>();
		producers = new HashMap<String, IEventProducer>();
		consumers = new HashMap<String, IEventConsumer>();
		agents = new HashMap<String, IEventProcessingAgent>();
	}
	
	public static synchronized EPNManager getManager() {
		if (manager == null) {
			manager = new EPNManager();
		}	
		
		return manager;		
	}
	
	public void start() {
		
	}
		
	public void registerEventType(IEventType eventType) throws Exception {
		
	}
}
