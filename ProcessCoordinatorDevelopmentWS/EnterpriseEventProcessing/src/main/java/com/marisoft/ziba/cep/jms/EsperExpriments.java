package com.marisoft.ziba.cep.jms;

import java.util.HashMap;
import java.util.Map;

import com.espertech.esper.client.Configuration;

public class EsperExpriments {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		Map<String, Object> typeMap = new HashMap<String, Object>();
		configuration.addEventType("inputEvent", typeMap);
	}
}
