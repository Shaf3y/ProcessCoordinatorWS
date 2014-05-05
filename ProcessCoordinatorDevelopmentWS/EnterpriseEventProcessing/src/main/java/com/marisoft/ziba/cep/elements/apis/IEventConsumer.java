package com.marisoft.ziba.cep.elements.apis;

import java.util.List;

public interface IEventConsumer extends IEPNElement {

	List<IEventChannel> getInChannels();
}
