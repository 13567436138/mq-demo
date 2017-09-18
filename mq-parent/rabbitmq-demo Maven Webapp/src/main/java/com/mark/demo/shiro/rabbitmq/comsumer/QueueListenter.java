package com.mark.demo.shiro.rabbitmq.comsumer;

import java.util.Date;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mark.demo.shiro.constant.MessageType;
import com.mark.demo.shiro.mapper.MessageMapper;
import com.rabbitmq.client.Channel;

/*
*hxp(hxpwangyi@126.com)
*2017年9月18日
*
*/
@Component
public class QueueListenter{
	@Autowired
	private MessageMapper dao;

	
	@RabbitListener(queues = "markQueue")
    public void hello(Message message,Channel channel)throws Exception {
		try{
	        System.out.println("Received request for id " );
	        System.out.println("Received request for job name ");
	        
	        String msg=new String(message.getBody(),"UTF-8");
			System.out.println("QueueListenter接收到消息:"+msg);
			com.mark.demo.shiro.entity.Message myMessage=new com.mark.demo.shiro.entity.Message();
			myMessage.setContent(msg);
			myMessage.setReceiveTime(new Date().getTime());
			myMessage.setType(MessageType.QUEUE_TYPE);
			myMessage.setReceiver("mark");
			//myMessage.setReceiver(((User)SecurityUtils.getSubject().getPrincipal()).getUserName());
			dao.insert(myMessage);
		}finally{
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		}
    }

}
