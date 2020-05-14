package com.smart.rabbitmq.fanout.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @version V1.0
 * @title: FanoutMqBeanConfig
 * @description:
 * @author: lukewei
 * @date: 2020/4/27 9:36
 * @remark: 修改内容
 */

@Configuration
public class FanoutMqBeanConfig {

    @Value("${mq.pcenter.fanout.common.exchange}")
    private String fanoutExchangeName;

    @Value("${mq.pcenter.fanout.common.queue}")
    private String fanoutQueue;

    /**
     * Fanout 交换机 持久化
     * @return FanoutExchange
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(fanoutExchangeName, true, false);
    }

    /**
     * Fanout 队列 持久化
     * @return
     */
    @Bean
    public Queue fanoutQueue() {
        return new Queue(fanoutQueue,true);
    }

    /**
     * 绑定 FanoutQueue 到 FanoutExchange
     * @return
     */
    @Bean
    public Binding bindingFanoutExchangeFanoutQueue() {
        return BindingBuilder.bind(fanoutQueue()).to(fanoutExchange());
    }
}
