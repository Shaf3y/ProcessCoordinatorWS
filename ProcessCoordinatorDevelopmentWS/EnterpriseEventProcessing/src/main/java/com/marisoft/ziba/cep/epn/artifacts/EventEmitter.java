package com.marisoft.ziba.cep.epn.artifacts;

import com.marisoft.ziba.cep.epn.artifacts.apis.IEventEmitter;
import com.marisoft.ziba.cep.epn.elements.EventChannel;

public abstract class EventEmitter implements IEventEmitter {

	private EventChannel channel;
	
	public EventEmitter(EventChannel channel) {
		this.channel = channel;
	}
	
	public EventChannel getChannel() {
		return channel;
	}
	
}
