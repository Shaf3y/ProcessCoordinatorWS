package com.marisoft.ziba.cep.epn.elements.apis;

import java.util.Iterator;

public interface IEventConsumer extends IEPNElement {
	
	Iterator<? extends IEventChannel> getInChannels();
	
}
