package com.marisoft.ziba.cep.data.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.marisoft.ziba.cep.epn.elements.EventChannel;

public interface EventChannelRep extends PagingAndSortingRepository<EventChannel, String> {
	
}
