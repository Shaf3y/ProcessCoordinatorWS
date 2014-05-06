package com.marisoft.ziba.cep.elements;

import java.util.List;

import com.marisoft.ziba.cep.elements.apis.IEventChannel;
import com.marisoft.ziba.cep.elements.apis.IEventConsumer;
import com.marisoft.ziba.cep.elements.apis.IEventProducer;
import com.marisoft.ziba.cep.elements.apis.IEventType;

public abstract class EventChannel implements IEventChannel {
	
	private String identifier;
	private String description;
	private RoutingScheme routingScheme;
	private ElementType type;
	
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	public String getIdentifier() {		
		return this.identifier;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {	
		return this.description;
	}
	
	public void setRoutingScheme(RoutingScheme routingScheme) {
		this.routingScheme = routingScheme;
	}
	
	public RoutingScheme getRoutingScheme() {
		return routingScheme;
	}
	
	public void setType(ElementType type) {
		this.type = type;
	}
	
	public ElementType getType() {
		return this.type;
	}
	
	public List<IEventType> getEventTypes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<IEventProducer> getSources() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<IEventConsumer> getTargets() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void publish(IEventProducer producer, IEventType event) {
		// TODO Auto-generated method stub
		
	}
	
	public void subscribe(IEventConsumer consumer, IEventType event) {
		// TODO Auto-generated method stub
		
	}	
	
}
