package com.mark.demo.shiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mark.demo.shiro.constant.CommonConst;
import com.mark.demo.shiro.entity.JsonMessage;
import com.mark.demo.shiro.kafkamq.producer.KafkaProducer;
import com.mark.demo.shiro.utils.JsonMessageUtils;

@Controller
@RequestMapping("/admins/activemq")
public class KafkamqController {
	@Autowired
	private KafkaProducer kafkaProducer;
	/**
	 * 发送消息到队列
	 * Queue队列：仅有一个订阅者会收到消息，消息一旦被处理就不会存在队列中
	 * @param message
	 * @return String
	 */
	@ResponseBody
	@RequestMapping("/sendMessage")
	public JsonMessage queueSender(@RequestParam("message")String message,int type){
		kafkaProducer.sendMessage(type, message);
		return JsonMessageUtils.getJsonMessage(CommonConst.SUCCESS);
	}
	
	
}
