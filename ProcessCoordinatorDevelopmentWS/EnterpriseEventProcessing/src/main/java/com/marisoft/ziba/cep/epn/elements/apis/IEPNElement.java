package com.marisoft.ziba.cep.epn.elements.apis;

import com.marisoft.ziba.cep.epn.elements.ElementType;

public interface IEPNElement {

	String getIdentifier();
	String getDescription();
	ElementType getType();
}
