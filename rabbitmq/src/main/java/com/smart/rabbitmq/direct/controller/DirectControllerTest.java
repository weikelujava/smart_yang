package com.smart.rabbitmq.direct.controller;

import com.smart.rabbitmq.common.CommonEntity;
import com.smart.rabbitmq.direct.config.DirectMqBeanConfig;
import com.smart.rabbitmq.direct.producer.DirectMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: DirectControllerTest
 * @description:
 * @author: lukewei
 * @date: 2020/5/14 17:59
 * @remark: 修改内容
 */
@RestController
public class DirectControllerTest {

    @Autowired
    private DirectMqSender directMqSender;

    @GetMapping("/direct/send")
    public void sendMessageTest(){

        Long id = System.currentTimeMillis()+ UUID.randomUUID().hashCode();
        String context = "张学友 --> 李香兰 --> 饿狼传说:"+id;
        CommonEntity commonEntity = new CommonEntity();
        commonEntity.setCacheKey("redis:test");
        //设置全局messageId
        commonEntity.setMessageId(id);
        // 定义需要缓存的 对象
        commonEntity.setObject(context);
        // 定义当前对象的 DB version 和 Redis中的 version
        commonEntity.setDbEntityVersion(1);
        commonEntity.setRedisEntityVersion(0);
        directMqSender.sendMessage(commonEntity);
    }
}
