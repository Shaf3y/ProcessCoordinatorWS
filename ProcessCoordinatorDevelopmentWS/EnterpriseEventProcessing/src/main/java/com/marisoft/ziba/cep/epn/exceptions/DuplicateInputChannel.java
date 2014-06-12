package com.marisoft.ziba.cep.epn.exceptions;

public class DuplicateInputChannel extends Exception {
	
	/* {%1$s - channelIdentifier}, {%2$s - elementIdentifier} */
	private static final String message = "%1$s is already binded to %2$s as an input channel";
	
	/* [R] Identifier of event channel */
	private String channelIdentifier;
	
	/* [R] Identifier of element {may be agent or producer} which is already binded to the channel*/
	private String elementIdentifier;
	
	/**
	 * @param channelIdentifier: Identifier of event channel 
	 * @param elementIdentifer: Identifier of element {may be agent or producer} which is already binded to the channel
	 */
	public DuplicateInputChannel(String channelIdentifier, String elementIdentifer) {
		this.channelIdentifier = channelIdentifier;
		this.elementIdentifier = elementIdentifer;
	}
	
	@Override
	public String getMessage() {
		return String.format(message, channelIdentifier, elementIdentifier);
	}
}
