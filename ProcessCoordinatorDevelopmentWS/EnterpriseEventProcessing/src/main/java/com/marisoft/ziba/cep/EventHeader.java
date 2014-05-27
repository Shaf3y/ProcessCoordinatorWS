package com.marisoft.ziba.cep;

import org.joda.time.DateTime;

public class EventHeader {

	/**
	 * A system generated unique ID for each individual event instance Denotes
	 * an identifier for event occurrence for tracking issues
	 */
	private Long eventIdentity;

	/**
	 * A time stamp with a precision given by the event type's temporal
	 * granularity. Is provided by the event producer or event processing agent
	 * that detects or derives the event.
	 * */
	private Long occurrenceTime;

	private String annotation;
	private String eventSource;
	private Long detectionTime;

	public EventHeader(Long identity) {
		this.eventIdentity = identity;
		
		DateTime currentTime = new DateTime();
		this.occurrenceTime = new Long(currentTime.getMillis());
	}

	public Long getEventIdentity() {
		return eventIdentity;
	}

	public Long getOccurrenceTime() {
		return occurrenceTime;
	}
	
	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public String getEventSource() {
		return eventSource;
	}

	public void setEventSource(String eventSource) {
		this.eventSource = eventSource;
	}

	public Long getDetectionTime() {
		return detectionTime;
	}

	public void setDetectionTime(Long detectionTime) {
		this.detectionTime = detectionTime;
	}
}
