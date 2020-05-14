package com.smart.rabbitmq.common;

/**
 *
 * @version V1.0
 * @title: MqStatus
 * @description: RabbitMQ 消息状态
 * @author: lukewei
 * @date: 2020/4/9 14:51
 * @remark: 修改内容
 */
public class MqStatus {
    /**
     * 消息开始发送
     */
    public static final Character MESSAGE_SENDING = '0';

    /**
     * 消息发送成功
     */
    public static final Character MESSAGE_SEND_SUCCESS = '1';

    /**
     * 消息发送失败
     */
    public static final Character MESSAGE_SEND_FAILURE = '2';
}
