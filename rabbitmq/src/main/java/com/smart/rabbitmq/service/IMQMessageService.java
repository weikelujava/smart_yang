package com.smart.rabbitmq.service;


import com.smart.rabbitmq.model.MQMessage;

import java.util.Date;
import java.util.List;

/**
 *
 * @version V1.0
 * @title: IMQMessageService
 * @description:
 * @author: lukewei
 * @date: 2020/2/14 11:34
 * @remark: 修改内容
 */
public interface IMQMessageService extends ISuperService<MQMessage> {

    /**
     * 更新MQ消息发送状态
     *
     * @param messageId messageId
     * @param status status
     * @param dateUpdated dateUpdated
     * @return true or false
     */
    boolean updateStatus(Long messageId, Character status, Date dateUpdated);

    /**
     * save MqMessage
     * @param mqMessage MqMessage
     * @return true or false
     */
    boolean saveMqMessage(MQMessage mqMessage);

    /**
     * 0,sending; 1,successful; 2,failed
     * find mqMessages which MQ_SEND_STATUS is 2
     * @return MQMessages
     */
    List<MQMessage> findMqMessageFailedList();

    /**
     * 根据messageId 查询 日志消费成功的消息的数量
     * @param messageId messageId
     * @return
     */
    Integer findMqMessageSuccessCountByMessageId(Long messageId);
}

