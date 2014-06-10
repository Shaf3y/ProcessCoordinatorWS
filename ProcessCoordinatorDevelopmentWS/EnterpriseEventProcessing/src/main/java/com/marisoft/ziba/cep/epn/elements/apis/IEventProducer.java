package com.marisoft.ziba.cep.epn.elements.apis;

import java.util.Iterator;

import com.marisoft.ziba.cep.epn.artifacts.apis.IEvent;

public interface IEventProducer extends IEPNElement {
	
	/**
	 * 
	 * @return
	 */
	boolean isQueriable();
	
	/**
	 * publish event via subscribed event channels.
	 * @param event
	 */
	void publish(IEvent event) throws Exception;
	
	/**
	 * 
	 * @return
	 */
	Iterator<? extends IEventChannel> getOutChannels();
}
