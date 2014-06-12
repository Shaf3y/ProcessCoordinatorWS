package com.marisoft.ziba.cep.epn.elements.apis;

import java.util.Iterator;

public interface IEventProcessingAgent extends IEPNElement {
	
	void start();
	void stop();
	Iterator<? extends IEventChannel> getInChannels();
	Iterator<? extends IEventChannel> getOutChannels();
	
}
