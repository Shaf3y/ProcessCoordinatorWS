package com.marisoft.ziba.cep.epn.elements;

public class JmsEventChannel extends EventChannel {
	
	private MessagingMode messagingMode;
	private String brokerUri;
	private Integer port;
	private CommunicationProtocol protocol;
	private Integer receiveTimeout;

	public JmsEventChannel() {
		
	}
	
	public MessagingMode getMessagingMode() {
		return messagingMode;
	}
	
	public void setMessagingMode(MessagingMode messagingMode) {
		this.messagingMode = messagingMode;
	}
	
	public String getBrokerUri() {
		return brokerUri;
	}
	
	public void setBrokerUri(String brokerUri) {
		this.brokerUri = brokerUri;
	}
	
	public Integer getPort() {
		return port;
	}
	
	public void setPort(Integer port) {
		this.port = port;
	}
	
	public CommunicationProtocol getProtocol() {
		return protocol;
	}
	
	public void setProtocol(CommunicationProtocol protocol) {
		this.protocol = protocol;
	}
	
	public Integer getReceiveTimeout() {
		return receiveTimeout;
	}
	
	public void setReceiveTimeout(Integer receiveTimeout) {
		this.receiveTimeout = receiveTimeout;
	}
}