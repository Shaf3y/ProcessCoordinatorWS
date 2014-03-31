package com.marisoft.ziba.jms;

import java.io.File;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

public class EsperApp {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/consumer-context.xml");
		File file = applicationContext.getResource("META-INF/esper.cfg.xml").getFile();
		
		Configuration configuration = new Configuration();
		configuration.configure(file);
		
		EPServiceProvider cepService = EPServiceProviderManager.getProvider("BusinessProcessEvents", configuration);
		EPRuntime cepServiceRT = cepService.getEPRuntime();
		EPAdministrator cepAdmin = cepService.getEPAdministrator();
		
		EPStatement stmt = cepAdmin.createEPL("select * from MyInputEvent");
		stmt.addListener(new MyInputEventListener());
		
		
		System.out.println("Loaded Successfully");
	}

}
