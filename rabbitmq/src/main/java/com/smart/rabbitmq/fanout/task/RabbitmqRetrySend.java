package com.smart.rabbitmq.fanout.task;

import com.alibaba.fastjson.JSON;
import com.smart.rabbitmq.common.CommonEntity;
import com.smart.rabbitmq.model.MQMessage;
import com.smart.rabbitmq.service.IMQMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * All rights Reserved
 *
 * @version V1.0
 * @title: RabbitmqRetrySend
 * @description: MQ消息队列发送失败后的补偿机制类
 * @author: lukewei
 * @date: 2019/4/10 19:34
 * @remark: 修改内容
 */
@Slf4j
@Component
public class RabbitmqRetrySend {

    /**
     * 原子类
     */
    private static AtomicInteger count = new AtomicInteger();

    @Autowired
    private IMQMessageService mqMessageService;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    /**
     * MQ 消息补偿机制，首次发送失败则使用定时任务 1min 后重新发送
     */
    @Scheduled(cron = "*/60 * * * * ?")
    public void run() {

        List<MQMessage> mqMessages = mqMessageService.findMqMessageFailedList();
        if (mqMessages.size() > 0) {
            for (MQMessage mqMessage : mqMessages) {
                count.incrementAndGet();
                //根据MqMessage的信息通知不同的交换机和消息队列来执行
                String mqExchangeName = mqMessage.getMqExchangeName();
                String routingKey = mqMessage.getRoutingKey();
                String messageStr = mqMessage.getMqMessage();
                CommonEntity commonEntity = JSON.parseObject(String.valueOf(messageStr), CommonEntity.class);
                CorrelationData correlationData = new CorrelationData();
                correlationData.setId(String.valueOf(mqMessage.getId()));
                rabbitTemplate.convertAndSend(mqExchangeName, routingKey, JSON.toJSONString(commonEntity), correlationData);
            }
        }

    }


}
