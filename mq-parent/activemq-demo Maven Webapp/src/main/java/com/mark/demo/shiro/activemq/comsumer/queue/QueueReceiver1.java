package com.mark.demo.shiro.activemq.comsumer.queue;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mark.demo.shiro.constant.MessageType;
import com.mark.demo.shiro.entity.User;
import com.mark.demo.shiro.mapper.MessageMapper;


@Component
@Transactional
public class QueueReceiver1 implements SessionAwareMessageListener<TextMessage> {
	@Autowired
	private MessageMapper dao;
	@Override
	public void onMessage(TextMessage message, Session session) throws JMSException {
			String msg=((TextMessage)message).getText();
			System.out.println("QueueReceiver1接收到消息:"+msg);
			com.mark.demo.shiro.entity.Message myMessage=new com.mark.demo.shiro.entity.Message();
			myMessage.setContent(msg);
			myMessage.setReceiveTime(new Date().getTime());
			myMessage.setType(MessageType.QUEUE_TYPE);
			myMessage.setReceiver("mark");
			//myMessage.setReceiver(((User)SecurityUtils.getSubject().getPrincipal()).getUserName());
			dao.insert(myMessage);
	}
}
