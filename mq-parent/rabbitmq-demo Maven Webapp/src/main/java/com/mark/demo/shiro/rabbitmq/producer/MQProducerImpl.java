package com.mark.demo.shiro.rabbitmq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
*hxp(hxpwangyi@126.com)
*2017年9月18日
*
*/
@Service
public class MQProducerImpl implements MQProducer {
	@Autowired
    private AmqpTemplate amqpTemplate;

	@Override
	public void sendDataToQueue(String queueKey, Object object) {
		amqpTemplate.convertAndSend(queueKey, object);

	}

}
