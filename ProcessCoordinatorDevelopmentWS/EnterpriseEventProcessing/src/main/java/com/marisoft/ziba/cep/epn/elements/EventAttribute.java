package com.marisoft.ziba.cep.epn.elements;

public class EventAttribute {

	private String name;
	private Class<?> dataType;
	private AttributeSemanticRole semanticRole;
	
	public EventAttribute() {		
		semanticRole = AttributeSemanticRole.CommonAttribute;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class<?> getDataType() {
		return dataType;
	}

	public void setDataType(Class<?> dataType) {
		this.dataType = dataType;
	}

	public AttributeSemanticRole getSemanticRole() {
		return semanticRole;
	}

	public void setSemanticRole(AttributeSemanticRole semanticRole) {
		this.semanticRole = semanticRole;
	}	
}
