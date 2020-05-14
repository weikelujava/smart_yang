package com.smart.rabbitmq.fanout.config;

import com.smart.rabbitmq.fanout.consumer.FanoutConsumer;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *
 * @version V1.0
 * @title: MessageListenerConfig
 * @description: Rabbitmq监听器配置
 * @author: lukewei
 * @date: 2020/4/10 9:48
 * @remark: 修改内容
 */
@Configuration
public class MessageListenerConfig {

    @Autowired
    private CachingConnectionFactory connectionFactory;

    @Autowired
    private FanoutMqBeanConfig fanoutMqBeanConfig;

    @Autowired
    private FanoutConsumer fanoutConsumer;



    @Bean
    public SimpleMessageListenerContainer simpleMessageFanoutListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConcurrentConsumers(1);
        container.setMaxConcurrentConsumers(1);
        // RabbitMQ默认是自动确认，这里改为手动确认消息
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setQueues(fanoutMqBeanConfig.fanoutQueue());
        container.setMessageListener(fanoutConsumer);
        return container;
    }
}
