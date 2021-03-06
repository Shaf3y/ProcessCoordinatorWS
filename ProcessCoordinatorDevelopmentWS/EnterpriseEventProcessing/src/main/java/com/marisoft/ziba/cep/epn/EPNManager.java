package com.marisoft.ziba.cep.epn;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.marisoft.ziba.cep.data.repositories.EventChannelRepository;
import com.marisoft.ziba.cep.data.repositories.EventConsumerRepository;
import com.marisoft.ziba.cep.data.repositories.EventProcessingAgentRepository;
import com.marisoft.ziba.cep.data.repositories.EventProducerRepository;
import com.marisoft.ziba.cep.data.repositories.EventTypeRepository;
import com.marisoft.ziba.cep.epn.artifacts.EventProcessingAgentManager;
import com.marisoft.ziba.cep.epn.elements.EventChannel;
import com.marisoft.ziba.cep.epn.elements.EventConsumer;
import com.marisoft.ziba.cep.epn.elements.EventProcessingAgent;
import com.marisoft.ziba.cep.epn.elements.EventProducer;
import com.marisoft.ziba.cep.epn.elements.EventType;
import com.marisoft.ziba.cep.epn.elements.apis.IEventChannel;
import com.marisoft.ziba.cep.epn.elements.apis.IEventConsumer;
import com.marisoft.ziba.cep.epn.elements.apis.IEventProcessingAgent;
import com.marisoft.ziba.cep.epn.elements.apis.IEventProducer;
import com.marisoft.ziba.cep.epn.elements.apis.IEventType;

public class EPNManager {

	private static EPNManager manager = null;	
	
	/** Network Elements */
	private Map<String, IEventType> eventTypesMap;
	private Map<String, IEventChannel> eventChannelsMap;
	private Map<String, IEventProducer> producersMap;	
	private Map<String, IEventConsumer> consumersMap;
	private Map<String, IEventProcessingAgent> agentsMap;
	/** Network Elements */
	
	/** Elements Managers */
	private Map<String, EventProcessingAgentManager> agentsManagersMap;
	/** Elements Managers */
	
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
		
	private void initializeEventTypesMap() {
		eventTypesMap = new HashMap<String, IEventType>();		
		
		Iterable<EventType> typesElements = typeRepository.findAll();		
				
		for (EventType type : typesElements) {
			eventTypesMap.put(type.getIdentifier(), type);
		}
	}
	
	private void initializeEventChannelsMap() {
		eventChannelsMap = new HashMap<String, IEventChannel>();
		
		Iterable<EventChannel> channels = channelRepository.findAll();
		
		for (EventChannel channel : channels) {
			eventChannelsMap.put(channel.getIdentifier(), channel);
		}
	}
	
	private void initializeEventProducersMap() {
		producersMap = new HashMap<String, IEventProducer>();
		
		Iterable<EventProducer> producers = producerRepository.findAll();
		
		for (EventProducer producer : producers) {
			producersMap.put(producer.getIdentifier(), producer);
		}
	}
	
	private void initializeEventConsumersMap() {
		consumersMap = new HashMap<String, IEventConsumer>();
		
		Iterable<EventConsumer> consumers = consumerRepository.findAll();
		
		for (EventConsumer consumer : consumers) {
			consumersMap.put(consumer.getIdentifier(), consumer);
		}
	}
	
	private void initializeEventAgentsMap() {
		agentsMap = new HashMap<String, IEventProcessingAgent>();
		
		Iterable<EventProcessingAgent> agents = agentRepository.findAll();
		
		for (EventProcessingAgent agent : agents) {
			agentsMap.put(agent.getIdentifier(), agent);
		}
	}
	
	private void init() {
		this.initializeEventAgentsMap();
		this.initializeEventChannelsMap();
		this.initializeEventConsumersMap();
		this.initializeEventProducersMap();
		this.initializeEventTypesMap();
	}
	
	protected EPNManager() {	
		init();
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
