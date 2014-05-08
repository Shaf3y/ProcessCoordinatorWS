package com.marisoft.ziba.cep.epn.elements;

public class EventAttribute {

	private String attributeName;
	private Class<?> dataType;
	private AttributeSemanticRole semanticRole;	
	
	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
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
