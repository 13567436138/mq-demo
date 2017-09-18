package com.mark.demo.shiro.entity;

import com.mark.demo.shiro.base.GenericEntity;

/*
*hxp(hxpwangyi@126.com)
*2017年9月18日
*
*/
public class Message extends GenericEntity {
	private static final long serialVersionUID = -3153003910064446826L;

	private String content;
	private Long receiveTime;
	private String receiver;
	private int type;
	
	private Long receiveTimeStart;
	private Long receiveTimeEnd;
	
	
	
	public Long getReceiveTimeStart() {
		return receiveTimeStart;
	}
	public void setReceiveTimeStart(Long receiveTimeStart) {
		this.receiveTimeStart = receiveTimeStart;
	}
	public Long getReceiveTimeEnd() {
		return receiveTimeEnd;
	}
	public void setReceiveTimeEnd(Long receiveTimeEnd) {
		this.receiveTimeEnd = receiveTimeEnd;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
