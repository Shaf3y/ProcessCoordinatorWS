package com.marisoft.ziba.cep.elements;

public class EventProducer {

	private String identifier;
	private ElementType type;
	private String description;
	private Boolean queriable;

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public ElementType getType() {
		return type;
	}

	public void setType(ElementType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getQueriable() {
		return queriable;
	}

	public void setQueriable(Boolean queriable) {
		this.queriable = queriable;
	}
}
