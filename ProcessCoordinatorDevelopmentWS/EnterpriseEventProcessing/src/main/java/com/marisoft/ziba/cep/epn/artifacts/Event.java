package com.marisoft.ziba.cep.epn.artifacts;

import com.marisoft.ziba.cep.epn.artifacts.apis.IEvent;

public abstract class Event implements IEvent{
	
	/** identifier of EventType which the event is instantiated from */
	private String identifier;
	
	private EventHeader header;
	
	private EventBody body;
	
	protected void setBody(EventBody body) {
		this.body = body;
	}
		
	public Event(String identifier, Long identity, String source) {
		this.identifier = identifier;
		header = new EventHeader(identity, source);
	}
	
	public String getIdentifier() {
		return this.identifier;
	}
	
	public EventHeader getHeader() {
		return header;
	}
	
}
