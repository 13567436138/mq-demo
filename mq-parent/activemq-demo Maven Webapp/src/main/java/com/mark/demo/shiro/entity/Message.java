package com.mark.demo.shiro.entity;

import com.mark.demo.shiro.base.GenericEntity;

/*
*hxp(hxpwangyi@126.com)
*2017年9月18日
*
*/
public class Message extends GenericEntity {
	private static final long serialVersionUID = -3153003910064446826L;

	private String context;
	private Long receiveTime;
	private String receiver;
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Long getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Long receiveTime) {
		this.receiveTime = receiveTime;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
	
}
