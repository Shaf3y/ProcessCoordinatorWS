package com.marisoft.ziba.cep.epn.artifacts.apis;

import com.marisoft.ziba.cep.epn.artifacts.EventBody;
import com.marisoft.ziba.cep.epn.artifacts.EventHeader;

public interface IEvent {
	String getIdentifier();
	EventHeader getHeader();
	EventBody getBody();
}
