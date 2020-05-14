package com.smart.rabbitmq.direct.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @version V1.0
 * @title: DirectMqBeanConfig
 * @description:
 * @author: lukewei
 * @date: 2020/5/14 17:02
 * @remark: 修改内容
 */
@Configuration
public class DirectMqBeanConfig {

    /**
     * 死信队列交换机标识符
     */
    public static final String DEAD_LETTER_QUEUE_KEY = "x_dead_letter_exchange";

    /**
     * 死信队列 交换机绑定键标识符
     */
    public static final String DEAD_LETTER_ROUTING_KEY = "x_dead_letter_routing_key";


    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(QueueStatement.directExchangeName,true,false);
    }

    @Bean
    public Queue directDeadQueue(){
        return new Queue(QueueStatement.directDeadQueue,true);
    }

    @Bean
    public Queue directQueue() {
        Map<String,Object> args = new HashMap<>(1);
        args.put(DEAD_LETTER_QUEUE_KEY,QueueStatement.directExchangeName);
        args.put(DEAD_LETTER_ROUTING_KEY,QueueStatement.directRoutingKey);
        return new Queue(QueueStatement.directQueue,true,false,false,args);
    }
    @Bean
    public Binding bindingDirectExchange(){
        return BindingBuilder.bind(directQueue()).to(directExchange()).with(QueueStatement.directRoutingKey);
    }
    @Bean
    public Binding bindingDirectDeadExchange(){
        return BindingBuilder.bind(directDeadQueue()).to(directExchange()).with(QueueStatement.directRoutingKey);
    }

    @Bean
    public static MessageConverter getMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


}
