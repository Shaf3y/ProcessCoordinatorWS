package com.marisoft.ziba.cep.enterprise.bpm.events;

import com.marisoft.ziba.cep.enterprise.bpm.events.bodies.BProcessEventBody;
import com.marisoft.ziba.cep.epn.artifacts.Event;
import com.marisoft.ziba.cep.epn.artifacts.EventBody;

public class BProcessEvent extends Event {

	private BProcessEventBody body;

	/** BUSINESS_PROCESS_EVENTS_IDENTIFIERS */
	private static final String BP_STARTED = "BP_STARTED";
	private static final String BP_SUSPENDED = "BP_SUSPENDED";
	private static final String BP_RESUMED = "BP_RESUMED";
	private static final String BP_COMPLETED = "BP_COMPLETED";
	private static final String BP_TERMINATED = "BP_TERMINATED";
	private static final String BP_RESTARTED = "BP_RESTARTED";
	private static final String BP_DELETED = "BP_DELETED";
	private static final String BP_FAILED = "BP_FAILED";
	private static final String BP_COMPENSATED = "BP_COMPENSATED";
	private static final String BP_COMPENSATION_FAILED = "BP_";
	private static final String BP_EVENT_RECEIVED = "BP_EVENT_RECEIVED";
	private static final String BP_EVENT_ESCALATED = "BP_EVENT_ESCALATED";
	private static final String BP_OWNER_TRANSFERED = "BP_OWNER_TRANSFERED";
	/** BUSINESS_PROCESS_EVENTS_IDENTIFIERS */
	
	public BProcessEvent(String identifier, Long identity) {
		super(identifier, identity);
		body = new BProcessEventBody();
	}

	public EventBody getBody() {
		return body;
	}

}
