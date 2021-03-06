package com.marisoft.ziba.cep.epn.artifacts;

import com.marisoft.ziba.cep.epn.elements.EventProcessingAgent;
import com.marisoft.ziba.cep.epn.elements.EventStreamProcessingAgent;

public class EventProcessingAgentManagerFactory {
	
	public static EventProcessingAgentManager createManager(EventProcessingAgent agent) throws Exception {
		
		if (agent instanceof EventStreamProcessingAgent) {
			return new EventStreamProcessingAgentManager((EventStreamProcessingAgent) agent);
		} else {
			throw new Exception();
		}
		
	}
	
}
