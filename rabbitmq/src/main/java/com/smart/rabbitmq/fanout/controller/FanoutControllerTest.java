package com.smart.rabbitmq.fanout.controller;

import com.smart.rabbitmq.common.CommonEntity;
import com.smart.rabbitmq.fanout.producer.FanoutMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 *
 * @version V1.0
 * @title: FanoutControllerTest
 * @description:
 * @author: lukewei
 * @date: 2020/5/14 15:05
 * @remark: 修改内容
 */
@RestController
public class FanoutControllerTest {

    @Autowired
    private FanoutMqSender fanoutMqSender;


    @GetMapping("/send")
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
        fanoutMqSender.sendMessage(commonEntity);
    }
}
