package com.marisoft.ziba.cep.services.apis;

import com.marisoft.ziba.cep.epn.elements.EventChannel;
import com.marisoft.ziba.cep.epn.elements.EventProducer;
import com.marisoft.ziba.cep.epn.elements.EventType;

public interface EPNAdministrationService {
	EventProducer saveEventProducer(EventProducer producer) throws Exception;
	EventChannel saveEventChannel(EventChannel channel) throws Exception;
	EventType saveEventType(EventType eventType) throws Exception;
}
