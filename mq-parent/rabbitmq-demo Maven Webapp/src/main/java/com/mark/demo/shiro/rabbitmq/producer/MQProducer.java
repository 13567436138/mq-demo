package com.mark.demo.shiro.rabbitmq.producer;
/*
*hxp(hxpwangyi@126.com)
*2017年9月18日
*
*/
public interface MQProducer {
	/**
     * 发送消息到指定队列
     * @param queueKey
     * @param object
     */
    public void sendDataToQueue(String queueKey, Object object);
}
