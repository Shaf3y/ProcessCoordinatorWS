package com.marisoft.ziba.cep.epn.artifacts.apis;

import java.io.Serializable;

import com.marisoft.ziba.cep.epn.artifacts.EventBody;
import com.marisoft.ziba.cep.epn.artifacts.EventHeader;

public interface IEvent extends Serializable {
	String getIdentifier();
	EventHeader getHeader();
	EventBody getBody();
}
