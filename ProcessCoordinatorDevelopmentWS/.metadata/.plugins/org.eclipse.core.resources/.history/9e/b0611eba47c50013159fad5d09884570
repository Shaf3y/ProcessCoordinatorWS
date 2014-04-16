package com.marisoft.ziba.cep.jms;

import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageListener implements MessageListener {

	@Autowired
	private AtomicInteger counter;

	public void onMessage(Message message) {
		try {
			int messageCount = message.getIntProperty("count");

			if (message instanceof TextMessage) {
				TextMessage tm = (TextMessage) message;
				String msg = tm.getText();

				System.out.println("Processed message '{}'.  value={} "+ msg + " " + messageCount);

				counter.incrementAndGet();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
