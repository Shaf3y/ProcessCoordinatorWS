package com.marisoft.ziba.cep.data.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.marisoft.ziba.cep.epn.elements.EventChannel;

public interface EventChannelRepository extends PagingAndSortingRepository<EventChannel, String> {
	
}
