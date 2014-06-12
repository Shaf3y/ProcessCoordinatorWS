package com.marisoft.ziba.cep.epn.artifacts.apis;

import com.marisoft.ziba.cep.epn.elements.apis.IEventChannel;

public interface IEventEmitter {
	/**
	 * Emits event through EventChannel
	 * @param event
	 * @throws Exception
	 */
	void emit(IEvent event) throws Exception;
	
	IEventChannel getChannel();
}
