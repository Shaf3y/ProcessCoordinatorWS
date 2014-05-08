package com.marisoft.ziba.cep;

import com.marisoft.ziba.cep.apis.IEvent;

public abstract class Event implements IEvent{
	
	/** identifier of EventType which the event is instantiated from */
	private String identifier;
	
	/** header of event which holds a general information about any event instance */
	private EventHeader header;
	
//	/** body of event instance which holds payload attributes of event instance */
//	private EventBody body;
//	
//	protected void setBody(EventBody body) {
//		this.body = body;
//	}
	
	public Event(String identifier) {
		this.identifier = identifier;
		header = new EventHeader();
	}
	
	public String getIdentifier() {
		return this.identifier;
	}
	
	public EventHeader getHeader() {
		return header;
	}
	
}