package com.smart.rabbitmq.mapper;

import com.smart.rabbitmq.model.MQMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: MQMessageMapper
 * @description:
 * @author: lukewei
 * @date: 2020/4/9 14:55:33
 * @remark: 修改内容
 */
@Mapper
public interface MQMessageMapper extends SuperMapper<MQMessage> {
    /**
     * update mq message's status
     *
     * @param messageId
     * @param status
     * @param dateUpdated
     * @return
     */
    Integer updateStatus(@Param("messageId") Long messageId, @Param("status") Character status, @Param("dateUpdated") Date dateUpdated);

    /**
     * save mqMessage
     * @param mqMessage
     * @return Number of affected rows
     */
    Integer saveMqMessage(MQMessage mqMessage);

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
    Integer findMqMessageSuccessCountByMessageId(@Param("messageId") Long messageId);
}
