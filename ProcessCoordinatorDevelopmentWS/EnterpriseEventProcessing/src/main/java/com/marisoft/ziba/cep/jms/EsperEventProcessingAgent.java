package com.marisoft.ziba.cep.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import com.espertech.esper.adapter.Adapter;
import com.espertech.esper.adapter.AdapterSPI;
import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esperio.jms.SpringJMSTemplateInputAdapter;

public class EsperEventProcessingAgent {
	
	@Autowired
	private SpringJMSTemplateInputAdapter jmsInputAdapter;

	@Autowired
	private JmsTemplate jmsTemplate;
		
	public Adapter getInputAdapter() {
		return this.jmsInputAdapter;
	}
	
	public JmsTemplate getTemplate() {
		return this.jmsTemplate;
	}
		
	public void start() throws Exception {		
		Configuration configuration = new Configuration();
		
		configuration.addEventType("MyInputEvent", MyInputEvent.class);
		
		EPServiceProvider cepService = EPServiceProviderManager.getProvider("BusinessProcessEvents", configuration);
		
		//Starting Input Adapter Programmatically
		if(jmsInputAdapter instanceof AdapterSPI) {
			AdapterSPI inputAdapterSPI = (AdapterSPI) jmsInputAdapter;
			inputAdapterSPI.setEPServiceProvider(cepService);
		}		
		jmsInputAdapter.start();		
		
		EPRuntime cepServiceRT = cepService.getEPRuntime();
		EPAdministrator cepAdmin = cepService.getEPAdministrator();
				
		EPStatement stmt = cepAdmin.createEPL("select * from MyInputEvent");
				
		stmt.addListener(new MyInputEventListener(jmsTemplate));
		
		System.out.println("Loaded Successfully");
	}
	
}
