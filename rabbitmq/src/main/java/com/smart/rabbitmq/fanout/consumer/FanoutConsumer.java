package com.smart.rabbitmq.fanout.consumer;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 *
 * @version V1.0
 * @title: FanoutConsumer
 * @description:
 *                   两个相同的队列消费者只能有一个获取的消息消费
 *                   如果使用该类中的消费者，需要在MessageListenerConfig中配置 消费者监听器
 * @author: lukewei
 * @date: 2020/4/28 12:56
 * @remark: 修改内容
 */
@Slf4j
@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "${mq.pcenter.fanout.common.queue}", durable = "true"),
    exchange = @Exchange(name = "${mq.pcenter.fanout.common.exchange}", type = "fanout")))
public class FanoutConsumer implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        String msg = new String(message.getBody(), StandardCharsets.UTF_8);
        log.info("消费信息：【"+msg+"】");
        // 手动签收
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
