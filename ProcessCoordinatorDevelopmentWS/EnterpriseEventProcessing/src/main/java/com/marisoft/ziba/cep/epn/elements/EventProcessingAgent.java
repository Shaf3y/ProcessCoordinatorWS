package com.marisoft.ziba.cep.epn.elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.marisoft.ziba.cep.epn.elements.apis.IEventChannel;
import com.marisoft.ziba.cep.epn.elements.apis.IEventProcessingAgent;
import com.marisoft.ziba.cep.epn.exceptions.DuplicateInputChannel;
import com.marisoft.ziba.cep.epn.exceptions.DuplicateOutputChannel;

public abstract class EventProcessingAgent implements IEventProcessingAgent {

	/** [R] Uniquely identifies agent */
	@Id
	private String identifier;	
	
	private String description;	
	private ElementType type;
	
	@Transient
	private boolean started;
	
	@DBRef
	private List<EventChannel> inChannels;
	
	@DBRef
	private List<EventChannel> outChannels;
	
	public EventProcessingAgent() {
		this.inChannels = new ArrayList<EventChannel>();
		this.outChannels = new ArrayList<EventChannel>();
	}

	public String getIdentifier() {
		return this.identifier;
	}
	
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	public String getDescription() {		
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ElementType getType() {
		return type;
	}
	
	public void setType(ElementType type) {
		this.type = type;
	}
	
	public void addInChannel(EventChannel channel) throws DuplicateInputChannel {
		
		for (EventChannel eventChannel : inChannels) {
			if (eventChannel.getIdentifier().equals(channel.getIdentifier())) {
				throw new DuplicateInputChannel(channel.getIdentifier(), getIdentifier());
			}
		}
		
		this.inChannels.add(channel);
	}
	
	public boolean removeInChannel(String channelId) {
		boolean removed = false;
		
		for (EventChannel channel : inChannels) {
			
			if (channel.getIdentifier().equals(channelId)) {
				removed = inChannels.remove(channel);
				break;
			}
			
		}
		
		return removed;
	}
	
	public Iterator<? extends IEventChannel> getInChannels() {
		return this.inChannels.iterator();
	}
	
	public void addOutChannel(EventChannel channel) throws DuplicateOutputChannel {
		
		for (EventChannel eventChannel : outChannels) {
			if (eventChannel.getIdentifier().equals(channel.getIdentifier())) {
				throw new DuplicateOutputChannel(channel.getIdentifier(), getIdentifier());
			}
		}
		
		this.inChannels.add(channel);
	}
	
	public boolean removeOutChannel(String channelId) {
		boolean removed = false;
		
		for (EventChannel channel : inChannels) {
			
			if (channel.getIdentifier().equals(channelId)) {
				removed = outChannels.remove(channel);
				break;
			}
			
		}
		
		return removed;
	}
	
	public Iterator<? extends IEventChannel> getOutChannels() {		
		return this.outChannels.iterator();
	}
	
	public boolean isStarted() {
		return this.started;
	}
}
