package com.marisoft.ziba;

import java.io.File;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.espertech.esper.client.Configuration;

public class EsperApp {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext();
		File file = applicationContext.getResource("META-INF/esper.cfg.xml").getFile();
		Configuration configuration = new Configuration();
		configuration.configure(file);
		
	}

}
