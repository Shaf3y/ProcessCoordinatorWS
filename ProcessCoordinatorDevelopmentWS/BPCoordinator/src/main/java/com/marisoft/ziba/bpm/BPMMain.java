package com.marisoft.ziba.bpm;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.FormService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.StartFormData;
import org.activiti.engine.impl.form.DateFormType;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.marisoft.ziba.bpe.api.BusinessProcessEngineDelegate;

public class BPMMain {

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/bpcoordinator-context.xml");
		
//		IBPCoordinator coordinator = (IBPCoordinator) applicationContext.getBean("eventBasedBPCoordinator");
//		Thread.sleep(30000);
		
		BusinessProcessEngineDelegate engineDelegate = (BusinessProcessEngineDelegate) applicationContext.getBean("engineDelegate");
//		BusinessProcessEngineDelegate engineDelegate = new BusinessProcessEngineActiviti();
		
		/*
		try {
			engineDelegate.completeTask("Approval request created by kermit:2", "kermit");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//*/
		
		
		String processDefId = "simpleApprovalProcess:1:40";
		
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("approver", "fozzie");
		
		properties.put("difficulty", "6");	
		
		properties.put("instructions", "to do");
		properties.put("duedate", new Date());
		
		ProcessEngine processEngine = engineDelegate.getEngine();
		
		/*
		FormService formService = processEngine.getFormService();		
		
		StartFormData startFormData = formService.getStartFormData(processDefId);
		for(FormProperty property : startFormData.getFormProperties()) {
			System.out.println("Prop ID : " + property.getId());
			System.out.println("Type : " + property.getType().toString());
		}
		//*/
		
		//*
		engineDelegate.setAuthenticatedUserId("kermit");
		
		ProcessInstance instance =
				processEngine.getRuntimeService().startProcessInstanceById(processDefId, properties);
		
		System.out.println("Instance : " + instance.getId());
		//*/
		
		
//		Map<String, Object> vars = new HashMap<String, Object>();
//		vars.put("duedate", new Date());
//		
//		vars.put("approver", "fozzie");
//		vars.put("initiator", "kermit");
//		vars.put("difficulty", "3");
//		vars.put("instructions", "5");
//		vars.put("UserID", "kermit");
//		
//		processEngine.getRuntimeService().start
		
		return;
	}
}
