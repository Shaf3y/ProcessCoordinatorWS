package com.marisoft.ziba.cep.epn.elements.apis;

import java.util.List;

public interface IEventConsumer extends IEPNElement {

	List<IEventChannel> getInChannels();
}
