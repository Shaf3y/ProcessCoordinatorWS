package com.marisoft.ziba.cep.enterprise.bpm.events;

import com.marisoft.ziba.cep.enterprise.bpm.events.bodies.HTaskEventBody;
import com.marisoft.ziba.cep.epn.artifacts.Event;
import com.marisoft.ziba.cep.epn.artifacts.EventBody;

public class HTaskEvent extends Event {

	private HTaskEventBody body;
	
	/** TASK_EVENTS_IDENTIFIERS */
	public static final String TASK_CREATED = "TASK_CREATED";
	public static final String TASK_DELETED = "TASK_DELETED";	
	public static final String TASK_STARTED = "TASK_STARTED";
	public static final String TASK_COMPLETED = "TASK_COMPLETED";
	public static final String TASK_CLAIMED = "TASK_CLAIMED";
	public static final String TASK_TERMINATED = "TASK_TERMINATED";	
	public static final String TASK_FAILED = "TASK_FAILED";
	public static final String TASK_EXPIRED = "TASK_EXPIRED";
	public static final String TASK_WAITING_FOR_SUB_TASK = "TASK_";
	public static final String TASK_SUB_TASKS_COMPLETED = "TASK_SUB_TASKS_COMPLETED";
	public static final String TASK_RESTARTED = "TASK_RESTARTED";
	public static final String TASK_SUSPENED = "TASK_SUSPENED";
	public static final String TASK_RESUMED = "TASK_RESUMED";
	public static final String TASK_UPDATED = "TASK_TASK_UPDATED";
	/** TASK_EVENTS_IDENTIFIERS */
	
	public HTaskEvent(String identifier, Long identity, String source) {
		super(identifier, identity, source);
		body = new HTaskEventBody();
	}
	
	public EventBody getBody() {		
		return this.body;
	}
}
