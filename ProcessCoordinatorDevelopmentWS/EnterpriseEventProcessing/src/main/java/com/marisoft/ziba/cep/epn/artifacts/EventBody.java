package com.marisoft.ziba.cep.epn.artifacts;

import java.util.HashMap;
import java.util.Map;


public abstract class EventBody {
	
	private Map<String, Object> openContent;
	
	public EventBody() {
		openContent = new HashMap<String, Object>();
	}
	
	public Map<String, Object> getOpenContent() {
		return openContent;
	}
}
