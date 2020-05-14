package com.smart.rabbitmq.direct.config;

import com.smart.rabbitmq.direct.comsumer.DirectConsumer;
import com.smart.rabbitmq.fanout.config.FanoutMqBeanConfig;
import com.smart.rabbitmq.fanout.consumer.FanoutConsumer;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @version V1.0
 * @title: MessageListenerConfig
 * @description: Rabbitmq监听器配置
 * @author: lukewei
 * @date: 2020/4/10 9:48
 * @remark: 修改内容
 */
@Configuration
public class DirectListenerConfig {

    @Autowired
    private CachingConnectionFactory connectionFactory;

    @Autowired
    private DirectMqBeanConfig directMqBeanConfig;

    @Autowired
    private DirectConsumer directConsumer;

//    @Autowired
//    private DirectDeadConsumer directDeadConsumer;

    @Bean
    public SimpleMessageListenerContainer simpleMessageDirectListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConcurrentConsumers(1);
        container.setMaxConcurrentConsumers(1);
        // RabbitMQ默认是自动确认，这里改为手动确认消息
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setQueues(directMqBeanConfig.directQueue(),directMqBeanConfig.directDeadQueue());
        container.setMessageListener(directConsumer);
        return container;
    }
}
