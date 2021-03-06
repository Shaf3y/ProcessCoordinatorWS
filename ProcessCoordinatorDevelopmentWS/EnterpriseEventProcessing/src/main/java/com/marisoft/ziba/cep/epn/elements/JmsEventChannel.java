package com.marisoft.ziba.cep.epn.elements;


public class JmsEventChannel extends EventChannel {
	
	private MessagingMode messagingMode;
	private String host;
	private int port;
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
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}
	
	public void setPort(int port) throws Exception {
		if (port >= 1 && port <= 65535) {
			this.port = port;
		} else {
			throw new Exception("Invalid Port : Must be in range [1 - 65535]");
		}
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
	
	public String getBrokerURL() {
		String brokerUrl = "";
		
		brokerUrl = protocol.name() + "://";
		brokerUrl += host + ":" + port + "/"; 
		
		return brokerUrl;
	}
}
