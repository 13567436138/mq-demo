package com.mark.demo.shiro.kafkamq.comsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

/*
*hxp(hxpwangyi@126.com)
*2017年9月21日
*
*/
public class KafkaConsumer implements MessageListener<Integer, String> {

	@Override
	public void onMessage(ConsumerRecord<Integer, String> record) {
		System.out.println(record.key()+record.value());
	}

}
