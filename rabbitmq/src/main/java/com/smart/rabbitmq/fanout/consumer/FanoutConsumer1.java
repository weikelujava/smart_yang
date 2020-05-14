package com.smart.rabbitmq.fanout.consumer;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 *
 * @version V1.0
 * @title: FanoutConsumer1
 * @description:  两个相同的队列消费者只能有一个获取的消息消费
 *                如果使用该类中的消费者，不需要在MessageListenerConfig中配置 消费者监听器
 * @author: lukewei
 * @date: 2020/4/28 12:56
 * @remark: 修改内容
 */
@Slf4j
@Component
public class FanoutConsumer1 {

//    @RabbitListener(queues = "${mq.pcenter.fanout.common.queue}")
    public void process(Message message, @Headers Map<String, Object> headers, Channel channel) throws Exception {
        String msg = new String(message.getBody(), StandardCharsets.UTF_8);
        System.out.println("Fanout1 消费信息：【"+msg+"】");
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

}
