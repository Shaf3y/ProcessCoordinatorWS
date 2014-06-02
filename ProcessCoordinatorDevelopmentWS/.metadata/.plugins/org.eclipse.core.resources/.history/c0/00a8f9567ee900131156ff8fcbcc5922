package com.marisoft.ziba.cep.epn.elements;

import java.util.List;

import com.marisoft.ziba.cep.epn.elements.apis.IEventChannel;
import com.marisoft.ziba.cep.epn.elements.apis.IEventType;

public abstract class EventChannel implements IEventChannel {
	
	private String identifier;
	private String description;
	private RoutingScheme routingScheme;
	private ElementType type;
	private List<IEventType> eventTypes;
	
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
		return this.eventTypes;
	}
	
}
