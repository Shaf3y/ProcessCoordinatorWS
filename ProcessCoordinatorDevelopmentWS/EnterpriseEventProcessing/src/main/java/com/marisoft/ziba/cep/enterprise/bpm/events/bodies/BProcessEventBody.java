package com.marisoft.ziba.cep.enterprise.bpm.events.bodies;

import java.io.Serializable;
import java.util.Map;

import com.marisoft.ziba.cep.epn.artifacts.EventBody;

public class BProcessEventBody extends EventBody {

	/** The ID of process definition */	
	private String processIdentifier;
	
	/** The ID of process instance */
	private String instanceId;
	
	/** The business key of process instance */
	private String businessKey;
	
	/** The tenant identifier of process instance, its related to multi-tenant business processes */
	private String tenantId;
	
	/** Process Variables */
	private Map<String, Serializable> variables;	

	public String getProcessIdentifier() {
		return processIdentifier;
	}

	public void setProcessIdentifier(String processIdentifier) {
		this.processIdentifier = processIdentifier;
	}
	
	public Map<String, Serializable> getVariables() {
		return variables;
	}

	public void setVariables(Map<String, Serializable> variables) {
		this.variables = variables;
	}

	public String getBusinessKey() {
		return businessKey;
	}

	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}
}
