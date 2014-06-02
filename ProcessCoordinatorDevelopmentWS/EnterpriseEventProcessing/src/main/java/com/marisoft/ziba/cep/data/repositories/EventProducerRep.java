package com.marisoft.ziba.cep.data.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.marisoft.ziba.cep.epn.elements.EventProducer;

public interface EventProducerRep extends PagingAndSortingRepository<EventProducer, String> {

}