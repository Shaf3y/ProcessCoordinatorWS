package com.marisoft.ziba.cep.epn.elements;

import java.util.ArrayList;
import java.util.List;

import com.marisoft.ziba.cep.EventBody;
import com.marisoft.ziba.cep.EventHeader;
import com.marisoft.ziba.cep.epn.elements.apis.IEventType;


public class EventType implements IEventType {

	/** [R] Uniquely identifies the type */
	private String identifier;
	
	private String description;
	
	private ElementType type;

	/** [R] Specifies whether the event type is a composition of other events or not */
	private boolean composed;

	/** [R] Specifies the atom of time from a particular application's point of view */
	private TemporalGranularity granularity;

	/** [R] Denotes applicability of payload  */
	private Applicability openContentIndicator;
	
	/** [R] Event's Payload Attributes [Attributes of Event Body] */
	private List<EventAttribute> payload;
	
	/** [R] Event's relationships with other events */
	private List<EventRelationship> relationships;
	
	public EventType() {
		payload = new ArrayList<EventAttribute>();
	}
	
	public String getIdentifier() {		
		return this.identifier;
	}
	
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public ElementType getType() {
		return this.type;
	}
	
	public void setType(ElementType type) {
		this.type = type;
	}
	
	public void setDescription(String description) {
		this.description = description;
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

	public Applicability getOpenContentIndicator() {		
		return this.openContentIndicator;
	}
	
	public List<EventAttribute> getPayload() {
		return this.payload;
	}
	
	public List<EventRelationship> getRelationships() {
		return this.relationships;
	}
}