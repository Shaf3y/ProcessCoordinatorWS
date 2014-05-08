package com.marisoft.ziba.cep;

public class EventHeader {

	/** A system generated unique ID for each individual event instance
	 * Denotes an identifier for event occurrence for tracking issues */
	private Long eventIdentity;
	
	/** A time stamp with a precision given by the event type's temporal
	 * granularity. Is provided by the event producer or event processing
	 * agent that detects or derives the event.
	 * 	*/
	private Long occurrenceTime;
		
	private String annotation;
	private String eventSource;
	private Long detectionTime;
	
}