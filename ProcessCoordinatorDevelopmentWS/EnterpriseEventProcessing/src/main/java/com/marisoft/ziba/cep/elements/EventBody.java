package com.marisoft.ziba.cep.elements;

import java.util.ArrayList;
import java.util.List;

public class EventBody {
	
	private Applicability openContentIdicator;
	private List<EventAttribute> attributes;	
	
	public EventBody() {
		openContentIdicator = Applicability.NOT_APPLICABLE;
		attributes = new ArrayList<EventAttribute>();
	}

	public Applicability getOpenContentIdicator() {
		return openContentIdicator;
	}

	public void setOpenContentIdicator(Applicability openContentIdicator) {
		this.openContentIdicator = openContentIdicator;
	}

	public List<EventAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<EventAttribute> attributes) {
		this.attributes = attributes;
	}	

}