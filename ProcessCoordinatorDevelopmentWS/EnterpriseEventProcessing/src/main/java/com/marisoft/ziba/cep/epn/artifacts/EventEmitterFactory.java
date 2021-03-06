package com.marisoft.ziba.cep.epn.artifacts;

import com.marisoft.ziba.cep.epn.artifacts.apis.IEventEmitter;
import com.marisoft.ziba.cep.epn.elements.JmsEventChannel;
import com.marisoft.ziba.cep.epn.elements.apis.IEventChannel;

public class EventEmitterFactory {

	public static IEventEmitter createEmitter(IEventChannel eventChannel) throws Exception {
		IEventEmitter emitter = null;
		
		if(eventChannel instanceof JmsEventChannel) {
			emitter = new JmsEventEmitter((JmsEventChannel) eventChannel);
		} else {
			throw new Exception("Can Not Instantiate EventEmitter", new Exception("UnKnown EventChannel"));
		}		
		
		return emitter;
	}
}
