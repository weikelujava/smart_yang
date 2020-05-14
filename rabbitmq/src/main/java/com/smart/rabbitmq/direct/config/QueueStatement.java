package com.smart.rabbitmq.direct.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: QueueStatement
 * @description:
 * @author: lukewei
 * @date: 2020/5/14 19:20
 * @remark: 修改内容
 */
public class QueueStatement {

    public static final String directExchangeName = "mq.direct.common.exchange";

    public static final String directQueue = "mq.direct.common.queue";

    public static final String directDeadQueue = "mq.direct.common.queue.dlx";

    public static final String directRoutingKey = "mq.direct.common.routingkey";



}
