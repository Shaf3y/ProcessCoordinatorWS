package com.marisoft.ziba.cep.elements;


public class EventType {

	/** [R] Uniquely identifies the type */
	private String eventTypeIdentifier;

	/** [R] Denotes whether the event type is a composition of other events or not */
	private boolean composed;

	/** [R] Denotes the atom of time from a particular application's point of view */
	private TemporalGranularity granularity;

	/** [R] Event Type's Header */
	private EventHeader header;

	/** [R] Event Type's Body */
	private EventBody body;
	
	public EventType() {
		header = new EventHeader();
		body = new EventBody();
	}

	public String getEventTypeIdentifier() {
		return eventTypeIdentifier;
	}

	public void setEventTypeIdentifier(String eventTypeIdentifier) {
		this.eventTypeIdentifier = eventTypeIdentifier;
	}

	public boolean isComposed() {
		return composed;
	}

	public void setComposed(boolean composed) {
		this.composed = composed;
	}

	public TemporalGranularity getGranularity() {
		return granularity;
	}

	public void setGranularity(TemporalGranularity granularity) {
		this.granularity = granularity;
	}

	public EventHeader getHeader() {
		return header;
	}

	public EventBody getBody() {
		return body;
	}
}
