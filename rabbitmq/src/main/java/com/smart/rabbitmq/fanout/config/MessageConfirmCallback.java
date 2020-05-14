package com.smart.rabbitmq.fanout.config;

import com.smart.rabbitmq.common.MqStatus;
import com.smart.rabbitmq.fanout.task.RabbitmqRetrySend;
import com.smart.rabbitmq.service.IMQMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 *
 * @version V1.0
 * @title: MessageConfirmCallback
 * @description:
 * @author: lukewei
 * @date: 2020/4/8 9:48
 * @remark: 修改内容
 */
@Slf4j
@Component
public class MessageConfirmCallback implements RabbitTemplate.ConfirmCallback {

    @Autowired
    private IMQMessageService mqMessageService;

    public static MessageConfirmCallback messageConfirmCallback;


    @PostConstruct
    public void init(){
        messageConfirmCallback = this;
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        Long messageId = Long.valueOf(correlationData.getId());
        if (ack) {
            log.info("rabbitmq confirm callback-->服务器确认消息发送成功(ack)");
            //确认成功后，更新mqMess的状态由 正在发送(0) -> 成功(1)
            boolean status = messageConfirmCallback.mqMessageService.updateStatus(messageId, MqStatus.MESSAGE_SEND_SUCCESS, new Date());
            if (status) {
                log.info("update mqMessage status(send_success) successful ");
            } else {
                log.info("update mqMessage status(send_success) failed ");
            }
        } else {
            log.error("rabbitmq confirm callback-->服务器确认消息发送失败(nack)");
            boolean status = messageConfirmCallback.mqMessageService.updateStatus(messageId, MqStatus.MESSAGE_SEND_FAILURE, new Date());
            if (status) {
                log.info("update mqMessage status(send_failure) successful ");
            } else {
                log.info("update mqMessage status(send_failure) failed ");
            }
        }
    }
}
