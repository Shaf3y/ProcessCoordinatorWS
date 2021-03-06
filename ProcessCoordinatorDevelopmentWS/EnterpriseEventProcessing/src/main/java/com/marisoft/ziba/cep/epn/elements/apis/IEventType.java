package com.marisoft.ziba.cep.epn.elements.apis;

import java.util.List;

import com.marisoft.ziba.cep.epn.elements.Applicability;
import com.marisoft.ziba.cep.epn.elements.EventAttribute;
import com.marisoft.ziba.cep.epn.elements.EventRelationship;
import com.marisoft.ziba.cep.epn.elements.TemporalGranularity;

public interface IEventType extends IEPNElement {

	boolean isComposed();
	TemporalGranularity getGranularity();
	Applicability getOpenContentIndicator();
	List<EventAttribute> getPayload();
	List<EventRelationship> getRelationships();
	
}
