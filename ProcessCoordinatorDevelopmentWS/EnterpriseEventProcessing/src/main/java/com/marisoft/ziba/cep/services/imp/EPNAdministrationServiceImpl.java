package com.marisoft.ziba.cep.services.imp;

import org.springframework.beans.factory.annotation.Autowired;

import com.marisoft.ziba.cep.data.repositories.EventChannelRepository;
import com.marisoft.ziba.cep.data.repositories.EventProducerRepository;
import com.marisoft.ziba.cep.data.repositories.EventTypeRepository;
import com.marisoft.ziba.cep.epn.elements.EventChannel;
import com.marisoft.ziba.cep.epn.elements.EventProducer;
import com.marisoft.ziba.cep.epn.elements.EventType;
import com.marisoft.ziba.cep.services.apis.EPNAdministrationService;

public class EPNAdministrationServiceImpl implements EPNAdministrationService {

	@Autowired
	private EventTypeRepository typeRepository;
	
	@Autowired
	private EventChannelRepository channelRepository;
	
	@Autowired
	private EventProducerRepository producerRepository;
	
	public EventProducer saveEventProducer(EventProducer producer)
			throws Exception {
		
		if (producer == null) {
			throw new Exception("Invalid Input : " + producer);
		}
		
		producer = producerRepository.save(producer);
		
		return producer;
	}

	public EventChannel saveEventChannel(EventChannel channel) throws Exception {
		
		if (channel == null) {
			throw new Exception("Invalid Input : " + channel);
		}
		
		channel = channelRepository.save(channel);
		
		return channel;
	}

	public EventType saveEventType(EventType type) throws Exception {
		
		if (type == null) {
			throw new Exception("Invalid Input : " + type);
		}
		
		type = typeRepository.save(type);
		
		return type;
	}

	
}
