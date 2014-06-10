package com.marisoft.ziba.cep.epn.elements.apis;

import java.util.Iterator;

import com.marisoft.ziba.cep.epn.artifacts.apis.IEvent;
import com.marisoft.ziba.cep.epn.elements.RoutingScheme;

public interface IEventChannel extends IEPNElement {

	boolean isRegistered(IEvent event);
	RoutingScheme getRoutingScheme();
	Iterator<? extends IEventType> getPublishedEvents();
}
