package com.marisoft.ziba.cep.epn.artifacts;

import com.marisoft.ziba.cep.epn.artifacts.apis.IEvent;

public abstract class Event implements IEvent{
	
	/** identifier of EventType which the event is instantiated from */
	private String identifier;
	
	/** header of event which holds a general information about any event instance */
	private EventHeader header;
		
	public Event(String identifier, Long identity) {
		this.identifier = identifier;
		header = new EventHeader(identity);
	}
	
	public String getIdentifier() {
		return this.identifier;
	}
	
	public EventHeader getHeader() {
		return header;
	}
	
}
