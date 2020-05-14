package com.smart.rabbitmq.direct.producer;

import com.alibaba.fastjson.JSON;
import com.smart.rabbitmq.common.CommonEntity;
import com.smart.rabbitmq.direct.config.QueueStatement;
import com.smart.rabbitmq.service.IMQMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: DirectMqSender
 * @description:
 * @author: lukewei
 * @date: 2020/5/14 17:40
 * @remark: 修改内容
 */
@Slf4j
@Component
public class DirectMqSender {

//    @Value("${mq.pcenter.direct.common.exchange}")
//    private String directExchangeName;
//
//    @Value("${mq.pcenter.direct.common.routingkey}")
//    private String directRoutingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(CommonEntity commonEntity) {

        //标记 correlationData 用于ack确认
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(String.valueOf(commonEntity.getMessageId()));
        // 直接发送到 DirectExchange
        rabbitTemplate.convertAndSend(QueueStatement.directExchangeName, QueueStatement.directRoutingKey, JSON.toJSONString(commonEntity), correlationData);
    }

}
