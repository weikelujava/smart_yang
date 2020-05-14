package com.smart.rabbitmq.fanout.producer;

import com.alibaba.fastjson.JSON;
import com.smart.rabbitmq.common.CommonEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @version V1.0
 * @title: FanoutMqSender
 * @description:
 * @author: lukewei
 * @date: 2020/4/27 9:38
 * @remark: 修改内容
 */
@Slf4j
@Component
public class FanoutMqSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${mq.pcenter.fanout.common.exchange}")
    private String fanoutExchangeName;

    /**
     * fanout交换机 不需要指定 routingKey
     * @param commonEntity 封装的实体类
     */
    public void sendMessage(CommonEntity commonEntity) {

        //标记 correlationData 用于ack确认
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(String.valueOf(commonEntity.getMessageId()));
        // 直接发送到 FanoutExchange
        rabbitTemplate.convertAndSend(fanoutExchangeName, "", JSON.toJSONString(commonEntity),correlationData);

    }

}
