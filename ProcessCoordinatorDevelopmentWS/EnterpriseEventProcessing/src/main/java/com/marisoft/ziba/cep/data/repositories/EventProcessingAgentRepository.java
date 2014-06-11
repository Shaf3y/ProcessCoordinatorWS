package com.marisoft.ziba.cep.data.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.marisoft.ziba.cep.epn.elements.EventProcessingAgent;

public interface EventProcessingAgentRepository extends PagingAndSortingRepository<EventProcessingAgent, String>{

}
