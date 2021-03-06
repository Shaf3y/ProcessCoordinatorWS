package com.marisoft.ziba.cep.epn.artifacts;

import com.marisoft.ziba.cep.epn.elements.EventProcessingAgent;

public abstract class EventProcessingAgentManager {
	
	private EventProcessingAgent agent;
	
	public abstract void start();
	public abstract void stop();
	
	public EventProcessingAgentManager(EventProcessingAgent agent) {
		this.agent = agent;
	}
	
	public EventProcessingAgent getAgent() {
		return agent;
	}	
	
}
