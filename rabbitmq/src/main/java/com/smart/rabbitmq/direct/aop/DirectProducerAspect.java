package com.smart.rabbitmq.direct.aop;

import com.alibaba.fastjson.JSON;
import com.smart.rabbitmq.common.CommonEntity;
import com.smart.rabbitmq.common.MqStatus;
import com.smart.rabbitmq.direct.config.QueueStatement;
import com.smart.rabbitmq.model.MQMessage;
import com.smart.rabbitmq.service.IMQMessageService;
import com.smart.rabbitmq.utils.MqMessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @version V1.0
 * @title: DirectProducerAspect
 * @description:
 * @author: lukewei
 * @date: 2020/4/27 9:43
 * @remark: 修改内容
 */
@Slf4j
@Component
@Aspect
public class DirectProducerAspect {


    @Autowired
    private IMQMessageService messageService;

    /**
     * 消息发送的切入点
     * 没有实际业务，用于before和after advice后的日志处理
     */
    @Pointcut(value = "execution(* com.smart.rabbitmq.direct.producer.*.sendMessage(..))")
    private void sendMessageMethod() {

    }

    /**
     * Before 在核心业务执行前执行，不能阻止核心业务的调用。
     * 业务之前 将消息(正在发送状态)入库
     *
     * @param joinPoint
     * @throws Exception
     */
    @Before(value = "sendMessageMethod()")
    public void beforeAdvice(JoinPoint joinPoint) throws Exception {
        Object[] args = joinPoint.getArgs();
        CommonEntity commonEntity = JSON.parseObject(JSON.toJSONString(args[0]), CommonEntity.class);

        MQMessage mqMessage = MqMessageUtils.conMqMessage(
                commonEntity.getMessageId(),
                JSON.toJSONString(commonEntity),
                commonEntity.getExchangeName(),
                commonEntity.getQueueName(),
                1,
                MqStatus.MESSAGE_SENDING,
                null,
                new Date(),
                null
        );
        messageService.saveMqMessage(mqMessage);
    }

}
