package com.marisoft.ziba.cep.epn.elements;

import org.springframework.data.annotation.Id;

public class QueryStatement {

	@Id
	private String identifier;
	private String description;
	private String statement;
	
	public QueryStatement() {
		
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}
}
