package com.marisoft.ziba.cep.epn.elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.marisoft.ziba.cep.epn.elements.apis.IEventChannel;
import com.marisoft.ziba.cep.epn.elements.apis.IEventConsumer;

@Document(collection="EventConsumer")
public class EventConsumer implements IEventConsumer {

	@Id
	private String identifier;
	private ElementType type;
	private String description;
	
	@DBRef
	private List<EventChannel> inChannels;
	
	public EventConsumer() {
		inChannels = new ArrayList<EventChannel>();
	}

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
	
	public Iterator<? extends IEventChannel> getInChannels() {
		return inChannels.iterator();
	}

}
