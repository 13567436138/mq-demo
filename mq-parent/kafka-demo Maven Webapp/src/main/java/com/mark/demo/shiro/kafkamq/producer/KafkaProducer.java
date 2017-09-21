package com.mark.demo.shiro.kafkamq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/*
*hxp(hxpwangyi@126.com)
*2017年9月21日
*
*/
@Component
public class KafkaProducer {
	@Autowired  
    private KafkaTemplate<Integer, String> kafkaTemplate;
	
	public void sendMessage(Integer key,String value){
		kafkaTemplate.sendDefault(1, value);
	}
}
