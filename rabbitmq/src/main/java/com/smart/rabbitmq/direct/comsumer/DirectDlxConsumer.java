package com.smart.rabbitmq.direct.comsumer;

import com.rabbitmq.client.Channel;
import com.smart.rabbitmq.direct.config.QueueStatement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: DirectDlxConsumer
 * @description: 死信队列消费
 * @author: lukewei
 * @date: 2020/5/14 20:58
 * @remark: 修改内容
 */
@Slf4j
@Component
public class DirectDlxConsumer {

    @RabbitListener(queues = QueueStatement.directDeadQueue)
    public void process(Message message, @Headers Map<String, Object> headers, Channel channel) throws Exception {
        try {
            String msg = new String(message.getBody(), StandardCharsets.UTF_8);
            log.info("Direct Dead 消费信息：【"+msg+"】");
            // 手动签收
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            e.printStackTrace();
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        }
    }
}
