package com.marisoft.ziba.cep.services.imp;

import org.springframework.beans.factory.annotation.Autowired;

import com.marisoft.ziba.cep.data.repositories.EventProducerRepository;
import com.marisoft.ziba.cep.epn.elements.apis.IEventProducer;
import com.marisoft.ziba.cep.services.apis.EPNResolvingService;

public class EPNResolvingServiceImpl implements EPNResolvingService {
	
	@Autowired
	private EventProducerRepository producerRep;
	
	public IEventProducer resolveEventProducer(String identifier)
			throws Exception {
		
		if (identifier == null) {
			throw new Exception("Invalid Input : " + identifier);
		}
		
		return producerRep.findOne(identifier);
	}
}
