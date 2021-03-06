package com.marisoft.ziba.cep.epn.artifacts;

import org.joda.time.DateTime;

public class EventHeader {

	/**
	 * A system generated unique ID for each individual event instance Denotes
	 * an identifier for event occurrence for tracking issues
	 */
	private Long identity;

	/** Records the time at which the event */
	private Long occurrenceTime;

	/** Provides a free-text explanation of what happened in this particular event */
	private String annotation;
	
	/** The identifier of the element {Producer - Agent} that originated this event */
	private String source;
	
	/** Records time at which the agent has detected the event */
	private Long detectionTime;

	public EventHeader(Long identity, String source) {
		this.identity = identity;
		occurrenceTime = new DateTime().getMillis();
		this.source = source;
	}

	public Long getIdentity() {
		return identity;
	}

	public void setIdentity(Long identity) {
		this.identity = identity;
	}

	public Long getOccurrenceTime() {
		return occurrenceTime;
	}

	public void setOccurrenceTime(Long occurrenceTime) {
		this.occurrenceTime = occurrenceTime;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Long getDetectionTime() {
		return detectionTime;
	}

	public void setDetectionTime(Long detectionTime) {
		this.detectionTime = detectionTime;
	}
}
