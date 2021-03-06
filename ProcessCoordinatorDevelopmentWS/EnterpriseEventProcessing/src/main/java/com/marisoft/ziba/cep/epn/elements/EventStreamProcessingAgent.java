package com.marisoft.ziba.cep.epn.elements;

import java.util.Iterator;
import java.util.List;

public class EventStreamProcessingAgent extends EventProcessingAgent {

	private List<QueryStatement> statements;
	
	public void start() {
		// TODO Auto-generated method stub
		
	}
	 
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	
	public void addStatement(QueryStatement statement) {
		this.statements.add(statement);
	}
	
	public boolean removeStatement(String statmentId) {
		boolean removed = false;		
		
		for (QueryStatement statement : statements) {
			
			if (statement.getIdentifier().equals(statmentId)) {
				removed = statements.remove(statement);
				break;
			}
			
		}
		
		return removed;
	}
	
	public Iterator<QueryStatement> getStatements() {
		return this.statements.iterator();
	}
}
