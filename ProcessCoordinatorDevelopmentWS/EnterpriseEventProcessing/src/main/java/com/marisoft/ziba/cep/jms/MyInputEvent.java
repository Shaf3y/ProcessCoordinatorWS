package com.marisoft.ziba.cep.jms;

import java.io.Serializable;

public class MyInputEvent implements Serializable {

	private Integer count;
	private String text;
	
	public MyInputEvent(Integer count, String text) {
		this.count = count;
		this.text = text;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	

}
