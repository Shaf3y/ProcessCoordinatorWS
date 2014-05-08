package com.marisoft.ziba.cep.epn.elements;

public class EventRelationship {
	private EventRelationshipType relationship;
	
	/** Identifier of related event */
	private String relatedEvent;
	
	public EventRelationship() {
		
	}	

	public EventRelationshipType getRelationship() {
		return relationship;
	}

	public void setRelationship(EventRelationshipType relationship) {
		this.relationship = relationship;
	}

	public String getRelatedEvent() {
		return relatedEvent;
	}

	public void setRelatedEvent(String relatedEvent) {
		this.relatedEvent = relatedEvent;
	}	
}
