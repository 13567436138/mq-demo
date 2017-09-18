package com.mark.demo.shiro.rabbitmq.comsumer;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mark.demo.shiro.constant.MessageType;
import com.mark.demo.shiro.mapper.MessageMapper;

/*
*hxp(hxpwangyi@126.com)
*2017年9月18日
*
*/
@Component
@Transactional
public class QueueListenter implements SessionAwareMessageListener<TextMessage>{
	@Autowired
	private MessageMapper dao;
	@Override
	public void onMessage(TextMessage message, Session session) throws JMSException {
		String msg=((TextMessage)message).getText();
		System.out.println("QueueListenter接收到消息:"+msg);
		com.mark.demo.shiro.entity.Message myMessage=new com.mark.demo.shiro.entity.Message();
		myMessage.setContent(msg);
		myMessage.setReceiveTime(new Date().getTime());
		myMessage.setType(MessageType.QUEUE_TYPE);
		myMessage.setReceiver("mark");
		//myMessage.setReceiver(((User)SecurityUtils.getSubject().getPrincipal()).getUserName());
		dao.insert(myMessage);
	}

}
