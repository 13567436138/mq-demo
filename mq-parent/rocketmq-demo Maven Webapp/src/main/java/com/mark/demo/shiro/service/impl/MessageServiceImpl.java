package com.mark.demo.shiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mark.demo.shiro.base.GenericServiceImpl;
import com.mark.demo.shiro.entity.Message;
import com.mark.demo.shiro.mapper.MessageMapper;
import com.mark.demo.shiro.service.MessageService;

/*
*hxp(hxpwangyi@126.com)
*2017年9月18日
*
*/
@Service
public class MessageServiceImpl extends GenericServiceImpl<Message> implements MessageService {
	private MessageMapper mapper;
	
	@Autowired(required=true)
	public MessageServiceImpl(MessageMapper dao){
		super(dao);
		this.mapper=dao;
	}
}
