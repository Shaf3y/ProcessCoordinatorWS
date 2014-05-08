package com.marisoft.ziba.cep.elements.apis;

import java.util.List;

import com.marisoft.ziba.cep.elements.RoutingScheme;

public interface IEventChannel extends IEPNElement {

	RoutingScheme getRoutingScheme();
	List<IEventType> getEventTypes();
	List<IEventProducer> getSources();
	List<IEventConsumer> getTargets();
	void subscribe(IEventConsumer consumer, IEventType event);
	void publish(IEventProducer producer, IEventType event);
}
