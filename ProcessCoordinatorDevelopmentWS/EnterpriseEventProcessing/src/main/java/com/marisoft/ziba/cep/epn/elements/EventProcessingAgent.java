package com.marisoft.ziba.cep.epn.elements;

import java.util.ArrayList;
import java.util.List;

public class EventProcessingAgent {

	/** [R] Uniquely identifies agent */
	private String identifier;	
	
	/** [O] */
	private String description;	
	
	
	private List<EventChannel> channels;
	
	public EventProcessingAgent() {
		this.channels = new ArrayList<EventChannel>();
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<EventChannel> getChannels() {
		return channels;
	}
	
}
