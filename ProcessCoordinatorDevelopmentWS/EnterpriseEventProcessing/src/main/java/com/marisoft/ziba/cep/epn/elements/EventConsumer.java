package com.marisoft.ziba.cep.epn.elements;

import java.util.List;

import com.marisoft.ziba.cep.epn.elements.apis.IEventChannel;
import com.marisoft.ziba.cep.epn.elements.apis.IEventConsumer;

public class EventConsumer implements IEventConsumer {

	private String identifier;
	private ElementType type;
	private String description;
	private List<IEventChannel> inChannels;

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
	
	public List<IEventChannel> getInChannels() {
		return inChannels;
	}

}
