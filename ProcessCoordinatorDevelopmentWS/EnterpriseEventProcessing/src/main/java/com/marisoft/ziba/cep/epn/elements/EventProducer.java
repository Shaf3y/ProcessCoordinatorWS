package com.marisoft.ziba.cep.epn.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.marisoft.ziba.cep.epn.artifacts.EventEmitterFactory;
import com.marisoft.ziba.cep.epn.artifacts.apis.IEvent;
import com.marisoft.ziba.cep.epn.artifacts.apis.IEventEmitter;
import com.marisoft.ziba.cep.epn.elements.apis.IEPNElement;
import com.marisoft.ziba.cep.epn.elements.apis.IEventChannel;
import com.marisoft.ziba.cep.epn.elements.apis.IEventProducer;

/**
 * @author shaf3y
 *
 */
/**
 * @author shaf3y
 *
 */
@Document(collection="EventProducer")
public class EventProducer implements IEventProducer {

	@Id
	private String identifier;
	private ElementType type;
	private String description;
	private boolean queriable;
	
	@DBRef
	private List<EventChannel> outChannels;
	
	@Transient
	private Map<String, IEventEmitter> emitters;
		
	public EventProducer() {
		outChannels = new ArrayList<EventChannel>();
		emitters = new HashMap<String, IEventEmitter>();
	}
	
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
	
	public boolean isQueriable() {		
		return queriable;
	}
	
	public void setQueriable(boolean queriable) {
		this.queriable = queriable;
	}
	
	public void addOutChannel(EventChannel channel) {
		this.outChannels.add(channel);
	}
	
	public void removeOutChannel(String channelId) {
		
		for (IEventChannel outChannel : outChannels) {
			
			if (outChannel.getIdentifier().equals(channelId)) {
				outChannels.remove(outChannel);
				break;
			}
		}
		
	}
	
	public Iterator<? extends IEventChannel> getOutChannels() {
		return outChannels.iterator();
	}		
		
	
	public void publish(IEvent event) throws Exception {
		//Setting producer as event source
		event.getHeader().setSource(identifier);
		
		for(IEventChannel channel : outChannels) {
			
			if (channel.isRegistered(event)) {
				IEventEmitter emitter = emitters.get(channel.getIdentifier());
				
				if (emitter == null) {
					emitter = EventEmitterFactory.createEmitter(channel);
					emitters.put(channel.getIdentifier(), emitter);
				}
				
				emitter.emit(event);
			}
		}
	}
}
