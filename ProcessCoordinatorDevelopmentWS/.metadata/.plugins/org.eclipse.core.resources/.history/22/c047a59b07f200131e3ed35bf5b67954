package com.marisoft.ziba.cep.epn.elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.marisoft.ziba.cep.epn.artifacts.apis.IEvent;
import com.marisoft.ziba.cep.epn.elements.apis.IEventType;

@Document(collection="EventChannel")
public abstract class EventChannel implements IEventChannel {
	
	@Id
	private String identifier;
	private String description;
	private RoutingScheme routingScheme;
	private ElementType type;
	
	@DBRef
	private List<EventType> publishedEvents;
	
	public EventChannel() {
		publishedEvents = new ArrayList<EventType>();
	}
	
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
	
	public void addEventType(EventType eventType) {
		this.publishedEvents.add(eventType);
	}
	
	public void removeEventType(String typeId) {
		
		for (EventType type : this.publishedEvents) {
			
			if (type.getIdentifier().equals(typeId)) {
				this.publishedEvents.remove(type);
				break;
			}
			
		}
		
	}
	
	public Iterator<? extends IEventType> getPublishedEvents() {
		return this.publishedEvents.iterator();
	}
		
	public boolean isRegistered(IEvent event) {
		boolean registered = false;
		
		for(IEventType eventType : publishedEvents) {
			if (eventType.getIdentifier().equals(event.getIdentifier())) {
				registered = true;
				break;
			}
		}
		
		return registered;
	}	
}
