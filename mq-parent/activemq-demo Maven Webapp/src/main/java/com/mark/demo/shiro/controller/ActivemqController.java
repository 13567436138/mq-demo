package com.mark.demo.shiro.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mark.demo.shiro.activemq.producer.queue.QueueSender;
import com.mark.demo.shiro.activemq.producer.topic.TopicSender;
import com.mark.demo.shiro.constant.CommonConst;
import com.mark.demo.shiro.constant.MessageType;
import com.mark.demo.shiro.entity.EnumDescribable;

@Controller
@RequestMapping("/admins/activemq")
public class ActivemqController {
	
	@Resource 
	private QueueSender queueSender;
	@Resource 
	private TopicSender topicSender;
	
	/**
	 * 发送消息到队列
	 * Queue队列：仅有一个订阅者会收到消息，消息一旦被处理就不会存在队列中
	 * @param message
	 * @return String
	 */
	@ResponseBody
	@RequestMapping("/sendMessage")
	public EnumDescribable queueSender(@RequestParam("message")String message,int type){
		try {
			if(type==MessageType.QUEUE_TYPE){
				queueSender.send("mark.queue", message);
			}else if(type==MessageType.TOPIC_TYPE){
				topicSender.send("mark.topic", message);
			}
		} catch (Exception e) {
			return CommonConst.FAIL;
		}
		return CommonConst.SUCCESS;
	}
	
	
}
