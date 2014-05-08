package com.marisoft.ziba.cep.epn.elements;

import java.util.List;

import com.marisoft.ziba.cep.epn.elements.apis.IEventChannel;
import com.marisoft.ziba.cep.epn.elements.apis.IEventProducer;

public class EventProducer implements IEventProducer {

	private String identifier;
	private ElementType type;
	private String description;
	private boolean queriable;
	private List<IEventChannel> outChannels;

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public ElementType getType() {
		return type;
	}

	public void setType(ElementType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setQueriable(boolean queriable) {
		this.queriable = queriable;
	}
	
	public List<IEventChannel> getOutChannels() {		
		return outChannels;
	}
	
	public boolean isQueriable() {		
		return queriable;
	}
}