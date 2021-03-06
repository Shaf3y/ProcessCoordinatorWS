package com.marisoft.ziba.cep.epn.elements;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class EventRelationship {
	
	private EventRelationshipType relationship;
	
	@DBRef
	/** Identifier of related event */
	private EventType relatedEvent;
	
	public EventRelationshipType getRelationship() {
		return relationship;
	}

	public void setRelationship(EventRelationshipType relationship) {
		this.relationship = relationship;
	}

	public EventType getRelatedEvent() {
		return relatedEvent;
	}

	public void setRelatedEvent(EventType relatedEvent) {
		this.relatedEvent = relatedEvent;
	}	
}
