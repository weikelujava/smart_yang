package com.smart.rabbitmq.direct.comsumer;

import com.rabbitmq.client.Channel;
import com.smart.rabbitmq.direct.config.QueueStatement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 *
 * @version V1.0
 * @title: DirectConsumer
 * @description:     正常Direct消费者
 *                   两个相同的队列消费者只能有一个获取的消息消费
 *                   如果使用该类中的消费者，需要在MessageListenerConfig中配置 消费者监听器
 * @author: lukewei
 * @date: 2020/4/28 12:56
 * @remark: 修改内容
 * @RabbitListener(queues = QueueStatement.directQueue,containerFactory = "simpleMessageDirectListenerContainer")
 */
@Slf4j
@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = QueueStatement.directQueue, durable = "true"),
        exchange = @Exchange(name = QueueStatement.directExchangeName, type = "topic"),
        key = QueueStatement.directRoutingKey))
public class DirectConsumer implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        try {
            String msg = new String(message.getBody(), StandardCharsets.UTF_8);
            log.info("Direct 消费信息：【"+msg+"】");
            //用于测试死信队列
            int a = 1/0;
            // 手动签收
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            e.printStackTrace();
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        }
    }
}
