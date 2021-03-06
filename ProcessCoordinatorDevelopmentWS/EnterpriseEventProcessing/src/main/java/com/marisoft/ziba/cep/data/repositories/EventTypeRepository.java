package com.marisoft.ziba.cep.data.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.marisoft.ziba.cep.epn.elements.EventType;

public interface EventTypeRepository extends PagingAndSortingRepository<EventType, String> {

}
