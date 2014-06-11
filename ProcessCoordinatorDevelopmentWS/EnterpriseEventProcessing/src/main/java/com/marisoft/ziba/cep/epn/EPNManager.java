package com.marisoft.ziba.cep.epn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.marisoft.ziba.cep.data.repositories.EventChannelRepository;
import com.marisoft.ziba.cep.data.repositories.EventConsumerRepository;
import com.marisoft.ziba.cep.data.repositories.EventProcessingAgentRepository;
import com.marisoft.ziba.cep.data.repositories.EventProducerRepository;
import com.marisoft.ziba.cep.data.repositories.EventTypeRepository;
import com.marisoft.ziba.cep.epn.elements.EventType;
import com.marisoft.ziba.cep.epn.elements.apis.IEPNElement;
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
	/** Network Elements */
	
	/** Data Services */
	@Autowired
	private EventTypeRepository typeRepository;
	
	@Autowired
	private EventChannelRepository channelRepository;
	
	@Autowired
	private EventProducerRepository producerRepository;
	
	@Autowired
	private EventConsumerRepository consumerRepository;
	
	@Autowired
	private EventProcessingAgentRepository agentRepository;
	/** Data Services */
	
	private void initializeElementsMap(Iterable<IEPNElement> elements, Map<String,IEPNElement> map) {
		for (IEPNElement element : elements) {
			map.put(element.getIdentifier(), element);
		}
	}
	
	private void initializeEventTypesMap() {
		eventTypes = new HashMap<String, IEventType>();
		
		
		
		Iterable<EventType> typesElements = typeRepository.findAll();		
		
		this.initializeElementsMap(typesElements, eventTypes);
		
		for (EventType type : typesElements) {
			eventTypes.put(type.getIdentifier(), type);
		}
	}
	
	private void initializeEventChannelsMap() {
		channels = new HashMap<String, IEventChannel>();
	}
	
	private void initializeEventProducersMap() {
		producers = new HashMap<String, IEventProducer>();
	}
	
	private void initializeEventConsumersMap() {
		consumers = new HashMap<String, IEventConsumer>();
	}
	
	private void initializeEventAgentsMap() {
		agents = new HashMap<String, IEventProcessingAgent>();
	}
	
	protected EPNManager() {	
		
	}
	
	public static synchronized EPNManager getManager() {
		if (manager == null) {
			manager = new EPNManager();
		}	
		
		return manager;		
	}
		
	public void startAgent(String identifier) {
		
	}
	
	public void startAllAgents() {
		
	}
	
	public void stopAgent(String identifier) {
		
	}
	
	public void stopAllAgents() {
		
	}
}
