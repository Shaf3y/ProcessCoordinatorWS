package com.marisoft.ziba.cep.epn.elements.apis;

import java.util.List;

public interface IEventProducer extends IEPNElement {

	boolean isQueriable();
	List<IEventChannel> getOutChannels();
}
