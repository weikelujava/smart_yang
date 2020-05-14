package com.smart.rabbitmq.utils;


import com.smart.rabbitmq.model.MQMessage;

import java.util.Date;

/**
 *
 * @version V1.0
 * @title: MqMessageUtils
 * @description:
 * @author: lukewei
 * @date: 2020/4/9 15:14
 * @remark: 修改内容
 */
public class MqMessageUtils {

    public static MQMessage conMqMessage(Long id, String mqMessage, String mqExchangeName, String mqQueueName, Integer mqSendCount, Character mqSendStatus, Date mqNextRetry, Date dateCreated, Date dateUpdated){
        MQMessage message = new MQMessage();
        message.setId(id);
        message.setMqMessage(mqMessage);
        message.setMqExchangeName(mqExchangeName);
        message.setMqQueueName(mqQueueName);
        message.setMqSendCount(mqSendCount);
        message.setMqSendStatus(mqSendStatus);
        message.setMqNextRetry(mqNextRetry);
        message.setDateCreated(dateCreated);
        message.setDateUpdated(dateUpdated);
        return message;
    }
}
