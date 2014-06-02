package com.marisoft.ziba.cep.services.apis;

import com.marisoft.ziba.cep.epn.elements.apis.IEventProducer;

public interface EPNResolvingService {
	IEventProducer resolveEventProducer(String identifier) throws Exception;
}
